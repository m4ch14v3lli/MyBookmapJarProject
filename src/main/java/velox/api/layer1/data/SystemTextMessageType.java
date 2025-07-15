package velox.api.layer1.data;

public enum SystemTextMessageType {
    UNCLASSIFIED("Message not falling into other categories. Better show it to user."),
    ORDER_FAILURE("Rejection/modification error/etc."),
    SUBSCRIPTION_LIMIT("Subscription limit reached");

    private final String description;

    SystemTextMessageType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static SystemTextMessageType valueOf(String name) {
        return Enum.valueOf(SystemTextMessageType.class, name);
    }

    public static SystemTextMessageType[] values() {
        return SystemTextMessageType.values();
    }
}