package velox.api.layer1.datastructure.events;

import java.io.Serializable;

public class MboAggregationEvent {

    public static class PriceSizeUpdate implements Serializable {
        public final int price; // Price of the order
        public final int size;  // Size of the order
        public static final PriceSizeUpdate REMOVAL = new PriceSizeUpdate(0, 0); // Constant for removal

        public PriceSizeUpdate(int price, int size) {
            this.price = price;
            this.size = size;
        }

        @Override
        public String toString() {
            return "PriceSizeUpdate{" +
                    "price=" + price +
                    ", size=" + size +
                    '}';
        }
    }
}