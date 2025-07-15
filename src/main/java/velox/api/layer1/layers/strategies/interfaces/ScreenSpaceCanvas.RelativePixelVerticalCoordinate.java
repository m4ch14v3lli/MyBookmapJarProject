package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class RelativePixelVerticalCoordinate extends RelativeVerticalCoordinate {
        private final int offset;

        public RelativePixelVerticalCoordinate(VerticalCoordinate base, int offset) {
            super(base);
            this.offset = offset;
        }

        @Override
        public RelativePixelVerticalCoordinate compose() {
            return this; // Implementation for composing into a composite coordinate
        }

        @Override
        public String toString() {
            return "RelativePixelVerticalCoordinate{" +
                   "base=" + base +
                   ", offset=" + offset +
                   '}';
        }
    }

    public static class RelativeVerticalCoordinate implements VerticalCoordinate {
        protected final VerticalCoordinate base;

        public RelativeVerticalCoordinate(VerticalCoordinate base) {
            this.base = base;
        }

        @Override
        public RelativeVerticalCoordinate compose() {
            return this;
        }
    }

    public interface VerticalCoordinate {
        RelativeVerticalCoordinate compose();
    }
}