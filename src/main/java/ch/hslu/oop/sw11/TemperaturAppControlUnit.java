package ch.hslu.oop.sw11;

import ch.hslu.oop.sw10.TemperaturMaximaEvent;
import ch.hslu.oop.sw10.TemperaturMaximaEventListener;
import ch.hslu.oop.sw10.TemperaturMinimaEvent;
import ch.hslu.oop.sw10.TemperaturMinimaEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class TemperaturAppControlUnit {

    private static final Logger LOG = LogManager.getLogger(TemperaturApp.class);

    private final TemperaturVerlauf temperaturVerlauf;
    private final TemperaturAppStream temperaturAppStream = new TemperaturAppStream();

    public TemperaturAppControlUnit() {
        temperaturVerlauf = new TemperaturVerlauf();
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

    public void write() {
        temperaturAppStream.writeInFile(this.temperaturVerlauf);
    }

    public void read() {
        temperaturAppStream.readFile();
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
