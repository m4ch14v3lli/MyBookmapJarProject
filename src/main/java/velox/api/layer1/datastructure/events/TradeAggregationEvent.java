package velox.api.layer1.datastructure.events;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TradeAggregationEvent extends Event implements Serializable, Cloneable, CloneableSerializable, CustomGeneratedEvent {

    public final Map<Double, Map<Integer, Integer>> bidAggressorMap; // Map of trades where bid is aggressor
    public final Map<Double, Map<Integer, Integer>> askAggressorMap; // Map of trades where ask is aggressor
    public final double lastPrice; // Last trade price
    public final Integer lastSize; // Last trade size
    public final Boolean lastAggressorBid; // Last trade aggressor

    public TradeAggregationEvent(long time) {
        super(time, EventType.TRADE_AGGREGATION_EVENT);
        this.bidAggressorMap = new HashMap<>();
        this.askAggressorMap = new HashMap<>();
        this.lastPrice = Double.NaN; // Default value for last price
        this.lastSize = null; // Default value for last size
        this.lastAggressorBid = null; // Default value for last aggressor
    }

    @Override
    public Object clone() {
        try {
            TradeAggregationEvent cloned = (TradeAggregationEvent) super.clone();
            cloned.bidAggressorMap = new HashMap<>(this.bidAggressorMap);
            cloned.askAggressorMap = new HashMap<>(this.askAggressorMap);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "TradeAggregationEvent{" +
                "lastPrice=" + lastPrice +
                ", lastSize=" + lastSize +
                ", lastAggressorBid=" + lastAggressorBid +
                '}';
    }
}