package velox.api.layer1.data;

public class OrderResizeParameters extends OrderUpdateParameters {
    
    public final int size;

    public OrderResizeParameters(String orderId, int size) {
        super(orderId);
        this.size = size;
    }

    @Override
    public String toString() {
        return "OrderResizeParameters{" +
                "orderId='" + orderId + '\'' +
                ", size=" + size +
                '}';
    }
}