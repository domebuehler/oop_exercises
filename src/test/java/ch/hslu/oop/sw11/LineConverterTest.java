package ch.hslu.oop.sw11;

import org.junit.jupiter.api.Test;

import java.util.zip.DataFormatException;

import static org.assertj.core.api.Assertions.assertThat;

class LineConverterTest {

    @Test
    public void testConvertTemperature() {

        MeasurementPoint converted = null;
        try {
            converted = LineConverter.
                    convertLineToMeasurementPoint("1524779795;\"2018/04/26 23:56:35\";12.7;63");
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
        assertThat(converted.getTemperatur()).isEqualTo(Temperatur.createFromCelsius(12.7f));
    }

    @Test
    public void testConvertTimeStamp() {
        MeasurementPoint converted = null;
        try {
            converted = LineConverter.
                    convertLineToMeasurementPoint("1524779795;\"2018/04/26 23:56:35\";12.7;63");
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
        assertThat(converted.getTimestamp()).
                isEqualTo(TimeStampConverter.convert("\"2018/04/26 23:56:35\""));
    }
}