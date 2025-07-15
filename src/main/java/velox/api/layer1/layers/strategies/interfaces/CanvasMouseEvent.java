package velox.api.layer1.layers.strategies.interfaces;

public enum CanvasMouseEvent {
    DATA,
    PIXELS;

    public static CanvasMouseEvent[] values() {
        return new CanvasMouseEvent[]{DATA, PIXELS};
    }

    public static CanvasMouseEvent valueOf(String name) {
        for (CanvasMouseEvent type : values()) {
            if (type.name().equals(name)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + name);
    }
}