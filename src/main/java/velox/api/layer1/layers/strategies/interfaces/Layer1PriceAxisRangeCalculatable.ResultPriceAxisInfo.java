package velox.api.layer1.layers.strategies.interfaces;

public class Layer1PriceAxisRangeCalculatable {

    public static class ResultPriceAxisInfo {
        
        public final double minValue;
        public final double maxValue;
        public final String[] labels;

        public ResultPriceAxisInfo(double minValue, double maxValue, String[] labels) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.labels = labels;
        }

        @Override
        public String toString() {
            return "ResultPriceAxisInfo{" +
                    "minValue=" + minValue +
                    ", maxValue=" + maxValue +
                    ", labels=" + String.join(", ", labels) +
                    '}';
        }
    }
}