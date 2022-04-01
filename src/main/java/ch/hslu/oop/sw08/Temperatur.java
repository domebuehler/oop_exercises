package ch.hslu.oop.sw08;

import ch.hslu.oop.sw07.Element;

public final class Temperatur implements Comparable<Temperatur> {

    private float tempCelsius;
    private static final float KELVIN_OFFSET = 273.15f;

    public Temperatur(float tempCelsius) {
        this.setTempCelsius(tempCelsius);
    }

    public Temperatur() {
        this.tempCelsius = 20.0f;
    }

    public void adjustTempInCelsius(float adjustValueCelsius) {
        this.setTempCelsius(this.tempCelsius += adjustValueCelsius);
    }

    public void adjustTempInKelvin(float adjustValueKelvin) {
        float adjustedTempInKelvin = this.getTempKelvin() + adjustValueKelvin;
        this.setTempCelsius(Temperatur.convertKelvinToCelsius(adjustedTempInKelvin));
    }

    public void adjustTempInFahrenheit(float adjustValueFahrenheit) {
        float adjustedTempInFahrenheit = this.getTempFahrenheit() + adjustValueFahrenheit;
        this.setTempCelsius(Temperatur.convertFahrenheitToCelsius(adjustedTempInFahrenheit));
    }

    public String getStateDependingOnTemperatur(Element element) {
        String state = "fest";

        if (this.tempCelsius > element.getMeltPoint() && this.tempCelsius < element.getEvaporatePoint()) {
            state = "flüssig";
        } else if (this.tempCelsius > element.getEvaporatePoint()) {
            state = "gasförmig";
        }
        return state;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Temperatur)) {
            return false;
        }
        Temperatur other = (Temperatur) object;
        return Float.compare(this.tempCelsius, other.tempCelsius) == 0;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(this.tempCelsius);
    }

    @Override
    public int compareTo(Temperatur other) {
        if (this == other) {
            return 0;
        }
        return Float.compare(this.tempCelsius, other.tempCelsius);
    }

    public static float convertFahrenheitToCelsius(float tempFahrenheit) {
        return (tempFahrenheit - 32.0f) / 1.8f;
    }

    public static float convertKelvinToCelsius(float tempKelvin) {
        return tempKelvin - KELVIN_OFFSET;
    }

    public static float convertCelsiusToKelvin(float tempCelsius) {
        return tempCelsius + Temperatur.KELVIN_OFFSET;
    }


    @Override
    public String toString() {
        return "[Temperatur = " + this.tempCelsius + "°C]";
    }

    public float getTempCelsius() {
        return this.tempCelsius;
    }

    public void setTempCelsius(float tempCelsius) {
        if (tempCelsius > -(Temperatur.KELVIN_OFFSET)) {
            this.tempCelsius = tempCelsius;
        } else {
            System.out.println("Ungültiger Wert! Wird nicht gesetzt!");
        }
    }

    public float getTempFahrenheit() {
        return this.tempCelsius * 1.8f + 32.0f;
    }

    public float getTempKelvin() {
        return this.tempCelsius + KELVIN_OFFSET;
    }
}
