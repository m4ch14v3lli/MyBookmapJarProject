package velox.api.layer1.data;

/**
 * Reason why disconnection happened
 * 
 * @author Velox API Layer1
 * @version 7.6.0
 */
public enum DisconnectionReason {
    
    /**
     * This connection was kicked due to some other new connection above limit.
     * No reconnect should be attempted.
     */
    SIMULTANEOUS_LOGIN,
    
    /**
     * Connection lost due to internet connection issues.
     * Reconnect should be attempted.
     */
    NO_INTERNET,
    
    /**
     * Any other reason, reconnect might or might not be attempted, 
     * in most cases it shouldn't be attempted.
     */
    UNKNOWN,
    
    /**
     * Some reason leading to disconnect.
     * No reconnect should be attempted.
     */
    FATAL;
    
    /**
     * Returns an array containing the constants of this enum class, in
     * the order they are declared.
     * 
     * @return an array containing the constants of this enum class, in the order they are declared
     */
    public static DisconnectionReason[] values() {
        return DisconnectionReason.values();
    }
    
    /**
     * Returns the enum constant of this class with the specified name.
     * The string must match exactly an identifier used to declare an
     * enum constant in this class. (Extraneous whitespace characters are 
     * not permitted.)
     * 
     * @param name the name of the enum constant to be returned
     * @return the enum constant with the specified name
     * @throws IllegalArgumentException if this enum class has no constant with the specified name
     * @throws NullPointerException if the argument is null
     */
    public static DisconnectionReason valueOf(String name) {
        return DisconnectionReason.valueOf(name);
    }
    
    /**
     * Determines if reconnection should be attempted based on the disconnection reason.
     * 
     * @return true if reconnection should be attempted, false otherwise
     */
    public boolean shouldReconnect() {
        switch (this) {
            case NO_INTERNET:
                return true;
            case SIMULTANEOUS_LOGIN:
            case FATAL:
                return false;
            case UNKNOWN:
            default:
                return false; // In most cases shouldn't be attempted
        }
    }
    
    /**
     * Gets a human-readable description of the disconnection reason.
     * 
     * @return description of the disconnection reason
     */
    public String getDescription() {
        switch (this) {
            case SIMULTANEOUS_LOGIN:
                return "Connection was kicked due to simultaneous login above limit";
            case NO_INTERNET:
                return "Connection lost due to internet connection issues";
            case UNKNOWN:
                return "Unknown disconnection reason";
            case FATAL:
                return "Fatal error leading to disconnect";
            default:
                return "Undefined disconnection reason";
        }
    }
}