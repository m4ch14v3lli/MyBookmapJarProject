package velox.api.layer1.data;

public class OrderMoveToMarketParameters extends OrderUpdateParameters {
    
    public final int offset;

    public OrderMoveToMarketParameters(String orderId, int offset) {
        super(orderId);
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "OrderMoveToMarketParameters{" +
                "orderId='" + orderId + '\'' +
                ", offset=" + offset +
                '}';
    }
}