package ch.hslu.oop.sw03;

/**
 * Die Klasse Temperatur repraesentiert eine Temperatur als Grad Celcius.
 * Die Klasse stellt Methoden zur Verfuegung, um die Temperatur umzurechnen
 * oder anzupassen. Des weiteren kann sie den Aggragatzustand abfragen.
 *
 * @author (Dominik Buehler)
 * @version (06.10.2021)
 */
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
        float adjustedTempKelvin = this.getTempKelvin() + adjustValueKelvin;
        this.tempCelsius = this.convertKelvinToCelsius(adjustedTempKelvin);
    }

    public void adjustTempInFahrenheit(float adjustValueFahrenheit) {
        float adjustedTempFahrenheit = this.getTempFahrenheit() + adjustValueFahrenheit;
        this.tempCelsius = this.convertFahrenheitToCelsius(adjustedTempFahrenheit);
    }

    private float convertKelvinToCelsius(float tempKelvin) {
        return tempKelvin - 273.15f;
    }

    private float convertFahrenheitToCelsius(float tempFahrenheit) {
        return (tempFahrenheit - 32.0f) / 1.8f;
    }

    /**
     * Ermittelt den Aggregatszustand eines Elements, das uebergeben wird
     * und liefert den entsprechenden String zurueck.
     *
     * @param element - Element das ueberprueft wird.
     * @return String - String der den Aggregatszustand enthaelt
     */
    public String getStateSwitch(String element) {
        String state = "";
        switch (element) {
            case "N":
                if (this.getTempCelsius() > -195.83) {
                    state = "gasförmig";
                } else if (this.getTempCelsius() < -195.82f && this.getTempCelsius() > -290.99f) {
                    state = "flüssig";
                } else {
                    state = "fest";
                }
                break;
            case "Hg":
                if (this.getTempCelsius() > -38.83f && this.getTempCelsius() < 357.00f) {
                    state = "flüssig";
                } else if (this.getTempCelsius() > 357.00f) {
                    state = "gasförmig";
                } else {
                    state = "fest";
                }
                break;
            case "Pb":
                if (this.getTempCelsius() < 327.42f) {
                    state = "fest";
                } else if (this.getTempCelsius() > 327.42f && this.getTempCelsius() < 1744.00f) {
                    state = "flüssig";
                } else {
                    state = "gasförmig";
                }
                break;
            default:
                state = "ungültiges Element";
                break;
        }

        return state;
    }

    public String getStateIfElse(String element) {
        String state = "";

        if (element.equalsIgnoreCase("N")) {
            if (this.getTempCelsius() > -195.83) {
                state = "gasförmig";
            } else if (this.getTempCelsius() < -195.82f && this.getTempCelsius() > -290.99f) {
                state = "flüssig";
            } else {
                state = "fest";
            }
        } else if (element.equalsIgnoreCase("Hg")) {
            if (this.getTempCelsius() > -38.83f && this.getTempCelsius() < 357.00f) {
                state = "flüssig";
            } else if (this.getTempCelsius() > 357.00f) {
                state = "gasförmig";
            } else {
                state = "fest";
            }
        } else if (element.equalsIgnoreCase("Pb")) {
            if (this.getTempCelsius() < 327.42f) {
                state = "fest";
            } else if (this.getTempCelsius() > 327.42f && this.getTempCelsius() < 1744.00f) {
                state = "flüssig";
            } else {
                state = "gasförmig";
            }
        } else {
            state = "unbekanntes Element";
        }

        return state;
    }

    public String getStateAnotherSolutions(String element) {

        String state = "fest";
        float meltPoint;
        float evaporationPoint;

        if (element.equalsIgnoreCase("N")) {
            meltPoint = -210.0f;
            evaporationPoint = -196.00f;
        } else if (element.equalsIgnoreCase("HG")) {
            meltPoint = -38.8f;
            evaporationPoint = 357.0f;
        } else {
            meltPoint = 327.4f;
            evaporationPoint = 17440f;
        }

        if (this.tempCelsius > meltPoint && this.tempCelsius < evaporationPoint) {
            state = "flüssig";
        } else if (this.tempCelsius > evaporationPoint) {
            state = "gasförmig";
        }
        return state;
    }

    /*Getter und Setter Methoden*/
    public float getTempCelsius() {
        return this.tempCelsius;
    }

    public void setTempCelsius(float tempCelsius) {
        this.tempCelsius = tempCelsius;
    }

    public float getTempKelvin() {
        return this.tempCelsius + 273.15f;
    }

    public float getTempFahrenheit() {
        return this.tempCelsius * 1.8f + 32.0f;
    }
}
