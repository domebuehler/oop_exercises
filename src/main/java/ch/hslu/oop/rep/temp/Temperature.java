package ch.hslu.oop.rep.temp;

import ch.hslu.oop.rep.element.ElementEnum;
import ch.hslu.oop.rep.element.StateOfAggregation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {

    private static final Logger LOG = LogManager.getLogger(Temperature.class);

    private static final float KELVIN_OFFSET = 273.15f;
    private static final float FAHRENHEIT_MULTIPLICATOR = 1.8f;
    private static final float FAHRENHEIT_OFFSET = 32f;
    private float temperatureInCelsius;

    public Temperature(float temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public Temperature() {
        this.temperatureInCelsius = 20f;
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

    public void adjustTemperatureInCelsiusFromCelsiusValue(float temperatureInCelsius) {
        this.temperatureInCelsius += temperatureInCelsius;
    }

    public void adjustTemperatureInCelsiusFromKelvinValue(float temperatureInKelvin) {
        float adjustedInCelsius = convertKelvinToCelsius(temperatureInKelvin);
        adjustTemperatureInCelsiusFromCelsiusValue(adjustedInCelsius);
    }

    public void adjustTemperatureInCelsiusFromFahrenheitValue(float temperatureInFahrenheit) {
        float adjustedInCelsius = convertFahrenheitToCelsius(temperatureInFahrenheit);
        adjustTemperatureInCelsiusFromCelsiusValue(adjustedInCelsius);
    }

    public StateOfAggregation getStateOfAggregation(ElementEnum element) {
        if (this.compareTo(element.getEvaporationPoint()) > 0) {
            return StateOfAggregation.GASEOUS;
        } else if (this.compareTo(element.getMeltingPoint()) > 0) {
            return StateOfAggregation.FLUID;
        } else {
            return StateOfAggregation.SOLID;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Temperature)) {
            return false;
        }
        Temperature other = (Temperature) o;
        return Objects.equals(other.temperatureInCelsius, this.temperatureInCelsius);
    }

    @Override
    public int hashCode() {
        return Float.hashCode(this.temperatureInCelsius);
    }

    @Override
    public int compareTo(Temperature other) {
        if (other == null) {
            throw new NullPointerException();
        } else if (other == this) {
            return 0;
        }
        return Float.compare(this.temperatureInCelsius, other.temperatureInCelsius);
    }

    @Override
    public String toString() {
        return "Temperature[" +
                "temperatureInCelsius=" + temperatureInCelsius +
                ']';
    }

    public float getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(float temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }
}
