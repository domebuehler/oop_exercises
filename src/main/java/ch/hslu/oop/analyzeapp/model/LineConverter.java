package ch.hslu.oop.analyzeapp.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.zip.DataFormatException;

public final class LineConverter {

    private static final Logger LOG = LogManager.getLogger(LineConverter.class);

    private final static int TIMESTAMP_INDEX = 1;
    private final static int TEMPERATUR_INDEX = 2;
    private final static int MAX_LINE_LENGTH = 40;
    private final static int MIN_LINE_LENGTH = 37;
    private final static int LINE_TO_STRING_ARRAY_LENGTH = 4;

    public static MeasurementPoint convertLineToMeasurementPoint(String line) throws DataFormatException {
        if (validateLine(line)) {
            String[] lineArray = line.split(";");
            Temperatur temperatur = Temperatur.createFromCelsius(Float.valueOf(lineArray[TEMPERATUR_INDEX]));
            LocalDateTime timestamp = TimeStampConverter.convert(lineArray[TIMESTAMP_INDEX]);
            return new MeasurementPoint(timestamp, temperatur);
        } else {
            throw new DataFormatException();
        }
    }

    private static boolean validateLine(String line) {
        if (!(line.length() >= MIN_LINE_LENGTH && line.length() <= MAX_LINE_LENGTH)) {
            LOG.info(line.length());
            return false;
        } else if (!line.contains(";")) {
            return false;
        } else if (line.split(";").length != LINE_TO_STRING_ARRAY_LENGTH) {
            return false;
        } else {
            return true;
        }
    }
}
