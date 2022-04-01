package ch.hslu.oop.sw10;

import java.util.EventObject;

public class TemperaturMaximaEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperaturMaximaEvent(Object source) {
        super(source);
    }
}
