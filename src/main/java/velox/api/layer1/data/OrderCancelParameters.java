package velox.api.layer1.data;

public class OrderCancelParameters extends OrderUpdateParameters {
    
    public final long batchId;
    public final boolean batchEnd;

    public OrderCancelParameters(String orderId) {
        super(orderId);
        this.batchId = 0; // Default batch ID
        this.batchEnd = true; // Default to end of batch
    }

    public OrderCancelParameters(String orderId, boolean batchEnd) {
        super(orderId);
        this.batchId = 0; // Default batch ID
        this.batchEnd = batchEnd;
    }

    public OrderCancelParameters(String orderId, long batchId, boolean batchEnd) {
        super(orderId);
        this.batchId = batchId;
        this.batchEnd = batchEnd;
    }

    @Override
    public String toString() {
        return "OrderCancelParameters{" +
                "orderId='" + orderId + '\'' +
                ", batchId=" + batchId +
                ", batchEnd=" + batchEnd +
                '}';
    }
}