package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class RelativeVerticalCoordinate implements VerticalCoordinate {
        public final VerticalCoordinate base;
        public final double dataOffsetY;
        public final int pixelsOffsetY;

        protected RelativeVerticalCoordinate(VerticalCoordinate base, double dataOffsetY, int pixelsOffsetY) {
            this.base = base;
            this.dataOffsetY = dataOffsetY;
            this.pixelsOffsetY = pixelsOffsetY;
        }

        @Override
        public RelativeVerticalCoordinate compose() {
            return this; // Convert to a composite coordinate
        }

        @Override
        public String toString() {
            return "RelativeVerticalCoordinate{" +
                   "base=" + base +
                   ", dataOffsetY=" + dataOffsetY +
                   ", pixelsOffsetY=" + pixelsOffsetY +
                   '}';
        }
    }

    public interface VerticalCoordinate {
        RelativeVerticalCoordinate compose();
    }
}