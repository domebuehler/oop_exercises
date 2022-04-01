package ch.hslu.oop.rep.tempapp;

import java.util.EventObject;

public class TemperatureMinimaEvent extends EventObject {
    /**
     * Constructs a TemperatureMinimaEvent.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperatureMinimaEvent(Object source) {
        super(source);
    }
}
