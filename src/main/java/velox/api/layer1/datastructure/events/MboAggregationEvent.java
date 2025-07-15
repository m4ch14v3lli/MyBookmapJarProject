package velox.api.layer1.datastructure.events;

import java.io.Serializable;
import java.util.Map;

public class MboAggregationEvent extends Event implements Serializable, Cloneable, CloneableSerializable, CustomGeneratedEvent {

    public Map<String, Order> newOrders; // New orders submitted in this period, keyed by order ID
    public Map<String, PriceSizeUpdate> updates; // Order updates, keyed by order ID

    public MboAggregationEvent(long time) {
        super(time, EventType.MBO_AGGREGATION_EVENT);
        // Initialize the maps here if necessary
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "MboAggregationEvent{" +
                "newOrders=" + newOrders +
                ", updates=" + updates +
                '}';
    }
    
    // Additional methods can be added here as needed

    // Nested classes can be defined here if necessary
    public static class Order {
        // Implementation for Order class
    }

    public static class PriceSizeUpdate {
        // Implementation for PriceSizeUpdate class
    }
}