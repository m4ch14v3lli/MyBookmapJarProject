package velox.api.layer1.datastructure.events;

import java.io.Serializable;

public class MboAggregationEvent {

    public static class Order extends PriceSizeUpdate implements Serializable {
        public final boolean isBid; // Indicates if the order is a bid

        public Order(boolean isBid, int price, int size) {
            super(price, size);
            this.isBid = isBid;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "isBid=" + isBid +
                    ", price=" + price +
                    ", size=" + size +
                    '}';
        }
    }

    public static class PriceSizeUpdate {
        public final int price; // Price of the order
        public final int size;  // Size of the order

        public PriceSizeUpdate(int price, int size) {
            this.price = price;
            this.size = size;
        }
    }
}