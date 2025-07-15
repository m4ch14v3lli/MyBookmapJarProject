package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class RelativeHorizontalCoordinate implements HorizontalCoordinate {
        public final HorizontalCoordinate base;
        public final int pixelsOffsetX;
        public final long timeOffsetX;

        public RelativeHorizontalCoordinate(HorizontalCoordinate base, int pixelsOffsetX, long timeOffsetX) {
            this.base = base;
            this.pixelsOffsetX = pixelsOffsetX;
            this.timeOffsetX = timeOffsetX;
        }

        @Override
        public RelativeHorizontalCoordinate compose() {
            return this; // Implement the method to convert to RelativeHorizontalCoordinate
        }

        @Override
        public String toString() {
            return "RelativeHorizontalCoordinate{" +
                   "base=" + base +
                   ", pixelsOffsetX=" + pixelsOffsetX +
                   ", timeOffsetX=" + timeOffsetX +
                   '}';
        }
    }

    public interface HorizontalCoordinate {
        RelativeHorizontalCoordinate compose();
    }
}