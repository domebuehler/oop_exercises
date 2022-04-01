package ch.hslu.oop.sw13.temperaturapp;

import ch.hslu.oop.sw11.LineConverter;
import ch.hslu.oop.sw11.MeasurementPoint;
import ch.hslu.oop.sw11.MeasurementPointCourse;
import ch.hslu.oop.sw11.TemperaturFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class TemperaturFileAnalyzer {

    private static final Logger LOG = LogManager.getLogger(TemperaturFileAnalyzer.class);

    private int numbOfValues;
    private int numbOfDataException;
    private int numOfMeasurementPointConvertion;
    private final List<PropertyChangeListener> listeners = new ArrayList<>();

    public TemperaturFileAnalyzer() {
        numbOfValues = 0;
        numOfMeasurementPointConvertion = 0;
        numbOfDataException = 0;
    }

    public Map<String, MeasurementPoint> analyzeFile(File file) {

        MeasurementPointCourse course = new MeasurementPointCourse();

        List<String> list = new ArrayList<>();
        try {
            list = TemperaturFileReader.
                    readTemperaturFile(file.toString());
        } catch (FileNotFoundException e) {
            LOG.error("file does not exist", e);
        }
        numbOfValues = list.size();
        firePropertyChangeEvent(new PropertyChangeEvent
                (this, "numbOfValues", 0, numbOfValues));

        for (String line : list) {
            try {
                MeasurementPoint measurementPoint = LineConverter.convertLineToMeasurementPoint(line);
                course.addMeasurementPoint(measurementPoint);
                int oldValue = numOfMeasurementPointConvertion;
                numOfMeasurementPointConvertion++;
                firePropertyChangeEvent(new PropertyChangeEvent
                        (this, "numOfMeasurementPointConvertion", oldValue, numOfMeasurementPointConvertion));
            } catch (DataFormatException e) {
                LOG.info(e);
                int oldValue = numbOfDataException;
                numbOfDataException++;
                firePropertyChangeEvent(new PropertyChangeEvent
                        (this, "numbOfDataException", oldValue, numbOfDataException));
            }
        }
        return createMapFromCourse(course);
    }

    private Map<String, MeasurementPoint> createMapFromCourse(MeasurementPointCourse course) {
        Map<String, MeasurementPoint> map = new HashMap<>();
        map.put("maxima", course.getMeasurementPointHighestTemperatur());
        map.put("minima", course.getMeasurementPointLowestTemperatur());
        map.put("average", new MeasurementPoint(null, course.getAverageTemperatur()));
        return map;
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.listeners.add(listener);
        } else {
            throw new NullPointerException();
        }
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.listeners.remove(listener);
        } else {
            throw new NullPointerException();
        }
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent event) {
        if (listeners.size() > 0) {
            for (PropertyChangeListener listener : listeners) {
                listener.propertyChange(event);
            }
        } else {
            throw new NullPointerException();
        }
    }
}
