package velox.api.layer1.layers.utils.mbo;

public class OrderBookMboUnsorted {
    
    public OrderBookMboUnsorted() {
        // Default constructor
    }

    public OrderBookMboUnsorted(OrderBookMboUnsorted other) {
        // Copy constructor
    }

    public OrderBookMboUnsorted(OrderBookMbo other) {
        // Conversion constructor from OrderBookMbo
    }

    public void cancel(String orderId) {
        // Logic to cancel the order with the given orderId
    }

    public Order getOrder(String orderId) {
        // Logic to retrieve the order by orderId
        return null; // Placeholder return value
    }

    public void replace(String orderId, int price, int size) {
        // Logic to replace an existing order
    }

    public void send(String orderId, boolean isBid, int price, int size) {
        // Logic to send an order
    }

    public void sendDataToListener(String alias, Layer1ApiMboDataListener listener) {
        // Logic to send data to a listener
    }
}