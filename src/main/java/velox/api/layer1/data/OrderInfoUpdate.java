package velox.api.layer1.data;

public class OrderInfoUpdate extends OrderInfo implements MultiAccountAware {
    
    public final boolean filledChanged;
    public final boolean unfilledChanged;
    public final boolean averageFillPriceChanged;
    public final boolean durationChanged;
    public final boolean statusChanged;
    public final boolean limitPriceChanged;
    public final boolean stopPriceChanged;
    public final boolean stopTriggeredChanged;
    public final boolean modificationTimeChanged;

    public OrderInfoUpdate(String instrumentAlias, String orderId, boolean isBuy, OrderType type,
                           String clientId, boolean doNotIncrease, int filled, boolean filledChanged,
                           int unfilled, boolean unfilledChanged, double averageFillPrice,
                           boolean averageFillPriceChanged, OrderDuration duration, boolean durationChanged,
                           OrderStatus status, boolean statusChanged, double limitPrice,
                           boolean limitPriceChanged, double stopPrice, boolean stopPriceChanged,
                           boolean stopTriggered, boolean stopTriggeredChanged, long modificationUtcTime,
                           boolean modificationTimeChanged, boolean isSimulated, boolean isDuplicate) {
        super(instrumentAlias, orderId, isBuy, type, clientId, doNotIncrease, filled, unfilled,
              averageFillPrice, duration, status, limitPrice, stopPrice, stopTriggered, modificationUtcTime, isSimulated);
        this.filledChanged = filledChanged;
        this.unfilledChanged = unfilledChanged;
        this.averageFillPriceChanged = averageFillPriceChanged;
        this.durationChanged = durationChanged;
        this.statusChanged = statusChanged;
        this.limitPriceChanged = limitPriceChanged;
        this.stopPriceChanged = stopPriceChanged;
        this.stopTriggeredChanged = stopTriggeredChanged;
        this.modificationTimeChanged = modificationTimeChanged;
    }

    @Override
    public String getTradingAccountId() {
        return accountId; // Assume accountId is defined in OrderInfo
    }

    @Override
    public String toString() {
        return "OrderInfoUpdate{" +
                "instrumentAlias='" + instrumentAlias + '\'' +
                ", orderId='" + orderId + '\'' +
                ", filledChanged=" + filledChanged +
                ", unfilledChanged=" + unfilledChanged +
                ", averageFillPriceChanged=" + averageFillPriceChanged +
                ", durationChanged=" + durationChanged +
                ", statusChanged=" + statusChanged +
                ", limitPriceChanged=" + limitPriceChanged +
                ", stopPriceChanged=" + stopPriceChanged +
                ", stopTriggeredChanged=" + stopTriggeredChanged +
                ", modificationTimeChanged=" + modificationTimeChanged +
                '}';
    }

    public OrderInfoBuilder toBuilder() {
        return new OrderInfoBuilder(instrumentAlias, orderId, isBuy, type, clientId, doNotIncrease)
                .setFilled(filled)
                .setUnfilled(unfilled)
                .setAverageFillPrice(averageFillPrice)
                .setDuration(duration)
                .setStatus(status)
                .setLimitPrice(limitPrice)
                .setStopPrice(stopPrice)
                .setStopTriggered(stopTriggered)
                .setModificationUtcTime(modificationUtcTime)
                .setSimulated(isSimulated)
                .setDuplicate(isDuplicate);
    }
}