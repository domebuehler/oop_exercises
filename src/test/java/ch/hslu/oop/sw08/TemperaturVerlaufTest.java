package ch.hslu.oop.sw08;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperaturVerlaufTest {

    @Test
    void testAdd() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);

        verlauf.add(temp1);
        assertThat(verlauf.getTemperatur(0)).isEqualTo(temp1);
    }

    @Test
    void testAddNull() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = null;

        verlauf.add(temp1);
        assertThat(verlauf.getCount()).isEqualTo(0);
    }

    @Test
    void testAddMultiple() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        Temperatur temp3 = new Temperatur(50.0f);

        verlauf.addMultiple(temp1, temp2, temp3);
        assertThat(verlauf.getCount()).isEqualTo(3);
    }

    @Test
    void testAddMultipleWith1Null() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        Temperatur temp3 = null;

        verlauf.addMultiple(temp1, temp2, temp3);
        assertThat(verlauf.getCount()).isEqualTo(2);
    }

    @Test
    void testAddMultipleZeroTemperatures() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        verlauf.addMultiple();

        assertThat(verlauf.getCount()).isEqualTo(0);
    }

    @Test
    void testClear() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        verlauf.clear();

        assertThat(verlauf.getCount()).isEqualTo(0);
    }

    @Test
    void testGetCount() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);

        assertThat(verlauf.getCount()).isEqualTo(2);
    }

    @Test
    void testGetCountEmptyList() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        assertThat(verlauf.getCount()).isEqualTo(0);
    }

    @Test
    void testGetTemperatur() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        assertThat(verlauf.getTemperatur(1)).isEqualTo(temp2);
    }

    @Test
    void testGetTemperaturOnlyOneTemperatur() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);

        verlauf.add(temp1);
        System.out.println(verlauf.getCount());
        assertThat(verlauf.getTemperatur(0)).isEqualTo(temp1);
    }

    @Test
    void testGetTemperaturEmptyList() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();

        assertThat(verlauf.getTemperatur(0)).isEqualTo(null);
    }

    @Test
    void testGetTemperaturInvalidIndex() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        assertThat(verlauf.getTemperatur(2)).isEqualTo(null);
    }

    @Test
    void testGetMax() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        Temperatur temp3 = new Temperatur(50.0f);

        verlauf.addMultiple(temp1, temp2, temp3);

        assertThat(verlauf.getMax()).isEqualTo(temp3);
    }

    @Test
    void testGetMaxEmptyList() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();

        assertThat(verlauf.getMax()).isEqualTo(null);
    }

    @Test
    void testGetMin() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        Temperatur temp3 = new Temperatur(50.0f);

        verlauf.addMultiple(temp1, temp2, temp3);

        assertThat(verlauf.getMin()).isEqualTo(temp1);
    }

    @Test
    void testGetMinEmptyList() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();

        assertThat(verlauf.getMin()).isEqualTo(null);
    }

    @Test
    void testGetAverage() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        Temperatur temp3 = new Temperatur(50.0f);

        verlauf.addMultiple(temp1, temp2, temp3);

        assertEquals(33.333f, verlauf.getAverage().getTempCelsius(), 0.01f);
    }

    @Test
    void testGetAverageEmptyList() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        assertThat(verlauf.getAverage()).isNull();
    }

    @Test
    void testGetAverageIterator() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(40.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        Temperatur temp3 = new Temperatur(50.0f);

        verlauf.addMultiple(temp1, temp2, temp3);

        assertEquals(40.0f, verlauf.getAverageWithIterator().getTempCelsius(), 0.01f);
    }

    @Test
    void testGetAverageEmptyListWithIterator() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        assertThat(verlauf.getAverageWithIterator()).isNull();
    }

    @Test
    void testCompareTo() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = new Temperatur(12.0f);
        Temperatur temp2 = new Temperatur(345.0f);
        Temperatur temp3 = new Temperatur(50.0f);
        Temperatur temp4 = new Temperatur(23.0f);
        Temperatur temp5 = new Temperatur(-123.0f);
        Temperatur temp6 = new Temperatur(124.0f);

        verlauf.addMultiple(temp1, temp2, temp3, temp4, temp5, temp6);

        System.out.println("before sorting");
        for (Temperatur temperatur : verlauf.getVerlauf()) {
            System.out.println(temperatur);
        }

        Collections.sort((List<Temperatur>) verlauf.getVerlauf());
        System.out.println("after sorting");
        for (Temperatur temperatur : verlauf.getVerlauf()) {
            System.out.println(temperatur);
        }

        assertThat(verlauf.getMin().getTempCelsius()).isEqualTo(-123.0f);
    }
}