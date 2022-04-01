package ch.hslu.oop.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TemperaturVerlaufTest {

    private static final Logger LOG = LogManager.getLogger(TemperaturVerlaufTest.class);
    private int test = 0;

    @Test
    void testAdd() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);

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
    void testClear() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        verlauf.clear();

        assertThat(verlauf.getCount()).isEqualTo(0);
    }

    @Test
    void testGetCount() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);

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
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        assertThat(verlauf.getTemperatur(1)).isEqualTo(temp2);
    }

    @Test
    void testGetTemperaturOnlyOneTemperatur() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);

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
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        assertThat(verlauf.getTemperatur(2)).isEqualTo(null);
    }

    @Test
    void testGetMax() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);
        Temperatur temp3 = Temperatur.createFromCelsius(50.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        verlauf.add(temp3);

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
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);
        Temperatur temp3 = Temperatur.createFromCelsius(50.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        verlauf.add(temp3);

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
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);
        Temperatur temp3 = Temperatur.createFromCelsius(50.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        verlauf.add(temp3);

        assertEquals(33.333f, verlauf.getAverage().getTempCelsius(), 0.01f);
    }

    @Test
    void testGetAverageEmptyList() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        assertThat(verlauf.getAverage()).isNull();
    }

    @Test
    void testCompareTo() {
        TemperaturVerlauf verlauf = new TemperaturVerlauf();
        Temperatur temp1 = Temperatur.createFromCelsius(12.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(345.0f);
        Temperatur temp3 = Temperatur.createFromCelsius(50.0f);
        Temperatur temp4 = Temperatur.createFromCelsius(23.0f);
        Temperatur temp5 = Temperatur.createFromCelsius(-123.0f);
        Temperatur temp6 = Temperatur.createFromCelsius(124.0f);

        verlauf.add(temp1);
        verlauf.add(temp2);
        verlauf.add(temp3);
        verlauf.add(temp4);
        verlauf.add(temp6);
        verlauf.add(temp5);

        LOG.info("before sorting");
        for (Temperatur temperatur : verlauf.getVerlauf()) {
            LOG.info(temperatur);
        }

        Collections.sort((List<Temperatur>) verlauf.getVerlauf());
        LOG.info("after sorting");
        for (Temperatur temperatur : verlauf.getVerlauf()) {
            LOG.info(temperatur);
        }

        assertThat(verlauf.getMin().getTempCelsius()).isEqualTo(-123.0f);
    }

    @Test
    public void testAddTemperatureEventListener() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        temperaturVerlauf.addTemperatureEventListener(temperaturEvent -> {
        });
        assertThat(temperaturVerlauf.getEventListeners().size()).isEqualTo(1);
    }

    @Test
    public void testAddTemperatureEventListenerWithNull() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        assertThatThrownBy(() -> {
            temperaturVerlauf.addTemperatureEventListener(null);
        }).
                isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testAddTemperatureMinimaEventListenerWithNull() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        assertThatThrownBy(() -> {
            temperaturVerlauf.addTemperatureMinimaEventListener(null);
        }).
                isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testAddTemperatureMaximaEventListenerWithNull() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        assertThatThrownBy(() -> {
            temperaturVerlauf.addTemperatureMaximaEventListener(null);
        }).
                isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testRemoveTemperatureEventListener() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        TemperaturEventListener listener1 = new TemperaturEventListener() {
            @Override
            public void handleTemperaturEvent(TemperaturEvent temperaturEvent) {
            }
        };
        temperaturVerlauf.addTemperatureEventListener(listener1);
        temperaturVerlauf.removeTemperatureEventListener(listener1);
        assertThat(temperaturVerlauf.getEventListeners().size()).isEqualTo(0);
    }

    @Test
    public void testRemoveTemperatureMinimaEventListener() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        TemperaturMinimaEventListener listener1 = new TemperaturMinimaEventListener() {
            @Override
            public void handleTemperaturMinimaEvent(TemperaturMinimaEvent temperaturMinimaEvent) {
            }
        };
        temperaturVerlauf.addTemperatureMinimaEventListener(listener1);
        temperaturVerlauf.removeTemperatureMinimaEventListener(listener1);
        assertThat(temperaturVerlauf.getEventListeners().size()).isEqualTo(0);
    }

    @Test
    public void testRemoveTemperatureMaximaEventListener() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        TemperaturMaximaEventListener listener1 = new TemperaturMaximaEventListener() {
            @Override
            public void handleTemperaturMaximaEvent(TemperaturMaximaEvent temperaturMaximaEvent) {

            }
        };
        temperaturVerlauf.addTemperatureMaximaEventListener(listener1);
        temperaturVerlauf.removeTemperatureMaximaEventListener(listener1);
        assertThat(temperaturVerlauf.getEventListeners().size()).isEqualTo(0);
    }

    @Test
    public void testRemoveTemperatureEventListenerWithNull() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        assertThatThrownBy(() -> {
            temperaturVerlauf.removeTemperatureEventListener(null);
        }).
                isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testRemoveTemperatureMinimaEventListenerWithNull() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        assertThatThrownBy(() -> {
            temperaturVerlauf.removeTemperatureMinimaEventListener(null);
        }).
                isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testRemoveTemperatureMaximaEventListenerWithNull() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        assertThatThrownBy(() -> {
            temperaturVerlauf.removeTemperatureMaximaEventListener(null);
        }).
                isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testFireTemperatureEventSmaller() {
        test = 0;
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        TemperaturEventListener temperaturEventListener = new TemperaturEventListener() {
            @Override
            public void handleTemperaturEvent(TemperaturEvent temperaturEvent) {
                LOG.info("event");
                test++;
            }
        };
        temperaturVerlauf.addTemperatureEventListener(temperaturEventListener);
        temperaturVerlauf.add(Temperatur.createFromCelsius(10f));
        temperaturVerlauf.add(Temperatur.createFromCelsius(0f));
        assertThat(test).isEqualTo(3);
    }

    @Test
    public void testFireTemperatureEventBigger() {
        test = 0;
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        TemperaturEventListener temperaturEventListener = new TemperaturEventListener() {
            @Override
            public void handleTemperaturEvent(TemperaturEvent temperaturEvent) {
                LOG.info("event");
                test++;
            }
        };
        temperaturVerlauf.addTemperatureEventListener(temperaturEventListener);
        temperaturVerlauf.add(Temperatur.createFromCelsius(10f));
        temperaturVerlauf.add(Temperatur.createFromCelsius(30f));
        assertThat(test).isEqualTo(3);
    }

    @Test
    public void testFireTemperatureMaximaEvent() {
        test = 0;
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        TemperaturMaximaEventListener maximaEventListener = new TemperaturMaximaEventListener() {
            @Override
            public void handleTemperaturMaximaEvent(TemperaturMaximaEvent temperaturMaximaEvent) {
                LOG.info("maxima event");
                test++;
            }
        };
        temperaturVerlauf.addTemperatureMaximaEventListener(maximaEventListener);
        temperaturVerlauf.add(Temperatur.createFromCelsius(0f));
        temperaturVerlauf.add(Temperatur.createFromCelsius(20f));
        assertThat(test).isEqualTo(2);
    }

    @Test
    public void testFireTemperatureMinimaEvent() {
        test = 0;
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        TemperaturMinimaEventListener minimaEventListener = new TemperaturMinimaEventListener() {
            @Override
            public void handleTemperaturMinimaEvent(TemperaturMinimaEvent temperaturMinimaEvent) {
                LOG.info("minima event");
                test++;
            }
        };
        temperaturVerlauf.addTemperatureMinimaEventListener(minimaEventListener);
        temperaturVerlauf.add(Temperatur.createFromCelsius(20f));
        temperaturVerlauf.add(Temperatur.createFromCelsius(0f));
        assertThat(test).isEqualTo(2);
    }

    @Test
    public void testFireTemperaturEventWithMocking() {
        TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
        TemperaturEventListener eventListener = new TemperaturEventListener() {
            @Override
            public void handleTemperaturEvent(TemperaturEvent temperaturEvent) {
            }
        };
        eventListener = spy(eventListener);
        temperaturVerlauf.addTemperatureEventListener(eventListener);
        temperaturVerlauf.add(Temperatur.createFromCelsius(0f));
        verify(eventListener,
                times(2)).
                handleTemperaturEvent(new TemperaturEvent(this, TemperaturEventType.MINIMUM));
    }
}