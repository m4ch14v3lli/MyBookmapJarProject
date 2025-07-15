package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class RelativeDataHorizontalCoordinate extends RelativeHorizontalCoordinate {
        private final long offset;

        public RelativeDataHorizontalCoordinate(HorizontalCoordinate base, long offset) {
            super(base);
            this.offset = offset;
        }

        @Override
        public RelativeDataHorizontalCoordinate compose() {
            // Implement the method to convert to RelativeDataHorizontalCoordinate
            return this;
        }

        @Override
        public String toString() {
            return "RelativeDataHorizontalCoordinate{" +
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