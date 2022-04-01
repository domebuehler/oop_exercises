package ch.hslu.oop.rep.temp;

import ch.hslu.oop.rep.exceptions.EmptyTemperatureCourseException;
import ch.hslu.oop.rep.tempapp.TemperatureMaximaEvent;
import ch.hslu.oop.rep.tempapp.TemperatureMaximaEventListener;
import ch.hslu.oop.rep.tempapp.TemperatureMinimaEvent;
import ch.hslu.oop.rep.tempapp.TemperatureMinimaEventListener;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemperatureCourseTest {

    private int counter = 0;

    @Test
    public void testAddAllFromFloats() {
        TemperatureCourse course = new TemperatureCourse();
        course.addAllFromFloats(10f, 15f, 25f, 35f);
        assertThat(course.getCount()).isEqualTo(4);
    }

    @Test
    public void testAdd() {
        TemperatureCourse course = new TemperatureCourse();
        ImmutableTemperature temperature = ImmutableTemperature.createFromCelsius(12f);
        ImmutableTemperature temperatureOther = ImmutableTemperature.createFromCelsius(23f);
        ImmutableTemperature temperatureOtherOther = ImmutableTemperature.createFromCelsius(45f);

        course.addAll(temperature, temperatureOther, temperatureOtherOther);
        assertThat(course.getCount()).isEqualTo(3);
    }

    @Test
    public void testClear() {
        TemperatureCourse course = new TemperatureCourse();
        course.addAllFromFloats(10f, 15f, 25f, 35f);
        course.clear();
        assertThat(course.getCount()).isEqualTo(0);
    }

    @Test
    public void testGetMaxima() {
        TemperatureCourse course = new TemperatureCourse();
        course.addAllFromFloats(0f, -12f, 25f, 10f, -23f);
        ImmutableTemperature maxima = course.getMaxima();
        assertThat(maxima).isEqualTo(ImmutableTemperature.createFromCelsius(25f));
    }

    @Test
    public void testGetMinima() {
        TemperatureCourse course = new TemperatureCourse();
        course.addAllFromFloats(0f, -12f, -45f, 10f, -23f);
        ImmutableTemperature minima = course.getMinima();
        assertThat(minima).isEqualTo(ImmutableTemperature.createFromCelsius(-45f));
    }

    @Test
    public void testGetAverage() {
        TemperatureCourse course = new TemperatureCourse();
        course.addAllFromFloats(50, 25, 25, 20);
        ImmutableTemperature average = null;
        try {
            average = course.getAverage();
        } catch (EmptyTemperatureCourseException e) {
            e.printStackTrace();
        }
        assertThat(average).isEqualTo(ImmutableTemperature.createFromCelsius(30f));
    }

    @Test
    public void testGetAverageThrowsException() {
        TemperatureCourse course = new TemperatureCourse();
        assertThatThrownBy(() -> {
            course.getAverage();
        }).isInstanceOf(EmptyTemperatureCourseException.class);
    }

    @Test
    public void testAddNullThrowsNullPointerException() {
        TemperatureCourse course = new TemperatureCourse();
        assertThatNullPointerException().isThrownBy(() -> {
            course.add(null);
        });

        assertThatThrownBy(() -> {
            course.add(null);
        }).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void testAddNullThrowsNullPointerExceptionJUnit() {
        TemperatureCourse course = new TemperatureCourse();
        final Exception e = assertThrows(NullPointerException.class, () -> {
            course.add(null);
        });
        assertEquals(NullPointerException.class, e.getClass());
    }

    @Test
    public void testFireMaximaEvent() {
        counter = 0;
        TemperatureCourse course = new TemperatureCourse();
        course.addTemperatureMaximaEventListener(new TemperatureMaximaEventListener() {
            @Override
            public void handleTemperatureMaximaEvent(TemperatureMaximaEvent event) {
                counter++;
            }
        });
        course.add(ImmutableTemperature.createFromCelsius(20f));
        course.add(ImmutableTemperature.createFromCelsius(30f));
        course.add(ImmutableTemperature.createFromCelsius(50));
        assertThat(counter).isEqualTo(3);
    }

    @Test
    public void testFireMinimaEvent() {
        counter = 0;
        TemperatureCourse course = new TemperatureCourse();
        course.addTemperatureMinimaEventListener(new TemperatureMinimaEventListener() {
            @Override
            public void handleTemperatureMinimaEvent(TemperatureMinimaEvent event) {
                counter++;
            }
        });
        course.add(ImmutableTemperature.createFromCelsius(-10f));
        course.add(ImmutableTemperature.createFromCelsius(-20f));
        course.add(ImmutableTemperature.createFromCelsius(50));
        assertThat(counter).isEqualTo(2);
    }
}