package ch.hslu.oop.sw10;

import java.util.EventObject;

public class TemperaturEvent extends EventObject {

    private TemperaturEventType eventType;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperaturEvent(Object source, TemperaturEventType eventType) {
        super(source);
        this.eventType = eventType;
    }

    public TemperaturEventType getEventType() {
        return this.eventType;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TemperaturEvent;
    }
}
