package ch.hslu.oop.rep.temp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ImmutableTemperatureTest {

    private static final float Tolerance = 0.1f;

    @Test
    public void testCreateFromCelsius() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromCelsius(50f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(50f, within(Tolerance));
    }

    @Test
    public void testCreateFromKelvin() {
        ImmutableTemperature temperature = ImmutableTemperature.createFromKelvin(50f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(-223.15f, within(Tolerance));
    }

    @Test
    public void testCreateFromFahrenheit() {
        ImmutableTemperature temperature = ImmutableTemperature.creatFromFahrenheit(50f);
        assertThat(temperature.getTemperatureInCelsius()).isCloseTo(10f, within(Tolerance));
    }

    @Test
    public void testCreateFromCelsiusThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> {
            ImmutableTemperature.createFromCelsius(-300.0f);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("-300.0 is not a valid value");
    }

}