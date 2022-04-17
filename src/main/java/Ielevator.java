public interface Ielevator {
    /**
     * Set the elevator's current level
     * @param new_level The elevator's current level after step
     */
    void setCurrent_level(int new_level);
    /**
     * Set the elevator's no levels to be available again
     * @param available The elevator's no levels to be available again
     */
    void setlevels_to_be_available(int available);
    /**
     * Get the elevator's no levels to be available again
     * @return The elevator's no levels to be available again
     */
    int getlevels_to_be_available();
    /**
     * Get the elevator's current level
     * @return The elevator's current level
     */
    int getCurrent_level();
    /**
     * Get the elevator's current direction
     * @return The elevator's current direction
     */
    elevator_direction getCurrent_direction();
    /**
     * Set the elevator's current direction
     * @param current_direction The elevator's current direction
     */
    void setCurrent_direction(elevator_direction current_direction);
    /**
     * Get the elevator's no levels to be on client's level
     * @return The elevator's no levels to be on client's level
     */
    int getLevels_to_take_client();
    /**
     * Set the elevator's no levels to be on client's level
     * @param levels_to_take_client The elevator's no levels to be on client's level
     */
    void setLevels_to_take_client(int levels_to_take_client);
    /**
     * Get the Level, where elevator's client want to go
     * @return The level, where elevator's client want to go
     */
    int getLevel_to_go();
    /**
     * Set the level, where elevator's client want to go
     * @param level_to_go The level, where elevator's client want to go
     */
    void setLevel_to_go(int level_to_go);
    /**
     * Get the number ID of elevator
     * @return The number ID of elevator
     */
    int getElevator_id();
    /**
     * Get the current elevator's status(ID, current level, level to go)
     * @return The current elevator's status(ID, current level, level to go)
     */
    int[] getStatus();
}
