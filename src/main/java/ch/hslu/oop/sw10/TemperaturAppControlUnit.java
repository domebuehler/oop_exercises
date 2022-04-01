package ch.hslu.oop.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TemperaturAppControlUnit {

    private static final Logger LOG = LogManager.getLogger(TemperaturApp.class);

    private final TemperaturVerlauf temperaturVerlauf;

    public TemperaturAppControlUnit() {
        temperaturVerlauf = new TemperaturVerlauf();
        MaximaMinimaListener maximaMinimaListener = new MaximaMinimaListener();
        temperaturVerlauf.addTemperatureEventListener(maximaMinimaListener);
        MaximaListener maximaListener = new MaximaListener();
        temperaturVerlauf.addTemperatureMaximaEventListener(maximaListener);
        MinimaListener minimaListener = new MinimaListener();
        temperaturVerlauf.addTemperatureMinimaEventListener(minimaListener);
    }

    public void handleNewInput(String input) {
        try {
            float value = Float.parseFloat(input);
            createTemperature(value);
        } catch (NumberFormatException numberFormatException) {
            LOG.error("'{}' can not be parsed to float, has thrown {}",
                    input, numberFormatException);
        }
    }

    private void createTemperature(float value) {
        try {
            Temperatur temperatur = Temperatur.createFromCelsius(value);
            addTemperaturOnList(temperatur);
        } catch (IllegalArgumentException illegalArgumentException) {
            LOG.error("\"{}\" is not a valid temperature, has thrown {}",
                    value, illegalArgumentException);
        }
    }

    private void addTemperaturOnList(Temperatur temperatur) {
        this.temperaturVerlauf.add(temperatur);
    }

    public boolean checkForExit(String input) {
        return "exit".equalsIgnoreCase(input);
    }

    public String getStatsInString() {
        return "---Statistik---" +
                "\nAnzahl Temperaturen: " + this.temperaturVerlauf.getCount() +
                "\nDurchschnitt: " + this.temperaturVerlauf.getAverage() +
                "\nMaxima: " + this.temperaturVerlauf.getMax() +
                "\nMinima: " + this.temperaturVerlauf.getMin();
    }

    private class MaximaMinimaListener implements TemperaturEventListener {
        @Override
        public void handleTemperaturEvent(TemperaturEvent temperaturEvent) {
            if (temperaturEvent.getEventType() == TemperaturEventType.MAXIMUM) {
                LOG.info("Neues Maxima!");
            } else if (temperaturEvent.getEventType() == TemperaturEventType.MINIMUM) {
                LOG.info("Neues Minima!");
            }
        }
    }

    private class MaximaListener implements TemperaturMaximaEventListener {
        @Override
        public void handleTemperaturMaximaEvent(TemperaturMaximaEvent temperaturMaximaEvent) {
            LOG.info("new maxima!");
        }
    }

    private class MinimaListener implements TemperaturMinimaEventListener {
        @Override
        public void handleTemperaturMinimaEvent(TemperaturMinimaEvent temperaturMinimaEvent) {
            LOG.info("new minima!");
        }
    }
}
