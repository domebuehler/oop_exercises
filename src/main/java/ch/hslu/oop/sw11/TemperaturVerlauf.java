package ch.hslu.oop.sw11;

import ch.hslu.oop.sw10.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class TemperaturVerlauf {

    private static final Logger LOG = LogManager.getLogger(TemperaturVerlauf.class);
    private final List<TemperaturEventListener> listeners = new ArrayList<>();
    private final List<TemperaturMaximaEventListener> maximaListeners = new ArrayList<>();
    private final List<TemperaturMinimaEventListener> minimaListeners = new ArrayList<>();
    private final Collection<Temperatur> verlauf;
    private Temperatur maxTemperatur;
    private Temperatur minTemperatur;

    public TemperaturVerlauf() {
        this.verlauf = new ArrayList<>();
    }

    public void add(final Temperatur temperatur) {
        if (temperatur != null) {
            this.verlauf.add(temperatur);
            checkForEvent(temperatur);
        } else {
            LOG.info("null is not added!");
        }
    }

    public void clear() {
        this.verlauf.clear();
        this.minTemperatur = null;
        this.maxTemperatur = null;
    }

    public int getCount() {
        return this.verlauf.size();
    }

    public Temperatur getTemperatur(final int index) {
        List<Temperatur> verlaufListe = (List<Temperatur>) verlauf;
        if (checkListNotEmpty() && index < verlaufListe.size()) {
            return verlaufListe.get(index);
        } else {
            LOG.info("index ist not valid or list is empty");
            return null;
        }
    }

    public Temperatur getMax() {
        if (checkListNotEmpty()) {
            return Collections.max(this.verlauf);
        } else {
            return null;
        }
    }

    public Temperatur getMin() {
        if (checkListNotEmpty()) {
            return Collections.min(this.verlauf);
        } else {
            return null;
        }
    }

    public Temperatur getAverage() {
        float average = 0;
        if (checkListNotEmpty()) {
            for (Temperatur temperatur : this.verlauf) {
                average += temperatur.getTempCelsius();
            }
            average = average / this.verlauf.size();
            return Temperatur.createFromCelsius(average);
        } else {
            return null;
        }
    }

    private boolean checkListNotEmpty() {
        if (this.verlauf.size() > 0) {
            return true;
        } else {
            LOG.info("list is empty");
            return false;
        }
    }

    private void checkForEvent(final Temperatur temperatur) {
        if (this.getCount() == 1) {
            handleFirstTemperatur(temperatur);
        } else {
            checkForMaxima(temperatur);
            checkForMinima(temperatur);
        }
    }

    private void handleFirstTemperatur(final Temperatur temperatur) {
        setMaxTemperatur(temperatur);
        setMinTemperatur(temperatur);
        fireTemperatureMinimaEvent(new TemperaturMinimaEvent(this));
        fireTemperatureEvent(new TemperaturEvent(this, TemperaturEventType.MINIMUM));
        fireTemperatureMaximaEvent(new TemperaturMaximaEvent(this));
        fireTemperatureEvent(new TemperaturEvent(this, TemperaturEventType.MAXIMUM));
    }

    private void checkForMinima(final Temperatur temperatur) {
        if (temperatur.compareTo(this.minTemperatur) < 0) {
            setMinTemperatur(temperatur);
            fireTemperatureMinimaEvent(new TemperaturMinimaEvent(this));
            fireTemperatureEvent(new TemperaturEvent(this, TemperaturEventType.MINIMUM));
        }
    }

    private void checkForMaxima(final Temperatur temperatur) {
        if (temperatur.compareTo(this.maxTemperatur) > 0) {
            setMaxTemperatur(temperatur);
            fireTemperatureMaximaEvent(new TemperaturMaximaEvent(this));
            fireTemperatureEvent(new TemperaturEvent(this, TemperaturEventType.MAXIMUM));
        }
    }


    public void addTemperatureEventListener(final TemperaturEventListener listener) {
        if (listener == null) {
            throw new NullPointerException();
        } else {
            this.listeners.add(listener);
        }
    }

    public void addTemperatureMaximaEventListener(final TemperaturMaximaEventListener listener) {
        if (listener == null) {
            throw new NullPointerException();
        } else {
            this.maximaListeners.add(listener);
        }
    }

    public void addTemperatureMinimaEventListener(final TemperaturMinimaEventListener listener) {
        if (listener == null) {
            throw new NullPointerException();
        } else {
            this.minimaListeners.add(listener);
        }
    }

    public void removeTemperatureEventListener(final TemperaturEventListener listener) {
        if (listener == null) {
            throw new NullPointerException();
        } else {
            this.listeners.remove(listener);
        }
    }

    public void removeTemperatureMaximaEventListener(final TemperaturMaximaEventListener listener) {
        if (listener == null) {
            throw new NullPointerException();
        } else {
            this.maximaListeners.remove(listener);
        }
    }

    public void removeTemperatureMinimaEventListener(final TemperaturMinimaEventListener listener) {
        if (listener == null) {
            throw new NullPointerException();
        } else {
            this.minimaListeners.remove(listener);
        }
    }

    private void fireTemperatureEvent(final TemperaturEvent temperaturEvent) {
        if (this.listeners.size() > 0) {
            for (TemperaturEventListener temperaturEventListener : this.listeners) {
                temperaturEventListener.handleTemperaturEvent(temperaturEvent);
            }
        }
    }

    private void fireTemperatureMaximaEvent(final TemperaturMaximaEvent temperatureMaximaEvent) {
        if (this.maximaListeners.size() > 0) {
            for (TemperaturMaximaEventListener temperaturMaximaEventListener : this.maximaListeners) {
                temperaturMaximaEventListener.handleTemperaturMaximaEvent(temperatureMaximaEvent);
            }
        }
    }

    private void fireTemperatureMinimaEvent(final TemperaturMinimaEvent temperaturMinimaEvent) {
        if (this.minimaListeners.size() > 0) {
            for (TemperaturMinimaEventListener temperaturMinimaEventListener : this.minimaListeners) {
                temperaturMinimaEventListener.handleTemperaturMinimaEvent(temperaturMinimaEvent);
            }
        }
    }

    public List<TemperaturEventListener> getEventListeners() {
        List<TemperaturEventListener> list = this.listeners;
        return list;
    }

    public Collection<Temperatur> getVerlauf() {
        return this.verlauf;
    }

    private void setMinTemperatur(Temperatur temperatur) {
        this.minTemperatur = temperatur;
    }

    private void setMaxTemperatur(Temperatur temperatur) {
        maxTemperatur = temperatur;
    }

    public Temperatur getMaxTemperatur() {
        return maxTemperatur;
    }

    public Temperatur getMinTemperatur() {
        return minTemperatur;
    }
}
