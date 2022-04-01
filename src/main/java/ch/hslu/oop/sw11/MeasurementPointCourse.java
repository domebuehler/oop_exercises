package ch.hslu.oop.sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Stores MeasurementPoints on a ArrayList.
 */
@SuppressWarnings("ClassCanBeRecord")
public final class MeasurementPointCourse {

    private static final Logger LOG = LogManager.getLogger(MeasurementPointCourse.class);
    private final Collection<MeasurementPoint> course;
    private MeasurementPoint measurementPointHighestTemperatur;
    private MeasurementPoint measurementPointLowestTemperatur;

    public MeasurementPointCourse() {
        this.course = new ArrayList<>();
    }

    /**
     * Adds measurementPoint on the MeasurementPointCourse.
     *
     * @param measurementPoint which should be added
     * @throws NullPointerException when trying to add null
     */
    public void addMeasurementPoint(MeasurementPoint measurementPoint) {
        if (measurementPoint == null) {
            throw new NullPointerException();
        } else {
            this.course.add(measurementPoint);
            peakCheck(measurementPoint);
        }
    }

    /**
     * Returns the Average-Temperature of all MeasurementPoint on the course.
     *
     * @return AverageTemperatur, null if list is empty
     */
    public Temperatur getAverageTemperatur() {
        if (!listIsNotEmpty()) {
            return null;
        } else {
            double average = 0d;
            for (MeasurementPoint measurementPoint : this.course) {
                average += (double) measurementPoint.getTemperatur().getTempCelsius();
            }
            average = average / this.course.size();
            return Temperatur.createFromCelsius((float) average);
        }
    }

    public int getSize() {
        return this.course.size();
    }

    private boolean listIsNotEmpty() {
        return this.course.size() > 0;
    }

    private void peakCheck(MeasurementPoint measurementPoint) {
        if (course.size() == 1) {
            setMeasurementPointHighestTemperatur(measurementPoint);
            setMeasurementPointLowestTemperatur(measurementPoint);
        } else {
            checkForLowPoint(measurementPoint);
            checkForHighPoint(measurementPoint);
        }
    }

    private void checkForHighPoint(MeasurementPoint measurementPoint) {
        if (measurementPoint.compareTo(this.measurementPointHighestTemperatur) > 0) {
            setMeasurementPointHighestTemperatur(measurementPoint);
        }
    }

    private void checkForLowPoint(MeasurementPoint measurementPoint) {
        if (measurementPoint.compareTo(this.measurementPointLowestTemperatur) < 0) {
            setMeasurementPointLowestTemperatur(measurementPoint);
        }
    }

    public void setMeasurementPointHighestTemperatur(MeasurementPoint measurementPointHighestTemperatur) {
        this.measurementPointHighestTemperatur = measurementPointHighestTemperatur;
    }

    public void setMeasurementPointLowestTemperatur(MeasurementPoint measurementPointLowestTemperatur) {
        this.measurementPointLowestTemperatur = measurementPointLowestTemperatur;
    }

    public MeasurementPoint getMeasurementPointHighestTemperatur() {
        return measurementPointHighestTemperatur;
    }

    public MeasurementPoint getMeasurementPointLowestTemperatur() {
        return measurementPointLowestTemperatur;
    }
}
