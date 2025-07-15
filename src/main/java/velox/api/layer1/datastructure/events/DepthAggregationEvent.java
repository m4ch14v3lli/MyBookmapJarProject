package velox.api.layer1.datastructure.events;

import java.io.Serializable;
import java.util.Map;

public class DepthAggregationEvent extends Event implements Serializable, Cloneable, CloneableSerializable, CustomGeneratedEvent {

    public Map<Integer, Integer> bidsMap; // Map of bids: price level (key) and size at this level (value)
    public Map<Integer, Integer> asksMap; // Map of asks: price level (key) and size at this level (value)

    public DepthAggregationEvent(long time) {
        super(time);
        // Initialize maps
    }

    public DepthAggregationEvent(long time, int bidsCapacity, int asksCapacity) {
        super(time);
        // Initialize maps with capacities
    }

    public Map<Integer, Integer> getMap(boolean isBid) {
        return isBid ? bidsMap : asksMap;
    }

    public int bestBid() {
        // Logic to calculate best bid
        return 0; // Placeholder return value
    }

    @Override
    public String toString() {
        return "DepthAggregationEvent{" +
                "bidsMap=" + bidsMap +
                ", asksMap=" + asksMap +
                '}';
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }
}