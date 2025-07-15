package velox.api.layer1.data;

public class OrderInfoBuilder {
    
    private String instrumentAlias;
    private String orderId;
    private boolean isBuy;
    private OrderType type;
    private String clientId;
    private boolean doNotIncrease;

    public OrderInfoBuilder(String instrumentAlias, String orderId, boolean isBuy, OrderType type, String clientId, boolean doNotIncrease) {
        this.instrumentAlias = instrumentAlias;
        this.orderId = orderId;
        this.isBuy = isBuy;
        this.type = type;
        this.clientId = clientId;
        this.doNotIncrease = doNotIncrease;
    }

    public OrderInfoBuilder setInstrumentAlias(String instrumentAlias) {
        this.instrumentAlias = instrumentAlias;
        return this;
    }

    public OrderInfoBuilder setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderInfoBuilder setBuy(boolean isBuy) {
        this.isBuy = isBuy;
        return this;
    }

    public OrderInfoBuilder setType(OrderType type) {
        this.type = type;
        return this;
    }

    public OrderInfoBuilder setClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public OrderInfoBuilder setDoNotIncrease(boolean doNotIncrease) {
        this.doNotIncrease = doNotIncrease;
        return this;
    }

    public OrderInfo build() {
        return new OrderInfo(instrumentAlias, orderId, isBuy, type, clientId, doNotIncrease);
    }

    public String getAccountId() {
        // Implementation to get account ID
        return null; // Placeholder
    }

    public double getAverageFillPrice() {
        // Implementation to get average fill price
        return 0.0; // Placeholder
    }

    public String getClientId() {
        return clientId;
    }

    public OrderDuration getDuration() {
        // Implementation to get duration
        return null; // Placeholder
    }

    public String getExchangeId() {
        // Implementation to get exchange ID
        return null; // Placeholder
    }

    public int getFilled() {
        // Implementation to get filled amount
        return 0; // Placeholder
    }

    public String getInstrumentAlias() {
        return instrumentAlias;
    }

    public double getLimitPrice() {
        // Implementation to get limit price
        return 0.0; // Placeholder
    }

    public long getModificationUtcTime() {
        // Implementation to get modification time
        return 0L; // Placeholder
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderStatus getStatus() {
        // Implementation to get status
        return null; // Placeholder
    }

    public double getStopPrice() {
        // Implementation to get stop price
        return 0.0; // Placeholder
    }

    public boolean isBuy() {
        return isBuy;
    }

    public boolean isDoNotIncrease() {
        return doNotIncrease;
    }

    public boolean isDuplicate() {
        // Implementation to check if duplicate
        return false; // Placeholder
    }

    public boolean isSimulated() {
        // Implementation to check if simulated
        return false; // Placeholder
    }

    public boolean isStopTriggered() {
        // Implementation to check if stop is triggered
        return false; // Placeholder
    }

    public OrderInfoBuilder markAllChanged() {
        // Implementation for marking all as changed
        return this;
    }

    public OrderInfoBuilder markAllUnchanged() {
        // Implementation for marking all as unchanged
        return this;
    }
}