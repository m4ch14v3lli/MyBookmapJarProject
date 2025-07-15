package velox.api.layer1.layers.strategies.interfaces;

public class Layer1PriceAxisRangeCalculatable {

    public static class InputPriceAxisInfo {
        public final double minValue;
        public final double maxValue;

        public InputPriceAxisInfo(double minValue, double maxValue) {
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        @Override
        public String toString() {
            return "InputPriceAxisInfo{" +
                    "minValue=" + minValue +
                    ", maxValue=" + maxValue +
                    '}';
        }
    }
}