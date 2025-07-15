package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class CompositeVerticalCoordinate implements VerticalCoordinate {
        public final CompositeCoordinateBase base;
        public final double dataY;
        public final int pixelsY;

        public CompositeVerticalCoordinate(CompositeCoordinateBase base, int pixelsY, double dataY) {
            this.base = base;
            this.pixelsY = pixelsY;
            this.dataY = dataY;
        }

        @Override
        public CompositeVerticalCoordinate compose() {
            return this; // Implementation for composition
        }

        @Override
        public String toString() {
            return "CompositeVerticalCoordinate{" +
                   "base=" + base +
                   ", pixelsY=" + pixelsY +
                   ", dataY=" + dataY +
                   '}';
        }
    }

    public interface VerticalCoordinate {
        CompositeVerticalCoordinate compose();
    }

    public enum CompositeCoordinateBase {
        DATA_ZERO,
        PIXEL_ZERO,
        RELATIVE;
    }
}