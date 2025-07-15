package velox.api.layer1.messages.indicators;

public enum Layer1ApiUserMessageModifyIndicator {

    BOTTOM,
    PRIMARY,
    NONE;

    public static Layer1ApiUserMessageModifyIndicator[] values() {
        return new Layer1ApiUserMessageModifyIndicator[]{BOTTOM, PRIMARY, NONE};
    }

    public static Layer1ApiUserMessageModifyIndicator valueOf(String name) {
        return Enum.valueOf(Layer1ApiUserMessageModifyIndicator.class, name);
    }
}