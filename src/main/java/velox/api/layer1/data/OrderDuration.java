package velox.api.layer1.data;

public enum OrderDuration {
    DAY(1),
    DYP(2),
    GTC(3),
    GCP(4),
    GTD(5),
    GDP(6),
    GTT(7),
    FOK(8),
    ATO(9),
    ATC(10),
    IOC(11),
    GTC_PO(12);

    public final int code;

    OrderDuration(int code) {
        this.code = code;
    }

    public static OrderDuration valueOf(int code) {
        for (OrderDuration duration : values()) {
            if (duration.code == code) {
                return duration;
            }
        }
        throw new IllegalArgumentException("No OrderDuration with code: " + code);
    }

    public static OrderDuration valueOf(String name) {
        return Enum.valueOf(OrderDuration.class, name);
    }

    public static OrderDuration[] values() {
        return OrderDuration.values();
    }

    public String toLocalizedString() {
        return this.name(); // Implement localized string representation if needed
    }
}