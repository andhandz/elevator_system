import java.util.Random;

public class simulation_engine {
    private final int no_elevators;
    private final int no_steps;
    private final int max_no_pickups_for_step;

    public simulation_engine(int no_elevators, int no_steps, int max_no_pickups_for_step){
        this.no_elevators=no_elevators;
        this.no_steps=no_steps;
        this.max_no_pickups_for_step=max_no_pickups_for_step;
    }

    public void run() {
        elevatorSystem system = new elevatorSystem();
        for(int i = 0; i<no_elevators; i++){
            system.initialElevator(i);
        }
        for(int i=0; i<no_steps;i++){
            Random draw = new Random();
            int pickups = draw.nextInt(max_no_pickups_for_step);
            system.step(pickups);
        }
    }
}
