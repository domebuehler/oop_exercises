package ch.hslu.oop.sw05;

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

    public String getStateDependingOnTemperatur(Element element) {
        String state = "fest";

        if (this.tempCelsius > element.getMeltPoint() && this.tempCelsius < element.getEvaporatePoint()) {
            state = "flüssig";
        } else if (this.tempCelsius > element.getEvaporatePoint()) {
            state = "gasförmig";
        }
        return state;
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
