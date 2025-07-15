package velox.api.layer1.data;

import java.io.Serializable;

public enum OrderType implements Serializable {
    LMT(0),
    MKT(1),
    STP(2),
    STP_LMT(3);

    private final int code;

    OrderType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderType valueOf(int code) {
        for (OrderType type : values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with code " + code);
    }

    public static OrderType valueOf(String name) {
        return Enum.valueOf(OrderType.class, name);
    }

    public static OrderType valueOfLoose(String name) {
        for (OrderType type : values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with name " + name);
    }

    public String toLocalizedString() {
        return name(); // or implement localization logic here
    }

    public static OrderType getTypeFromPrices(double stopPrice, double limitPrice) {
        // Implement logic to determine OrderType based on prices
        // Placeholder implementation:
        if (stopPrice > limitPrice) {
            return STP;
        } else {
            return LMT;
        }
    }
}