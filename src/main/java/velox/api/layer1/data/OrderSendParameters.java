package velox.api.layer1.data;

public interface OrderSendParameters {
    // Base interface for sending any order type

    String getOrderId();
    double getLimitPrice();
    double getStopPrice();
    OrderType getType();
    boolean isBuy();
    // Add other necessary methods as per your requirements
}