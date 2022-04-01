package ch.hslu.oop.sw06.polymorphie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperaturTest {

    @Test
    void testTemperaturBelowZeroPoint() {
        Temperatur temperatur = new Temperatur(-274.0f);
        assertEquals(0.0f, temperatur.getTempCelsius(), 0.01f);
    }

    @Test
    void testAdjustTempInCelsius() {
        Temperatur temperatur = new Temperatur(20.0f);
        temperatur.adjustTempInCelsius(50.0f);
        assertEquals(70.0f, temperatur.getTempCelsius(), 0.01);
    }

    @Test
    void testAdjustTempInKelvin() {
        Temperatur temperatur = new Temperatur(20.0f);
        temperatur.adjustTempInKelvin(50.0f);
        assertEquals(70.0f, temperatur.getTempCelsius(), 0.01);
    }

    @Test
    void testAdjustTempInFahrenheit() {
        Temperatur temperatur = new Temperatur(20.0f);
        temperatur.adjustTempInFahrenheit(30.0f);
        assertEquals(36.666f, temperatur.getTempCelsius(), 0.01);
    }

    @Test
    void testGetStateDependingOnTemperatur1800DegBlei() {
        Temperatur temperatur = new Temperatur(1800.0f);
        Blei blei = new Blei();
        assertEquals("gasförmig", temperatur.getStateDependingOnTemperatur(blei));
    }

    @Test
    void testGetStateDependingOnTemperatur400DegQuecksilber() {
        Temperatur temperatur = new Temperatur(400.0f);
        Quecksilber quecksilber = new Quecksilber();
        assertEquals("gasförmig", temperatur.getStateDependingOnTemperatur(quecksilber));
    }

    @Test
    void testGetStateDependingOnTemperatur400DegBlei() {
        Temperatur temperatur = new Temperatur(400.0f);
        Blei blei = new Blei();
        assertEquals("flüssig", temperatur.getStateDependingOnTemperatur(blei));
    }

    @Test
    void testGetStateDependingOnTemperatur20DegStickstoff() {
        Temperatur temperatur = new Temperatur(20.0f);
        Stickstoff stickstoff = new Stickstoff();
        assertEquals("gasförmig", temperatur.getStateDependingOnTemperatur(stickstoff));
    }

    @Test
    void testGetStateDependingOnTemperatur20DegQuecksilber() {
        Temperatur temperatur = new Temperatur(20.0f);
        Quecksilber quecksilber = new Quecksilber();
        assertEquals("flüssig", temperatur.getStateDependingOnTemperatur(quecksilber));
    }

    @Test
    void testGetStateDependingOnTemperatur20DegBlei() {
        Temperatur temperatur = new Temperatur(20.0f);
        Blei blei = new Blei();
        assertEquals("fest", temperatur.getStateDependingOnTemperatur(blei));
    }

    @Test
    void testGetStateDependingOnTemperaturMinus40DegQuecksilber() {
        Temperatur temperatur = new Temperatur(-40.0f);
        Quecksilber quecksilber = new Quecksilber();
        assertEquals("fest", temperatur.getStateDependingOnTemperatur(quecksilber));
    }

    @Test
    void testGetStateDependingOnTemperaturMinus200DegStickstoff() {
        Temperatur temperatur = new Temperatur(-200.0f);
        Stickstoff stickstoff = new Stickstoff();
        assertEquals("flüssig", temperatur.getStateDependingOnTemperatur(stickstoff));
    }

    @Test
    void testGetStateDependingOnTemperaturMinus220DegStickstoff() {
        Temperatur temperatur = new Temperatur(-220.0f);
        Stickstoff stickstoff = new Stickstoff();
        assertEquals("fest", temperatur.getStateDependingOnTemperatur(stickstoff));
    }
}