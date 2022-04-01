package ch.hslu.oop.sw12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperaturVerlaufTest {
    private static final Logger LOG = LogManager.getLogger(TemperaturVerlaufTest.class);

    @Test
    public void testPrintVerlauf() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(-56f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);

        verlauf.printVerlauf();
    }


    @Test
    public void testFilterPositive() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(-56f);
        Temperatur t6 = Temperatur.createFromCelsius(47f);
        Temperatur t7 = Temperatur.createFromCelsius(0f);
        Temperatur t8 = Temperatur.createFromCelsius(-3f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);
        verlauf.add(t6);
        verlauf.add(t7);
        verlauf.add(t8);

        List<Temperatur> filtered = verlauf.filterPositiveTemperatures();
        assertThat(filtered.size()).isEqualTo(5);
    }

    @Test
    public void testFilterPositiveCounter() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(-56f);
        Temperatur t6 = Temperatur.createFromCelsius(47f);
        Temperatur t7 = Temperatur.createFromCelsius(0f);
        Temperatur t8 = Temperatur.createFromCelsius(-3f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);
        verlauf.add(t6);
        verlauf.add(t7);
        verlauf.add(t8);


        assertThat(verlauf.countPositiveTemperatures()).isEqualTo(5l);
    }


    @Test
    public void testFilterNegative() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(-56f);
        Temperatur t6 = Temperatur.createFromCelsius(47f);
        Temperatur t7 = Temperatur.createFromCelsius(0f);
        Temperatur t8 = Temperatur.createFromCelsius(-3f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);
        verlauf.add(t6);
        verlauf.add(t7);
        verlauf.add(t8);

        List<Temperatur> filtered = verlauf.filterNegativeTemperatures();
        assertThat(filtered.size()).isEqualTo(3);
    }

    @Test
    public void testFilterNegativeTemperaturesCount() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(-56f);
        Temperatur t6 = Temperatur.createFromCelsius(47f);
        Temperatur t7 = Temperatur.createFromCelsius(0f);
        Temperatur t8 = Temperatur.createFromCelsius(-3f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);
        verlauf.add(t6);
        verlauf.add(t7);
        verlauf.add(t8);

        assertThat(verlauf.countNegativeTemperatures()).isEqualTo(3);
    }

    @Test
    public void testFilterWithRange() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(-56f);
        Temperatur t6 = Temperatur.createFromCelsius(47f);
        Temperatur t7 = Temperatur.createFromCelsius(0f);
        Temperatur t8 = Temperatur.createFromCelsius(-3f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);
        verlauf.add(t6);
        verlauf.add(t7);
        verlauf.add(t8);

        List<Temperatur> filtered = verlauf.filterWithRange(-100f, 100f);
        assertThat(filtered.size()).isEqualTo(6);
    }

    @Test
    public void testFilterRangeCount() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(-56f);
        Temperatur t6 = Temperatur.createFromCelsius(47f);
        Temperatur t7 = Temperatur.createFromCelsius(0f);
        Temperatur t8 = Temperatur.createFromCelsius(-3f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);
        verlauf.add(t6);
        verlauf.add(t7);
        verlauf.add(t8);

        assertThat(verlauf.countTemperaturesWithinRange(-100f, 100f)).isEqualTo(6);
    }

    @Test
    public void testGetMax() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(523f);
        Temperatur t6 = Temperatur.createFromCelsius(47f);
        Temperatur t7 = Temperatur.createFromCelsius(0f);
        Temperatur t8 = Temperatur.createFromCelsius(-3f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);
        verlauf.add(t6);
        verlauf.add(t7);
        verlauf.add(t8);

        Temperatur max = verlauf.getMaxTemperaturWithStream();
        assertThat(max).isEqualTo(t5);
    }

    @Test
    public void testGetMin() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(123f);
        Temperatur t2 = Temperatur.createFromCelsius(-123f);
        Temperatur t3 = Temperatur.createFromCelsius(3f);
        Temperatur t4 = Temperatur.createFromCelsius(23f);
        Temperatur t5 = Temperatur.createFromCelsius(523f);
        Temperatur t6 = Temperatur.createFromCelsius(47f);
        Temperatur t7 = Temperatur.createFromCelsius(-265f);
        Temperatur t8 = Temperatur.createFromCelsius(-3f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);
        verlauf.add(t4);
        verlauf.add(t5);
        verlauf.add(t6);
        verlauf.add(t7);
        verlauf.add(t8);

        Temperatur min = verlauf.getMinTemperaturWithStream();
        assertThat(min).isEqualTo(t7);
    }

    @Test
    public void testCreatFromArray() {
        double[] array = {12d, 23d, 134d, -237d, -75d, 3d, 434d};
        TemperaturVerlauf verlauf = TemperaturVerlauf.createVerlaufFromDoubleArrayWithStream(array);
        assertThat(verlauf.getCount()).isEqualTo(7);
    }

    @Test
    public void testCreateVerlaufFromFloatArray() {

        float[] array = {12f, 23f, 134f, -237f, -75f, 3f, 434f};
        TemperaturVerlauf verlauf = TemperaturVerlauf.createVerlaufFromFloatArrayImperativ(array);
        for (Temperatur temperatur : verlauf.getVerlauf()) {
            LOG.info(temperatur);
        }

        assertThat(verlauf.getCount()).isEqualTo(7);
    }

    @Test
    public void testGetAverageWithStream() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur t1 = Temperatur.createFromCelsius(20f);
        Temperatur t2 = Temperatur.createFromCelsius(30f);
        Temperatur t3 = Temperatur.createFromCelsius(50f);

        verlauf.add(t1);
        verlauf.add(t2);
        verlauf.add(t3);

        Temperatur ave = verlauf.getAverageTemperaturWithStream();

        assertEquals(ave.getTempCelsius(), 33.33f, 0.1f);
    }
}