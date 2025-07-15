package velox.api.layer1.datastructure.events;

import java.io.Serializable;

public class OrderUpdatedEvent extends Event implements Serializable, Cloneable, CloneableSerializable, CustomGeneratedEvent {

    public final String alias; // Alias of the instrument execution
    public final OrderInfoUpdate orderInfoUpdate; // Information about the order update

    public OrderUpdatedEvent(long t, OrderInfoUpdate orderInfoUpdate, String alias) {
        super(t, EventType.ORDER_UPDATED_EVENT);
        this.orderInfoUpdate = orderInfoUpdate;
        this.alias = alias;
    }

    public OrderUpdatedEvent(OrderUpdatedEvent event) {
        super(event.getTime(), event.eventType);
        this.orderInfoUpdate = event.orderInfoUpdate;
        this.alias = event.alias;
    }

    @Override
    public Object clone() {
        return new OrderUpdatedEvent(this);
    }

    @Override
    public String toString() {
        return "OrderUpdatedEvent{" +
                "alias='" + alias + '\'' +
                ", orderInfoUpdate=" + orderInfoUpdate +
                '}';
    }
}