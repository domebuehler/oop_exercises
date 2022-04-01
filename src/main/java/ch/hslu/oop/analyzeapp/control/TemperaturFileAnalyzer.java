package ch.hslu.oop.analyzeapp.control;

import ch.hslu.oop.analyzeapp.model.LineConverter;
import ch.hslu.oop.analyzeapp.model.MeasurementPoint;
import ch.hslu.oop.analyzeapp.model.MeasurementPointCourse;
import ch.hslu.oop.analyzeapp.model.TemperatureFileStatistic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class TemperaturFileAnalyzer {

    private static final Logger LOG = LogManager.getLogger(TemperaturFileAnalyzer.class);

    private final MeasurementPointCourse course;
    private TemperatureFileStatistic temperatureFileStatistic;

    public TemperaturFileAnalyzer() {
        this.course = new MeasurementPointCourse();
    }

    public TemperatureFileStatistic analyzeFile(File file, String statisticName, PropertyChangeListener listener) {
        this.temperatureFileStatistic = new TemperatureFileStatistic(statisticName);
        this.temperatureFileStatistic.addPropertyChangeListener(listener);
        List<String> list = readFile(file);
        handleNumbOfValues(list);
        for (String line : list) {
            try {
                handleNewLine(line);
            } catch (DataFormatException e) {
                handleDataFormatException();
            }
        }
        fillTemperatureFileStatistic();
        return this.temperatureFileStatistic;
    }

    private void handleNewLine(String line) throws DataFormatException {
        MeasurementPoint measurementPoint = LineConverter.convertLineToMeasurementPoint(line);
        course.addMeasurementPoint(measurementPoint);
        this.temperatureFileStatistic.incrementNumOfConvertions();
    }

    private void handleDataFormatException() {
        this.temperatureFileStatistic.incrementNumOfDataExceptions();
    }

    private void handleNumbOfValues(List<String> list) {
        this.temperatureFileStatistic.setNumOfValues(list.size());
    }

    private List<String> readFile(File file) {
        List<String> list = new ArrayList<>();
        try {
            list = TemperaturFileReader.
                    readTemperaturFile(file.toString());
        } catch (FileNotFoundException e) {
            LOG.error("file does not exist", e);
        }
        return list;
    }

    private void fillTemperatureFileStatistic() {
        this.temperatureFileStatistic.setAverageTemperature(this.course.getAverageTemperatur());
        this.temperatureFileStatistic.setMaximalMeasurementPoint(this.course.getMeasurementPointHighestTemperatur());
        this.temperatureFileStatistic.setMinimalMeasurementPoint(this.course.getMeasurementPointLowestTemperatur());
    }
}