package ch.hslu.oop.rep.tempapp;

import java.util.EventObject;

public class TemperatureMaximaEvent extends EventObject {
    /**
     * Constructs a MaximaTemperatureEvent.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperatureMaximaEvent(Object source) {
        super(source);
    }
}
