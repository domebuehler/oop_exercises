package ch.hslu.oop.sw13.motorapp;

import java.util.EventObject;

public class ReachedMaxRpmEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ReachedMaxRpmEvent(Object source) {
        super(source);
    }
}
