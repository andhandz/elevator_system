import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class elevatorSystem implements IelevatorSystem {
    protected final ArrayList<elevator> elevators = new ArrayList<>();
    protected ArrayList<int[]> waiting_pickups = new ArrayList<>();

    public void initialElevator(int id) {
        elevator elevator_ = new elevator(id);
        elevators.add(elevator_);
    }

    public void pickup(int level, int level_to_go) {
        int[] data = {level, level_to_go};
        waiting_pickups.add(data);
    }

    public void update() {
        int j = 0;
        for (elevator elevator : elevators) {
            if (elevator.getCurrent_direction() == elevator_direction.UP) {
                elevator.setCurrent_level(elevator.getCurrent_level() + 1);
                elevator.setlevels_to_be_available(elevator.getlevels_to_be_available() - 1);
                if (elevator.getLevels_to_take_client() != 0) {
                    elevator.setLevels_to_take_client(elevator.getLevels_to_take_client() - 1);
                    if (elevator.getLevels_to_take_client() == 0
                            && elevator.getCurrent_level() > elevator.getLevel_to_go()) {
                        elevator.setCurrent_direction(elevator_direction.DOWN);
                    }
                }
            } else if (elevator.getCurrent_direction() == elevator_direction.DOWN) {
                elevator.setCurrent_level(elevator.getCurrent_level() - 1);
                elevator.setlevels_to_be_available(elevator.getlevels_to_be_available() - 1);
                if (elevator.getLevels_to_take_client() != 0) {
                    elevator.setLevels_to_take_client(elevator.getLevels_to_take_client() - 1);
                    if (elevator.getLevels_to_take_client() == 0
                            && elevator.getCurrent_level() < elevator.getLevel_to_go()) {
                        elevator.setCurrent_direction(elevator_direction.UP);
                    }
                }
            } else {
                if (j < waiting_pickups.size() - 1) {
                    int lvl_to_go = waiting_pickups.get(j)[1];
                    int curr_lvl = waiting_pickups.get(j)[0];
                    int lvl_to_take_client = Math.abs((elevator.getCurrent_level() - curr_lvl));
                    int lvl_to_available = lvl_to_take_client + Math.abs(lvl_to_go - curr_lvl);
                    elevator_direction dir;
                    if (curr_lvl > elevator.getCurrent_level()) {
                        dir = elevator_direction.UP;
                    } else {
                        dir = elevator_direction.DOWN;
                    }
                    elevator.setlevels_to_be_available(lvl_to_available);
                    elevator.setLevels_to_take_client(lvl_to_take_client);
                    elevator.setCurrent_direction(dir);
                    elevator.setLevel_to_go(lvl_to_go);
                    j++;
                }
            }
            if (elevator.getlevels_to_be_available() == 0) {
                elevator.setCurrent_direction(elevator_direction.SLEEP);
            }
        }
        if (j > 0) {
            waiting_pickups.subList(0, j).clear();
        }
    }

    public void step(int num_of_new_pickups) {
        for (int i = 0; i < num_of_new_pickups; i++) {
            Random draw = new Random();
            int curr_level = draw.nextInt(100);
            int level_to_go = draw.nextInt(100);
            if (curr_level == level_to_go) {
                level_to_go = (level_to_go + 3) % 100;
            }
            pickup(curr_level, level_to_go);
        }
        update();
        showStatus();
    }

    public int[] elevatorStatus(int id) {
        int[] ar = new int[0];
        for (elevator elevator : elevators) {
            if (elevator.getElevator_id() == id) {
                ar = elevator.getStatus();
                break;
            }
        }
        return ar;
    }

    public void showStatus(){
        for(elevator elevator : elevators){
            System.out.println(Arrays.toString(elevatorStatus(elevator.getElevator_id())));
        }
    }

}