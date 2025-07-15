package velox.api.layer1.data;

public class OrderInfo extends Object implements MultiAccountAware {
    
    public final String instrumentAlias;
    public final String orderId;
    public final boolean isBuy;
    public final OrderType type;
    public final String clientId;
    public final boolean doNotIncrease;
    public final int filled;
    public final int unfilled;
    public final double averageFillPrice;
    public final OrderDuration duration;
    public final OrderStatus status;
    public final double limitPrice;
    public final double stopPrice;
    public final boolean stopTriggered;
    public final long modificationUtcTime;
    public final boolean isSimulated;
    public final boolean isDuplicate;
    public final String accountId;

    public OrderInfo(String instrumentAlias, String orderId, boolean isBuy, OrderType type,
                     String clientId, boolean doNotIncrease, int filled, int unfilled,
                     double averageFillPrice, OrderDuration duration, OrderStatus status,
                     double limitPrice, double stopPrice, boolean stopTriggered,
                     long modificationUtcTime, boolean isSimulated, boolean isDuplicate) {
        this.instrumentAlias = instrumentAlias;
        this.orderId = orderId;
        this.isBuy = isBuy;
        this.type = type;
        this.clientId = clientId;
        this.doNotIncrease = doNotIncrease;
        this.filled = filled;
        this.unfilled = unfilled;
        this.averageFillPrice = averageFillPrice;
        this.duration = duration;
        this.status = status;
        this.limitPrice = limitPrice;
        this.stopPrice = stopPrice;
        this.stopTriggered = stopTriggered;
        this.modificationUtcTime = modificationUtcTime;
        this.isSimulated = isSimulated;
        this.isDuplicate = isDuplicate;
        this.accountId = null; // Default to null if no multi-account support
    }

    @Override
    public String getTradingAccountId() {
        return accountId;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "instrumentAlias='" + instrumentAlias + '\'' +
                ", orderId='" + orderId + '\'' +
                ", isBuy=" + isBuy +
                ", type=" + type +
                ", clientId='" + clientId + '\'' +
                ", doNotIncrease=" + doNotIncrease +
                ", filled=" + filled +
                ", unfilled=" + unfilled +
                ", averageFillPrice=" + averageFillPrice +
                ", duration=" + duration +
                ", status=" + status +
                ", limitPrice=" + limitPrice +
                ", stopPrice=" + stopPrice +
                ", stopTriggered=" + stopTriggered +
                ", modificationUtcTime=" + modificationUtcTime +
                ", isSimulated=" + isSimulated +
                ", isDuplicate=" + isDuplicate +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}