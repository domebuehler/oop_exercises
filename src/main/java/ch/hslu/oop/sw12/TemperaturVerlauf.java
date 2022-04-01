package ch.hslu.oop.sw12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;


public final class TemperaturVerlauf {

    private static final Logger LOG = LogManager.getLogger(TemperaturVerlauf.class);
    private final List<TemperaturMaximaEventListener> maximaListeners = new ArrayList<>();
    private final List<TemperaturMinimaEventListener> minimaListeners = new ArrayList<>();
    private final Collection<Temperatur> verlauf;
    private Temperatur maxTemperatur;
    private Temperatur minTemperatur;

    public TemperaturVerlauf() {
        this.verlauf = new ArrayList<>();
    }

    public void printVerlauf() {
        if (checkListNotEmpty()) {
            this.verlauf.stream().forEach(t -> LOG.info(t));
        }
    }

    public List<Temperatur> filterPositiveTemperatures() {
        if (checkListNotEmpty()) {
            List<Temperatur> filtered = this.verlauf.
                    stream().
                    filter(c -> (c.getTempCelsius() >= 0f)).
                    collect(Collectors.toList());
            return filtered;
        } else {
            throw new NullPointerException("no temperatures on the list");
        }
    }

    public long countPositiveTemperatures() {
        List<Temperatur> filtered = filterPositiveTemperatures();
        long count = filtered.stream().count();
        return count;
    }

    public List<Temperatur> filterNegativeTemperatures() {
        if (checkListNotEmpty()) {
            List<Temperatur> filtered = this.verlauf.stream().
                    filter(c -> c.getTempCelsius() < 0f).
                    collect(Collectors.toList());

            return filtered;
        } else {
            throw new NullPointerException("no temperatures on the list");
        }
    }

    public long countNegativeTemperatures() {
        List<Temperatur> filtered = filterNegativeTemperatures();
        long count = filtered.stream().count();
        return count;
    }

    public List<Temperatur> filterWithRange(float min, float max) {
        if (checkListNotEmpty()) {
            List<Temperatur> filtered = this.verlauf.stream()
                    .filter(c -> (c.getTempCelsius() > min && c.getTempCelsius() < max))
                    .collect(Collectors.toList());
            return filtered;
        } else {
            throw new NullPointerException("no temperatures on the list");
        }
    }

    public long countTemperaturesWithinRange(float min, float max) {
        List<Temperatur> filtered = filterWithRange(min, max);
        long count = filtered.stream().count();
        return count;
    }

    public Temperatur getMaxTemperaturWithStream() {
        Comparator<Temperatur> temperaturComparator =
                (t1, t2) -> Float.compare(t1.getTempCelsius(), t2.getTempCelsius());
        Optional<Temperatur> max = this.verlauf.stream().max(temperaturComparator);

        if (max.isPresent()) {
            Temperatur maxTemp = Temperatur.createFromCelsius(max.get().getTempCelsius());
            return maxTemp;
        } else {
            throw new NullPointerException("no temperatures on the list");
        }
    }

    public Temperatur getMinTemperaturWithStream() {
        Comparator<Temperatur> temperaturComparator =
                (t1, t2) -> Float.compare(t1.getTempCelsius(), t2.getTempCelsius());
        Optional<Temperatur> min = this.verlauf.stream().min(temperaturComparator);

        if (min.isPresent()) {
            Temperatur minTemp = Temperatur.createFromCelsius(min.get().getTempCelsius());
            return minTemp;
        } else {
            throw new NullPointerException("no temperatures on the list");
        }
    }

    public Temperatur getAverageTemperaturWithStream() {
        double tempvalue = this.verlauf.stream().
                collect(Collectors.averagingDouble(t -> (double) t.getTempCelsius()));
        return Temperatur.createFromCelsius((float) tempvalue);
    }

    public static TemperaturVerlauf createVerlaufFromDoubleArrayWithStream(double[] values) {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        DoubleStream.of(values).forEach(value -> verlauf.add(Temperatur.createFromCelsius((float) value)));
        return verlauf;
    }

    /*public static TemperaturVerlauf createVerlaufFromDoubleArrayWithStreamAdvanced(double[] values) {
        return DoubleStream.of(values)
                .mapToObj(value -> Temperatur.createFromCelsius((float) value))
                .collect(new TemperaturVerlauf(), TemperaturVerlauf::add);
    }*/

    public static TemperaturVerlauf createVerlaufFromFloatArrayImperativ(float[] values) {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        for (int i = 0; i < values.length; i++) {
            Temperatur temperatur = Temperatur.createFromCelsius(values[i]);
            verlauf.add(temperatur);
        }
        return verlauf;
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
        if (this.verlauf == null) {
            throw new NullPointerException();
        } else if (this.verlauf.size() > 0) {
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
        Temperatur oldMaximum = null;
        Temperatur oldMinimum = null;
        setMaxTemperatur(temperatur);
        setMinTemperatur(temperatur);
        fireTemperatureMinimaEvent(new TemperaturMinimaEvent(this, oldMaximum, this.minTemperatur));
        fireTemperatureMaximaEvent(new TemperaturMaximaEvent(this, oldMaximum, this.maxTemperatur));
    }

    private void checkForMinima(final Temperatur temperatur) {
        if (temperatur.compareTo(this.minTemperatur) < 0) {
            Temperatur oldMinima = this.minTemperatur;
            setMinTemperatur(temperatur);
            fireTemperatureMinimaEvent(new TemperaturMinimaEvent(this, oldMinima, this.minTemperatur));
        }
    }

    private void checkForMaxima(final Temperatur temperatur) {
        if (temperatur.compareTo(this.maxTemperatur) > 0) {
            Temperatur oldMaxima = this.maxTemperatur;
            setMaxTemperatur(temperatur);
            fireTemperatureMaximaEvent(new TemperaturMaximaEvent(this, oldMaxima, this.maxTemperatur));
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

    public Collection<Temperatur> getVerlauf() {
        return this.verlauf;
    }

    private void setMinTemperatur(Temperatur temperatur) {
        this.minTemperatur = temperatur;
    }

    private void setMaxTemperatur(Temperatur temperatur) {
        maxTemperatur = temperatur;
    }
}
