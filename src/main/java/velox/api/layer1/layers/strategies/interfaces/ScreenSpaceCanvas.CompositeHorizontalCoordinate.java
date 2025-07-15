package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class CompositeHorizontalCoordinate implements HorizontalCoordinate {
        public final CompositeCoordinateBase base;
        public final int pixelsX;
        public final long timeX;

        public CompositeHorizontalCoordinate(CompositeCoordinateBase base, int pixelsX, long timeX) {
            this.base = base;
            this.pixelsX = pixelsX;
            this.timeX = timeX;
        }

        @Override
        public CompositeHorizontalCoordinate compose() {
            return this; // Implementation of compose method
        }

        @Override
        public String toString() {
            return "CompositeHorizontalCoordinate{" +
                    "base=" + base +
                    ", pixelsX=" + pixelsX +
                    ", timeX=" + timeX +
                    '}';
        }
    }

    public interface HorizontalCoordinate {
        CompositeHorizontalCoordinate compose();
    }

    public enum CompositeCoordinateBase {
        DATA_ZERO,
        PIXEL_ZERO,
        RELATIVE;
    }
}