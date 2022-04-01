package ch.hslu.oop.sw06.polymorphie;

public class Temperatur {

    private float tempCelsius;
    private static float ABSOLUT_ZERO = -273.15f;

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


    private static float convertFahrenheitToCelsius(float tempFahrenheit) {
        return (tempFahrenheit - 32.0f) / 1.8f;
    }

    private static float convertKelvinToCelsius(float tempKelvin) {
        return tempKelvin - 273.15f;
    }

    @Override
    public String toString() {
        return "[Temperatur = " + this.tempCelsius + "°C]";
    }

    public float getTempCelsius() {
        return this.tempCelsius;
    }

    public void setTempCelsius(float tempCelsius) {
        if (tempCelsius > Temperatur.ABSOLUT_ZERO) {
            this.tempCelsius = tempCelsius;
        } else {
            System.out.println("Ungültiger Wert! Wird nicht gesetzt!");
        }
    }

    public float getTempFahrenheit() {
        return this.tempCelsius * 1.8f + 32.0f;
    }

    public float getTempKelvin() {
        return this.tempCelsius + 273.15f;
    }
}
