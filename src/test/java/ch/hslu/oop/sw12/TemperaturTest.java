package ch.hslu.oop.sw12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TemperaturTest {

    private static final Logger LOG = LogManager.getLogger(TemperaturTest.class);

    @Test
    public void testComparator() {
        Temperatur t1 = Temperatur.createFromCelsius(123);
        Temperatur t2 = Temperatur.createFromCelsius(-123);
        Temperatur t3 = Temperatur.createFromCelsius(3);
        Temperatur t4 = Temperatur.createFromCelsius(23);
        Temperatur t5 = Temperatur.createFromCelsius(-56);

        List<Temperatur> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);

        Comparator<Temperatur> tempComp = (temp1, temp2) -> Float.compare(temp1.getTempCelsius(), temp2.getTempCelsius());
        Collections.sort(list, tempComp);

        for (Temperatur temperatur : list) {
            LOG.info(temperatur);
        }
        assertThat(list.get(4)).isEqualTo(t1);
    }
}