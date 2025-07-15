package velox.api.layer1.layers.strategies.interfaces;

public enum CompositeCoordinateBase {
    DATA_ZERO,
    PIXEL_ZERO,
    RELATIVE;

    public static CompositeCoordinateBase[] values() {
        return CompositeCoordinateBase.values();
    }

    public static CompositeCoordinateBase valueOf(String name) {
        return CompositeCoordinateBase.valueOf(name);
    }
}