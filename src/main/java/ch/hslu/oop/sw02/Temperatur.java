package ch.hslu.oop.sw02;

public class Temperatur {

    private float tempCelsius;

    public Temperatur(float tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public Temperatur() {
        this.tempCelsius = 20.0f;
    }

    public void adjustTempInCelsius(float adjustValueCelsius) {
        this.tempCelsius += adjustValueCelsius;
    }

    public void adjustTempInKelvin(float adjustValueKelvin) {
        float adjustedTempKelvin = this.calculateTempKelvin() + adjustValueKelvin;
        this.tempCelsius = this.calculateTempCelsius(adjustedTempKelvin);
    }

    public float calculateTempKelvin() {
        return this.tempCelsius + 273.15f;
    }

    public float calculateTempFahrenheit() {
        return this.tempCelsius * 1.8f + 32.0f;
    }

    private float calculateTempCelsius(float tempKelvin) {
        return tempKelvin - 273.15f;
    }

    public float getTempCelsius() {
        return this.tempCelsius;
    }

    public void setTempCelsius(float tempCelsius) {
        this.tempCelsius = tempCelsius;
    }
}
