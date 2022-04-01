package ch.hslu.oop.sw11;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MeasurementPointCourseTest {

    @Test
    public void testAddMeasurementPoint() {
        MeasurementPointCourse course = new MeasurementPointCourse();
        LocalDateTime stamp = TimeStampConverter.convert("\"2018/03/28 23:24:42\"");
        Temperatur temperature1 = Temperatur.createFromCelsius(12f);
        Temperatur temperature2 = Temperatur.createFromCelsius(25f);
        Temperatur temperature3 = Temperatur.createFromCelsius(10f);
        MeasurementPoint point1 = new MeasurementPoint(stamp, temperature1);
        MeasurementPoint point2 = new MeasurementPoint(stamp, temperature2);
        MeasurementPoint point3 = new MeasurementPoint(stamp, temperature3);

        course.addMeasurementPoint(point1);
        course.addMeasurementPoint(point2);
        course.addMeasurementPoint(point3);

        assertThat(course.getSize()).isEqualTo(3);
    }

    @Test
    public void testAddNull() {
        MeasurementPointCourse course = new MeasurementPointCourse();
        assertThatThrownBy(() -> {
            course.addMeasurementPoint(null);
        }).
                isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testGetAverage() {
        MeasurementPointCourse course = new MeasurementPointCourse();
        LocalDateTime stamp = TimeStampConverter.convert("\"2018/03/28 23:24:42\"");
        Temperatur temperature1 = Temperatur.createFromCelsius(20f);
        Temperatur temperature2 = Temperatur.createFromCelsius(40f);
        Temperatur temperature3 = Temperatur.createFromCelsius(30f);
        MeasurementPoint point1 = new MeasurementPoint(stamp, temperature1);
        MeasurementPoint point2 = new MeasurementPoint(stamp, temperature2);
        MeasurementPoint point3 = new MeasurementPoint(stamp, temperature3);

        course.addMeasurementPoint(point1);
        course.addMeasurementPoint(point2);
        course.addMeasurementPoint(point3);

        assertThat(course.getAverageTemperatur()).isEqualTo(Temperatur.createFromCelsius(30f));
    }

    @Test
    public void testGetMaxima() {
        MeasurementPointCourse course = new MeasurementPointCourse();
        LocalDateTime stamp = TimeStampConverter.convert("\"2018/03/28 23:24:42\"");
        Temperatur temperature1 = Temperatur.createFromCelsius(20f);
        Temperatur temperature2 = Temperatur.createFromCelsius(40f);
        Temperatur temperature3 = Temperatur.createFromCelsius(30f);
        MeasurementPoint point1 = new MeasurementPoint(stamp, temperature1);
        MeasurementPoint point2 = new MeasurementPoint(stamp, temperature2);
        MeasurementPoint point3 = new MeasurementPoint(stamp, temperature3);

        course.addMeasurementPoint(point1);
        course.addMeasurementPoint(point2);
        course.addMeasurementPoint(point3);

        assertThat(course.getMeasurementPointHighestTemperatur()).isEqualTo(point2);
    }

    @Test
    public void testGetMinima() {
        MeasurementPointCourse course = new MeasurementPointCourse();
        LocalDateTime stamp = TimeStampConverter.convert("\"2018/03/28 23:24:42\"");
        Temperatur temperature1 = Temperatur.createFromCelsius(20f);
        Temperatur temperature2 = Temperatur.createFromCelsius(40f);
        Temperatur temperature3 = Temperatur.createFromCelsius(30f);
        MeasurementPoint point1 = new MeasurementPoint(stamp, temperature1);
        MeasurementPoint point2 = new MeasurementPoint(stamp, temperature2);
        MeasurementPoint point3 = new MeasurementPoint(stamp, temperature3);

        course.addMeasurementPoint(point1);
        course.addMeasurementPoint(point2);
        course.addMeasurementPoint(point3);

        assertThat(course.getMeasurementPointLowestTemperatur()).isEqualTo(point1);
    }
}