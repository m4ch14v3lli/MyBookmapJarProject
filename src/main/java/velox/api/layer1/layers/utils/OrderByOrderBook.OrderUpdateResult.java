package velox.api.layer1.layers.utils;

public class OrderByOrderBook {
    
    public static class OrderUpdateResult {
        public final int fromPrice;
        public final long fromSize;
        public final long toSize;

        public OrderUpdateResult(int fromPrice, long fromSize, long toSize) {
            this.fromPrice = fromPrice;
            this.fromSize = fromSize;
            this.toSize = toSize;
        }

        public int getFromPrice() {
            return fromPrice;
        }

        public long getFromSize() {
            return fromSize;
        }

        public long getToSize() {
            return toSize;
        }
    }
}