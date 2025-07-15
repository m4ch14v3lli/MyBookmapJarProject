package velox.api.layer1.messages.indicators;

/**
 * Enum class StrategyUpdateGeneratorEventType defines the types of events 
 * that can be filtered by the StrategyUpdateGeneratorFilter.
 */
public enum StrategyUpdateGeneratorFilterStrategyUpdateGeneratorEventType {
    DEPTH_MBO,
    DEPTH_MBP,
    INSTRUMENTS,
    ORDERS,
    OTHER,
    TRADES,
    USER_DATA;

    /**
     * Returns an array containing the constants of this enum class, 
     * in the order they are declared.
     *
     * @return an array of enum constants
     */
    public static StrategyUpdateGeneratorFilterStrategyUpdateGeneratorEventType[] values() {
        return new StrategyUpdateGeneratorFilterStrategyUpdateGeneratorEventType[]{DEPTH_MBO, DEPTH_MBP, INSTRUMENTS, ORDERS, OTHER, TRADES, USER_DATA};
    }

    /**
     * Returns the enum constant of this class with the specified name.
     *
     * @param name the name of the enum constant to be returned
     * @return the enum constant with the specified name
     * @throws IllegalArgumentException if this enum class has no constant with the specified name
     * @throws NullPointerException if the argument is null
     */
    public static StrategyUpdateGeneratorFilterStrategyUpdateGeneratorEventType valueOf(String name) {
        for (StrategyUpdateGeneratorFilterStrategyUpdateGeneratorEventType constant : values()) {
            if (constant.name().equals(name)) {
                return constant;
            }
        }
        throw new IllegalArgumentException("No enum constant " + name);
    }
}