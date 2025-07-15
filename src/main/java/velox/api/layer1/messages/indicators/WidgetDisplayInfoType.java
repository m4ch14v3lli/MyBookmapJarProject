package velox.api.layer1.messages.indicators;

/**
 * Enum class WidgetDisplayInfo.Type defines the types of display for widgets.
 */
public enum WidgetDisplayInfoType {
    DEFAULT,
    SYMMETRIC;

    /**
     * Returns an array containing the constants of this enum class, 
     * in the order they are declared.
     *
     * @return an array of enum constants
     */
    public static WidgetDisplayInfoType[] values() {
        return new WidgetDisplayInfoType[]{DEFAULT, SYMMETRIC};
    }

    /**
     * Returns the enum constant of this class with the specified name.
     *
     * @param name the name of the enum constant to be returned
     * @return the enum constant with the specified name
     * @throws IllegalArgumentException if this enum class has no constant with the specified name
     * @throws NullPointerException if the argument is null
     */
    public static WidgetDisplayInfoType valueOf(String name) {
        for (WidgetDisplayInfoType constant : values()) {
            if (constant.name().equals(name)) {
                return constant;
            }
        }
        throw new IllegalArgumentException("No enum constant " + name);
    }
}