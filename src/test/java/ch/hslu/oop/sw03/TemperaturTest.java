package ch.hslu.oop.sw03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperaturTest {

    @Test
    public void testGetStateAnotherSolutions() {
        Temperatur temperatur = new Temperatur(400.0f);

        assertEquals("Should be vaporous", "gasförmig",
                temperatur.getStateAnotherSolutions("N"));
        assertEquals("Should be liquid", "flüssig",
                temperatur.getStateAnotherSolutions("PB"));
        assertEquals("Should be vaporous", "gasförmig",
                temperatur.getStateAnotherSolutions("HG"));
    }
}