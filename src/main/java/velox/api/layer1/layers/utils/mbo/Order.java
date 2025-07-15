package velox.api.layer1.layers.utils.mbo;

public class Order {
    public final String orderId;
    public final boolean isBid;
    public final int price;
    public final int size;

    public Order(String orderId, boolean isBid, int price, int size) {
        this.orderId = orderId;
        this.isBid = isBid;
        this.price = price;
        this.size = size;
    }

    public Order(Order other) {
        this.orderId = other.orderId;
        this.isBid = other.isBid;
        this.price = other.price;
        this.size = other.size;
    }

    public String getOrderId() {
        return orderId;
    }

    public boolean isBid() {
        return isBid;
    }

    public int getPrice() {
        return price;
    }

    public int getSize() {
        return size;
    }

    public void setPrice(int price) {
        // Additional logic can be added if needed
    }

    public void setSize(int size) {
        // Additional logic can be added if needed
    }

    @Override
    public int hashCode() {
        return orderId.hashCode(); // Simplified hash code based on orderId
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order other = (Order) obj;
        return this.orderId.equals(other.orderId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", isBid=" + isBid +
                ", price=" + price +
                ", size=" + size +
                '}';
    }
}