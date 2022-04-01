package ch.hslu.oop.sw12;


import java.util.EventObject;

public class TemperaturMaximaEvent extends EventObject {
    private final Temperatur newMaxima;
    private final Temperatur oldMaxima;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperaturMaximaEvent(Object source, Temperatur oldMaxima, Temperatur newMaxima) {
        super(source);
        this.newMaxima = newMaxima;
        this.oldMaxima = oldMaxima;
    }

    public Temperatur getNewMaxima() {
        return newMaxima;
    }

    public Temperatur getOldMaxima() {
        return oldMaxima;
    }
}
