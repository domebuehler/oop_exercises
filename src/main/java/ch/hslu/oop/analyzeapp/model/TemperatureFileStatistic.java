package ch.hslu.oop.analyzeapp.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class TemperatureFileStatistic {

    private String statisticName;
    private MeasurementPoint maximalMeasurementPoint;
    private MeasurementPoint minimalMeasurementPoint;
    private Temperatur averageTemperature;
    private int numOfConvertions;
    private int numOfDataExceptions;
    private int numOfValues;
    private final List<PropertyChangeListener> listeners;

    public TemperatureFileStatistic(String statisticName) {
        this.statisticName = statisticName;
        this.listeners = new ArrayList<>();
        this.numOfConvertions = 0;
        this.numOfDataExceptions = 0;
        this.numOfValues = 0;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        if (listener != null) {
            this.listeners.add(listener);
        } else {
            throw new NullPointerException();
        }
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        if (listener != null) {
            this.listeners.remove(listener);
        } else {
            throw new NullPointerException();
        }
    }

    public void firePropertyChangeEvent(PropertyChangeEvent propertyChangeEvent) {
        if (this.listeners.size() > 0) {
            for (PropertyChangeListener listener : this.listeners) {
                listener.propertyChange(propertyChangeEvent);
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void incrementNumOfConvertions() {
        this.setNumOfConvertions(this.getNumOfConvertions() + 1);
    }

    public void incrementNumOfDataExceptions() {
        this.setNumOfDataExceptions(this.getNumOfDataExceptions() + 1);
    }

    @Override
    public String toString() {
        return "TemperatureFileStatistic{" +
                "statisticName='" + statisticName + '\'' +
                ", maximalMeasurementPoint=" + maximalMeasurementPoint +
                ", minimalMeasurementPoint=" + minimalMeasurementPoint +
                ", averageTemperature=" + averageTemperature +
                ", numOfConvertions=" + numOfConvertions +
                ", numOfDataExceptions=" + numOfDataExceptions +
                ", numOfValues=" + numOfValues +
                '}';
    }

    public String getStatisticName() {
        return statisticName;
    }

    public void setStatisticName(String statisticName) {
        this.statisticName = statisticName;
    }

    public MeasurementPoint getMaximalMeasurementPoint() {
        return maximalMeasurementPoint;
    }

    public void setMaximalMeasurementPoint(MeasurementPoint maximalMeasurementPoint) {
        this.maximalMeasurementPoint = maximalMeasurementPoint;
    }

    public MeasurementPoint getMinimalMeasurementPoint() {
        return minimalMeasurementPoint;
    }

    public void setMinimalMeasurementPoint(MeasurementPoint minimalMeasurementPoint) {
        this.minimalMeasurementPoint = minimalMeasurementPoint;
    }

    public Temperatur getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Temperatur averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public int getNumOfConvertions() {
        return numOfConvertions;
    }

    public void setNumOfConvertions(int numOfConvertions) {
        int oldValue = this.getNumOfConvertions();
        this.numOfConvertions = numOfConvertions;
        firePropertyChangeEvent(new PropertyChangeEvent(this, "numOfConvertions",
                oldValue, this.getNumOfConvertions()));
    }

    public int getNumOfDataExceptions() {
        return numOfDataExceptions;
    }

    public void setNumOfDataExceptions(int numOfDataExceptions) {
        int oldValue = this.getNumOfDataExceptions();
        this.numOfDataExceptions = numOfDataExceptions;
        firePropertyChangeEvent(new PropertyChangeEvent(this, "numOfDataExceptions",
                oldValue, this.getNumOfDataExceptions()));
    }

    public int getNumOfValues() {
        return numOfValues;
    }

    public void setNumOfValues(int numOfValues) {
        int oldValue = this.getNumOfValues();
        this.numOfValues = numOfValues;
        firePropertyChangeEvent(new PropertyChangeEvent(this, "numOfValues",
                oldValue, this.getNumOfValues()));
    }
}
