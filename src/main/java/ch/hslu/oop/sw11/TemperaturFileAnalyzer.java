package ch.hslu.oop.sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

public class TemperaturFileAnalyzer {

    private static final Logger LOG = LogManager.getLogger(TemperaturFileAnalyzer.class);

    public static void main(String[] args) {
        MeasurementPointCourse course = new MeasurementPointCourse();
        List<String> list = new ArrayList<>();
        try {
            list = TemperaturFileReader.
                    readTemperaturFile("c:\\Code\\OOP\\testfiles\\netatmo-export-201801-201804.csv");
        } catch (FileNotFoundException e) {
            LOG.error("file does not exist", e);
        }
        for (String line : list) {
            try {
                MeasurementPoint measurementPoint = LineConverter.convertLineToMeasurementPoint(line);
                course.addMeasurementPoint(measurementPoint);
            } catch (DataFormatException e) {
                LOG.error(e);
            }
        }
        LOG.info("Anzahl Temperaturen: " + course.getSize());
        LOG.info("Maxima: " + course.getMeasurementPointHighestTemperatur());
        LOG.info("Minima: " + course.getMeasurementPointLowestTemperatur());
        LOG.info("Average: " + course.getAverageTemperatur());
    }
}
