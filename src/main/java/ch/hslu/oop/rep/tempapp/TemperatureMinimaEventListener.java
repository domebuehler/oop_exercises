package ch.hslu.oop.rep.tempapp;

/**
 * You can register a TemperatureMaximaEventListener to be notified about a new MinimaTemperature.
 */
public interface TemperatureMinimaEventListener {
    /**
     * This Methode gets called when a TemperatureMinimaEvent occurs.
     * @param event A {@code TemperatureMinimaEvent} object.
     */
    void handleTemperatureMinimaEvent(TemperatureMinimaEvent event);
}
