package ch.hslu.oop.analyzeapp.model;

import java.time.LocalDateTime;

@SuppressWarnings("ClassCanBeRecord")
public class MeasurementPoint implements Comparable<MeasurementPoint> {
    private final LocalDateTime timestamp;
    private final Temperatur temperatur;

    public MeasurementPoint(LocalDateTime timestamp, Temperatur temperatur) {
        this.timestamp = timestamp;
        this.temperatur = temperatur;
    }

    @Override
    public int compareTo(MeasurementPoint o) {
        return this.getTemperatur().compareTo(o.getTemperatur());
    }

    @Override
    public String toString() {
        return this.temperatur + " measured on " + this.timestamp;
    }

    public Temperatur getTemperatur() {
        return temperatur;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}