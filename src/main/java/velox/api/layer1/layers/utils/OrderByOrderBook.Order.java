package velox.api.layer1.layers.utils;

public class OrderByOrderBook {
    
    public static class Order {
        public boolean isBid;
        public int price;
        public long size;

        public Order(boolean isBid, int price, long size) {
            this.isBid = isBid;
            this.price = price;
            this.size = size;
        }

        public boolean isBid() {
            return isBid;
        }

        public int getPrice() {
            return price;
        }

        public long getSize() {
            return size;
        }
    }
}