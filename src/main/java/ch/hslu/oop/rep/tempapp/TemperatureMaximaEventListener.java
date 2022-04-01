package ch.hslu.oop.rep.tempapp;

/**
 * You can register a TemperatureMaximaEventListener to be notified about a new MaximaTemperature.
 */
public interface TemperatureMaximaEventListener {
    /**
     * This Methode gets called when a TemperatureMaximaEvent occurs.
     * @param event A {@code TemperatureMaximaEvent} object.
     */
    void handleTemperatureMaximaEvent(TemperatureMaximaEvent event);
}
