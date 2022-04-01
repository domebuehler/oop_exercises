package ch.hslu.oop.rep.temp;

import ch.hslu.oop.rep.exceptions.EmptyTemperatureCourseException;
import ch.hslu.oop.rep.tempapp.TemperatureMaximaEvent;
import ch.hslu.oop.rep.tempapp.TemperatureMaximaEventListener;
import ch.hslu.oop.rep.tempapp.TemperatureMinimaEvent;
import ch.hslu.oop.rep.tempapp.TemperatureMinimaEventListener;

import javax.management.InstanceNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class TemperatureCourse {
    private final Collection<ImmutableTemperature> temperatures = new ArrayList<>();
    private final List<TemperatureMaximaEventListener> maximaEventListeners = new ArrayList<>();
    private final List<TemperatureMinimaEventListener> minimaEventListeners = new ArrayList<>();

    private ImmutableTemperature maxima = ImmutableTemperature.createFromCelsius(0f);
    private ImmutableTemperature minima = ImmutableTemperature.createFromCelsius(0f);

    public void add(ImmutableTemperature temperature) {
        if (temperature != null) {
            this.temperatures.add(temperature);
            checkForExtremeValue(temperature);
        } else {
            throw new NullPointerException();
        }
    }

    public void addAll(ImmutableTemperature... temperatures) {
        for (ImmutableTemperature temperature : temperatures) {
            this.add(temperature);
        }
    }

    public void addAllFromFloats(float... temperatureValues) {
        for (Float value : temperatureValues) {
            ImmutableTemperature temperature = ImmutableTemperature.createFromCelsius(value);
            this.add(temperature);
        }
    }

    public void clear() {
        this.temperatures.removeAll(temperatures);
    }

    public int getCount() {
        return this.temperatures.size();
    }

    public ImmutableTemperature getAverage() throws EmptyTemperatureCourseException {
        float averageValue = 0;
        if (this.getCount() > 0) {
            for (ImmutableTemperature temperature : this.temperatures) {
                averageValue += temperature.getTemperatureInCelsius();
            }
            return ImmutableTemperature.createFromCelsius(averageValue / this.getCount());
        } else {
            throw new EmptyTemperatureCourseException("list is empty");
        }
    }

    public void printCourseWithStreams() {
        this.temperatures.stream().forEach(t -> System.out.println());
    }

    public List<ImmutableTemperature> filterPositiv() {
        return this.temperatures.stream().
                filter(t -> t.getTemperatureInCelsius() > 0)
                .collect(Collectors.toList());
    }

    public long getFilterPositiveCount() {
        return this.filterPositiv().stream().count();
    }

    public void addCreatedListFromFloats(double[] value) {
        List<ImmutableTemperature> list = DoubleStream.of(value).
                mapToObj(v -> ImmutableTemperature.createFromCelsius((float) v)).
                toList();
        this.temperatures.addAll(list);
    }

    public ImmutableTemperature findMaximaWithStream() throws InstanceNotFoundException {
        Comparator<ImmutableTemperature> comparator = (t1, t2) -> t1.compareTo(t2);
        Optional<ImmutableTemperature> max = this.temperatures.stream().max(comparator);
        if (max.isPresent()) {
            return max.get();
        } else {
            throw new InstanceNotFoundException("maxima is not available");
        }
    }

    public void addTemperatureMaximaEventListener(TemperatureMaximaEventListener listener) {
        if (listener != null) {
            this.maximaEventListeners.add(listener);
        } else {
            throw new NullPointerException();
        }
    }

    public void removeTemperatureMaximaEventListener(TemperatureMaximaEventListener listener) {
        if (listener != null) {
            this.maximaEventListeners.remove(listener);
        } else {
            throw new NullPointerException();
        }
    }

    public void addTemperatureMinimaEventListener(TemperatureMinimaEventListener listener) {
        if (listener != null) {
            this.minimaEventListeners.add(listener);
        } else {
            throw new NullPointerException();
        }
    }

    public void removeTemperatureMinimaEventListener(TemperatureMinimaEventListener listener) {
        if (listener != null) {
            this.minimaEventListeners.remove(listener);
        } else {
            throw new NullPointerException();
        }
    }

    private void checkForExtremeValue(ImmutableTemperature temperature) {
        if (this.getCount() == 1) {
            handleFirstTemperature(temperature);
        } else {
            checkForMaxima(temperature);
            checkForMinima(temperature);
        }
    }

    private void checkForMinima(ImmutableTemperature temperature) {
        if (temperature.compareTo(this.minima) < 0) {
            this.setMinima(temperature);
        }
    }

    private void checkForMaxima(ImmutableTemperature temperature) {
        if (temperature.compareTo(this.maxima) > 0) {
            this.setMaxima(temperature);
        }
    }

    private void handleFirstTemperature(ImmutableTemperature temperature) {
        this.setMaxima(temperature);
        this.setMinima(temperature);
    }

    private void fireTemperatureMaximaEvent(TemperatureMaximaEvent event) {
        for (TemperatureMaximaEventListener listener : this.maximaEventListeners) {
            listener.handleTemperatureMaximaEvent(event);
        }
    }

    private void fireTemperatureMinimaEvent(TemperatureMinimaEvent event) {
        for (TemperatureMinimaEventListener listener : this.minimaEventListeners) {
            listener.handleTemperatureMinimaEvent(event);
        }
    }

    public void setMaxima(ImmutableTemperature maxima) {
        this.maxima = maxima;
        fireTemperatureMaximaEvent(new TemperatureMaximaEvent(this));
    }

    public void setMinima(ImmutableTemperature minima) {
        this.minima = minima;
        fireTemperatureMinimaEvent(new TemperatureMinimaEvent(this));
    }

    public ImmutableTemperature getMaxima() {
        return this.maxima;

    }

    public ImmutableTemperature getMinima() {
        return this.minima;
    }
}
