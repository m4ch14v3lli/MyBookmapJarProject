package velox.api.layer1.data;

/**
 * Enum representing the cross trading status.
 * Used to indicate whether cross trading is currently started or stopped.
 */
public enum CrossTradingStatus {
    
    /**
     * Indicates that cross trading has been started.
     */
    STARTED,
    
    /**
     * Indicates that cross trading has been stopped.
     */
    STOPPED;
    
    /**
     * Returns an array containing the constants of this enum class,
     * in the order they are declared.
     * 
     * @return an array containing the constants of this enum class,
     *         in the order they are declared
     */
    public static CrossTradingStatus[] values() {
        return values();
    }
    
    /**
     * Returns the enum constant of this class with the specified name.
     * The string must match exactly an identifier used to declare an
     * enum constant in this class. (Extraneous whitespace characters are
     * not permitted.)
     * 
     * @param name the name of the enum constant to be returned
     * @return the enum constant with the specified name
     * @throws IllegalArgumentException if this enum class has no constant
     *         with the specified name
     * @throws NullPointerException if the argument is null
     */
    public static CrossTradingStatus valueOf(String name) {
        return valueOf(name);
    }
    
    /**
     * Checks if cross trading is currently active.
     * 
     * @return true if status is STARTED, false otherwise
     */
    public boolean isActive() {
        return this == STARTED;
    }
    
    /**
     * Checks if cross trading is currently stopped.
     * 
     * @return true if status is STOPPED, false otherwise
     */
    public boolean isStopped() {
        return this == STOPPED;
    }
    
    /**
     * Returns a human-readable description of the status.
     * 
     * @return string description of the current status
     */
    public String getDescription() {
        switch (this) {
            case STARTED:
                return "Cross trading is currently active";
            case STOPPED:
                return "Cross trading is currently stopped";
            default:
                return "Unknown status";
        }
    }
}