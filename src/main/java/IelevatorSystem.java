public interface IelevatorSystem {
    /**
     * Initializing the elevator to the system
     * @param id ID number of the elevator
     */
    void initialElevator(int id);
    /**
     * Requesting for the elevator
     * @param level Client's current level
     * @param level_to_go The level where client wants to go
     */
    void pickup(int level, int level_to_go);
    /**
     * Updating information about elevators
     */
    void update();
    /**
     * Executing one step of the simulation
     * @param num_of_new_pickups no clients call for the elevator in this step
     */
    void step(int num_of_new_pickups);
    /**
     * @param id ID number of the considering elevator
     * @return array [id, current level, level to go]
     */
    int[] elevatorStatus(int id);
    /**
     * Print status of all elevators
     */
    void showStatus();
}
