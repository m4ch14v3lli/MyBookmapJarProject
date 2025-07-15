package velox.api.layer1.data;

public class OrderUpdateParameters {
    public final String orderId;

    public OrderUpdateParameters(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderUpdateParameters{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}