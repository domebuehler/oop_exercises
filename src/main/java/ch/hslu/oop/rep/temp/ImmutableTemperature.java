package ch.hslu.oop.rep.temp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@SuppressWarnings("ClassCanBeRecord")
public final class ImmutableTemperature implements Comparable<ImmutableTemperature> {

    private static final Logger LOG = LogManager.getLogger(ImmutableTemperature.class);

    public static final float KELVIN_OFFSET = 273.15f;
    private static final float FAHRENHEIT_MULTIPLICATOR = 1.8f;
    private static final float FAHRENHEIT_OFFSET = 32f;
    private final float temperatureInCelsius;

    private ImmutableTemperature(float temperatureInCelsius) {
        if (temperatureInCelsius >= -KELVIN_OFFSET) {
            this.temperatureInCelsius = temperatureInCelsius;
        } else {
            throw new IllegalArgumentException(temperatureInCelsius + " is not a valid value");
        }
    }

    public static ImmutableTemperature createFromCelsius(final float temperatureInCelsius) {
        return new ImmutableTemperature(temperatureInCelsius);
    }

    public static ImmutableTemperature createFromKelvin(final float temperatureInKelvin) {
        return createFromCelsius(convertKelvinToCelsius(temperatureInKelvin));
    }

    public static ImmutableTemperature creatFromFahrenheit(final float temperatureInFahrenheit) {
        return createFromCelsius(convertFahrenheitToCelsius(temperatureInFahrenheit));
    }

    public static float convertKelvinToCelsius(float temperatureInKelvin) {
        return temperatureInKelvin - KELVIN_OFFSET;
    }

    public static float convertCelsiusToKelvin(float temperatureInCelsius) {
        return temperatureInCelsius + KELVIN_OFFSET;
    }

    public static float convertFahrenheitToCelsius(float temperatureInFahrenheit) {
        return (temperatureInFahrenheit - FAHRENHEIT_OFFSET) / FAHRENHEIT_MULTIPLICATOR;
    }

    public static float convertCelsiusToFahrenheit(float temperatureInCelsius) {
        return (temperatureInCelsius * FAHRENHEIT_MULTIPLICATOR) + FAHRENHEIT_OFFSET;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ImmutableTemperature)) {
            return false;
        }
        ImmutableTemperature other = (ImmutableTemperature) o;
        return Objects.equals(other.temperatureInCelsius, this.temperatureInCelsius);
    }

    @Override
    public int hashCode() {
        return Float.hashCode(this.temperatureInCelsius);
    }

    @Override
    public int compareTo(ImmutableTemperature other) {
        if (other == null) {
            throw new NullPointerException();
        } else if (other == this) {
            return 0;
        }
        return Float.compare(this.temperatureInCelsius, other.temperatureInCelsius);
    }

    @Override
    public String toString() {
        return "ImmutableTemperature[" +
                "temperatureInCelsius=" + temperatureInCelsius +
                ']';
    }

    public float getTemperatureInCelsius() {
        return temperatureInCelsius;
    }
}
