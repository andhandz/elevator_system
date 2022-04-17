public class elevator implements Ielevator {
    private int current_level;
    private int levels_to_be_available;
    private int levels_to_take_client;
    private int level_to_go;
    private elevator_direction current_direction;
    private final int elevator_id;
    public elevator(int elevator_id){
        this.current_level=0;
        this.levels_to_be_available=0;
        this.current_direction=elevator_direction.SLEEP;
        this.elevator_id=elevator_id;
    }

    public void setCurrent_level(int new_level){
        this.current_level=new_level;
    }

    public void setlevels_to_be_available(int available){
        this.levels_to_be_available=available;
    }

    public int getlevels_to_be_available() {
        return levels_to_be_available;
    }

    public int getCurrent_level() {
        return current_level;
    }

    public elevator_direction getCurrent_direction() {
        return current_direction;
    }

    public void setCurrent_direction(elevator_direction current_direction) {
        this.current_direction = current_direction;
    }

    public int getLevels_to_take_client() {
        return levels_to_take_client;
    }

    public void setLevels_to_take_client(int levels_to_take_client) {
        this.levels_to_take_client = levels_to_take_client;
    }

    public int getLevel_to_go() {
        return level_to_go;
    }

    public void setLevel_to_go(int level_to_go) {
        this.level_to_go = level_to_go;
    }

    public int getElevator_id() {
        return elevator_id;
    }

    public int[] getStatus(){
        return new int[]{elevator_id,current_level,level_to_go};
    }
}
