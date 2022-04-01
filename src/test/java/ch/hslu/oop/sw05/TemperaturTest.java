package ch.hslu.oop.sw05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperaturTest {

    @Test
    public void testGetStateDependingOnTemperatur() {

        Temperatur temperatur = new Temperatur(400.0f);
        Stickstoff stickstoff = new Stickstoff();
        Blei blei = new Blei();
        Quecksilber quecksilber = new Quecksilber();

        assertEquals("Should be liquid", "flüssig",
                temperatur.getStateDependingOnTemperatur(blei));
        assertEquals("Should be gasförmig", "gasförmig",
                temperatur.getStateDependingOnTemperatur(quecksilber));
        assertEquals("Should be gasförmig", "gasförmig",
                temperatur.getStateDependingOnTemperatur(stickstoff));

        temperatur.setTempCelsius(-200.0f);
        assertEquals("Should be stare", "fest",
                temperatur.getStateDependingOnTemperatur(blei));
        assertEquals("Should be stare", "fest",
                temperatur.getStateDependingOnTemperatur(quecksilber));
        assertEquals("Should be liquid", "flüssig",
                temperatur.getStateDependingOnTemperatur(stickstoff));

        temperatur.setTempCelsius(-220.0f);
        assertEquals("should be stare", "fest",
                temperatur.getStateDependingOnTemperatur(stickstoff));

        temperatur.setTempCelsius(25.0f);
        assertEquals("should be stare", "fest",
                temperatur.getStateDependingOnTemperatur(blei));
        assertEquals("should be liquid", "flüssig",
                temperatur.getStateDependingOnTemperatur(quecksilber));
        assertEquals("should be gasförmig", "gasförmig",
                temperatur.getStateDependingOnTemperatur(stickstoff));
    }
}