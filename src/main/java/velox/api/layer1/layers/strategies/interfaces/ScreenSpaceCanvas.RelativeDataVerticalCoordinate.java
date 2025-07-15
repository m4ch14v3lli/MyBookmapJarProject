package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class RelativeDataVerticalCoordinate extends RelativeVerticalCoordinate {
        private final double offset;

        public RelativeDataVerticalCoordinate(VerticalCoordinate base, double offset) {
            super(base);
            this.offset = offset;
        }

        @Override
        public RelativeDataVerticalCoordinate compose() {
            return this; // Implementation for composing the coordinate
        }

        @Override
        public String toString() {
            return "RelativeDataVerticalCoordinate{" +
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