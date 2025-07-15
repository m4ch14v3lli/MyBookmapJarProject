package velox.api.layer1.messages.indicators;

public enum DataStructureInterface {

    TRADE,
    DEPTH,
    MBO,
    ORDER;

    public static DataStructureInterface[] values() {
        return new DataStructureInterface[]{TRADE, DEPTH, MBO, ORDER};
    }

    public static DataStructureInterface valueOf(String name) {
        return Enum.valueOf(DataStructureInterface.class, name);
    }
}