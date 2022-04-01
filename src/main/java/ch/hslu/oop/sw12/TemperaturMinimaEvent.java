package ch.hslu.oop.sw12;

import java.util.EventObject;

public class TemperaturMinimaEvent extends EventObject {
    private final Temperatur oldMinima;
    private final Temperatur newMinima;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperaturMinimaEvent(Object source, Temperatur oldMinima, Temperatur newMinima) {
        super(source);
        this.newMinima = newMinima;
        this.oldMinima = oldMinima;
    }

    public Temperatur getOldMinima() {
        return oldMinima;
    }

    public Temperatur getNewMinima() {
        return newMinima;
    }
}
