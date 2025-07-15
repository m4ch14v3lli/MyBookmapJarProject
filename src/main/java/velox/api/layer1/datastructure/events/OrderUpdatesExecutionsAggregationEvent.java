package velox.api.layer1.datastructure.events;

import java.io.Serializable;
import java.util.List;

public class OrderUpdatesExecutionsAggregationEvent extends Event implements Serializable, Cloneable, CloneableSerializable, CustomGeneratedEvent {

    public final List<Event> orderUpdates; // List of updates, will contain OrderUpdatedEvent and OrderExecutedEvent

    public OrderUpdatesExecutionsAggregationEvent(long time) {
        super(time, EventType.ORDER_UPDATES_EXECUTIONS_AGGREGATION_EVENT);
        this.orderUpdates = new ArrayList<>();
    }

    @Override
    public Object clone() {
        try {
            OrderUpdatesExecutionsAggregationEvent cloned = (OrderUpdatesExecutionsAggregationEvent) super.clone();
            cloned.orderUpdates = new ArrayList<>(this.orderUpdates); // Deep copy of orderUpdates
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported", e);
        }
    }

    @Override
    public String toString() {
        return "OrderUpdatesExecutionsAggregationEvent{" +
                "orderUpdates=" + orderUpdates +
                '}';
    }
}