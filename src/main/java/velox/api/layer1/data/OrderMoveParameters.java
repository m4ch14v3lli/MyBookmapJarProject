package velox.api.layer1.data;

public class OrderMoveParameters extends OrderUpdateParameters {
    
    public final double stopPrice;
    public final double limitPrice;

    public OrderMoveParameters(String orderId, double stopPrice, double limitPrice) {
        super(orderId);
        this.stopPrice = stopPrice;
        this.limitPrice = limitPrice;
    }

    @Override
    public String toString() {
        return "OrderMoveParameters{" +
                "orderId='" + orderId + '\'' +
                ", stopPrice=" + stopPrice +
                ", limitPrice=" + limitPrice +
                '}';
    }
}