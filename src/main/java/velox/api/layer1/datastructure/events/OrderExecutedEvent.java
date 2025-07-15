package velox.api.layer1.datastructure.events;

import java.io.Serializable;

public class OrderExecutedEvent extends Event implements Serializable, Cloneable, CloneableSerializable, CustomGeneratedEvent {

    public final String alias; // Alias of the instrument execution
    public final ExecutionInfo executionInfo; // Information about the order execution

    public OrderExecutedEvent(long time, ExecutionInfo executionInfo, String alias) {
        super(time, EventType.ORDER_EXECUTED_EVENT);
        this.executionInfo = executionInfo;
        this.alias = alias;
    }

    public OrderExecutedEvent(OrderExecutedEvent event) {
        super(event.getTime(), event.eventType);
        this.executionInfo = event.executionInfo;
        this.alias = event.alias;
    }

    @Override
    public Object clone() {
        return new OrderExecutedEvent(this);
    }

    @Override
    public String toString() {
        return "OrderExecutedEvent{" +
                "alias='" + alias + '\'' +
                ", executionInfo=" + executionInfo +
                '}';
    }
}