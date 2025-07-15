package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class RelativePixelHorizontalCoordinate extends RelativeHorizontalCoordinate {
        private final int offset;

        public RelativePixelHorizontalCoordinate(HorizontalCoordinate base, int offset) {
            super(base);
            this.offset = offset;
        }

        @Override
        public RelativePixelHorizontalCoordinate compose() {
            return this; // Implementation for composing into a composite coordinate
        }

        @Override
        public String toString() {
            return "RelativePixelHorizontalCoordinate{" +
                   "base=" + base +
                   ", offset=" + offset +
                   '}';
        }
    }

    public static class RelativeHorizontalCoordinate implements HorizontalCoordinate {
        protected final HorizontalCoordinate base;

        public RelativeHorizontalCoordinate(HorizontalCoordinate base) {
            this.base = base;
        }

        @Override
        public RelativeHorizontalCoordinate compose() {
            return this;
        }
    }

    public interface HorizontalCoordinate {
        RelativeHorizontalCoordinate compose();
    }
}