package velox.api.layer1.data;

import java.io.Serializable;

public enum OrderStatus implements Serializable {
    CANCELLED(0),
    DISCONNECTED(1),
    FILLED(2),
    INACTIVE(3), // Deprecated
    PENDING_CANCEL(4),
    PENDING_MODIFY(5),
    PENDING_SUBMIT(6),
    REJECTED(7),
    SUSPENDED(8),
    WORKING(9);

    private final int code;

    OrderStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderStatus valueOf(int code) {
        for (OrderStatus status : values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }

    public static OrderStatus valueOf(String name) {
        return Enum.valueOf(OrderStatus.class, name);
    }

    public static OrderStatus valueOfLoose(String name) {
        for (OrderStatus status : values()) {
            if (status.name().equalsIgnoreCase(name)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant with name " + name);
    }

    public boolean isActive() {
        return this != INACTIVE && this != CANCELLED && this != REJECTED && this != DISCONNECTED;
    }
}