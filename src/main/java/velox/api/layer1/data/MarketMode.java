package velox.api.layer1.data;

public enum MarketMode {
    OPEN((short) 1),
    HALTED((short) 2),
    END_OF_DAY((short) 3);

    public final short code;

    MarketMode(short code) {
        this.code = code;
    }

    public static MarketMode valueOf(int code) {
        for (MarketMode mode : values()) {
            if (mode.code == code) {
                return mode;
            }
        }
        throw new IllegalArgumentException("No MarketMode with code: " + code);
    }

    public static MarketMode valueOf(String name) {
        return Enum.valueOf(MarketMode.class, name);
    }

    public static MarketMode[] values() {
        return MarketMode.values();
    }
}