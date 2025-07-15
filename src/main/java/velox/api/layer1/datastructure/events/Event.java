package velox.api.layer1.datastructure.events;

import java.io.Serializable;

public abstract class Event implements Serializable, Cloneable, CustomGeneratedEvent {

    public final long time; // Time of the event
    public final EventType eventType; // Type of the event

    public Event(long time, EventType eventType) {
        this.time = time;
        this.eventType = eventType;
    }

    public long getTime() {
        return time;
    }

    @Override
    public abstract Object clone();
}