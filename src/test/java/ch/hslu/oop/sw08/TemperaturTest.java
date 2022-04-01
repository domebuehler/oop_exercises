package ch.hslu.oop.sw08;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
    public void testEqualsContract() {
        EqualsVerifier.forClass(Temperatur.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void testEqualsTrue() {
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(20.0f);
        assertThat(temp1.equals(temp2)).isTrue();
    }

    @Test
    void testEqualsFalse() {
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        assertThat(temp1.equals(temp2)).isFalse();
    }

    @Test
    void testEqualsIdentity() {
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = temp1;
        assertThat(temp1.equals(temp2)).isTrue();
    }

    @Test
    void testEqualsNull() {
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = null;
        assertThat(temp1.equals(temp2)).isFalse();
    }


    @Test
    void testHashCodeEqual() {
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(20.0f);
        assertThat(temp1.hashCode()).isEqualTo(temp2.hashCode());
    }

    @Test
    void testHashCodeNotEqual() {
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        assertThat(temp1.hashCode()).isNotEqualTo(temp2.hashCode());
    }

    @Test
    void testCompareToObjectsEquals() {
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(20.0f);
        assertThat(temp1.compareTo(temp2)).isEqualTo(0);
    }

    @Test
    void testCompareToBigger() {
        Temperatur temp1 = new Temperatur(30.0f);
        Temperatur temp2 = new Temperatur(20.0f);
        assertThat(temp1.compareTo(temp2)).isEqualTo(1);
    }

    @Test
    void testCompareToSmaller() {
        Temperatur temp1 = new Temperatur(20.0f);
        Temperatur temp2 = new Temperatur(30.0f);
        assertThat(temp1.compareTo(temp2)).isEqualTo(-1);
    }

    @Test
    void testConvertCelsiusToKelvin() {
        assertEquals(323.15f, Temperatur.convertCelsiusToKelvin(50), 0.01f);
    }

    @Test
    void testConvertKelvinToCelsius() {
        assertEquals(50, Temperatur.convertKelvinToCelsius(323.15f), 0.01f);
    }
}