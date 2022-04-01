package ch.hslu.oop.sw09;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TemperaturTest {
    @Test
    void testCreateFromKelvinNullKelvin() {
        Temperatur temperatur = Temperatur.createFromKelvin(0f);
        assertThat(temperatur.getTempCelsius()).isEqualTo(-273.15f);
    }

    @Test
    void testCreateFromKelvin273Kelvin() {
        Temperatur temperatur = Temperatur.createFromKelvin(273.15f);
        assertThat(temperatur.getTempCelsius()).isEqualTo(0f);
    }

    @Test
    void testCreatFromCelsiusLegalValue() {
        Temperatur temperatur = Temperatur.createFromCelsius(0f);
        assertThat(temperatur.getTempCelsius()).isEqualTo(0);
    }

    @Test
    @Disabled
    void testCreateFromCelsiusIllegalValue() {
        Temperatur temperatur = Temperatur.createFromCelsius(-300f);
        assertThat(temperatur.getTempCelsius()).isEqualTo(-(Temperatur.KELVIN_OFFSET));
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Temperatur.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void testEqualsTrue() {
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(20.0f);
        assertThat(temp1.equals(temp2)).isTrue();
    }

    @Test
    void testEqualsFalse() {
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);
        assertThat(temp1.equals(temp2)).isFalse();
    }

    @Test
    void testEqualsIdentity() {
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = temp1;
        assertThat(temp1.equals(temp2)).isTrue();
    }

    @Test
    void testEqualsNull() {
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = null;
        assertThat(temp1.equals(temp2)).isFalse();
    }


    @Test
    void testHashCodeEqual() {
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(20.0f);
        assertThat(temp1.hashCode()).isEqualTo(temp2.hashCode());
    }

    @Test
    void testHashCodeNotEqual() {
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);
        assertThat(temp1.hashCode()).isNotEqualTo(temp2.hashCode());
    }

    @Test
    void testCompareToObjectsEquals() {
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(20.0f);
        assertThat(temp1.compareTo(temp2)).isEqualTo(0);
    }

    @Test
    void testCompareToBigger() {
        Temperatur temp1 = Temperatur.createFromCelsius(30.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(20.0f);
        assertThat(temp1.compareTo(temp2)).isEqualTo(1);
    }

    @Test
    void testCompareToSmaller() {
        Temperatur temp1 = Temperatur.createFromCelsius(20.0f);
        Temperatur temp2 = Temperatur.createFromCelsius(30.0f);
        assertThat(temp1.compareTo(temp2)).isEqualTo(-1);
    }

    @Test
    void testConvertCelsiusToKelvin() {
        assertEquals(323.15f, Temperatur.convertCelsiusToKelvin(50), 0.01f);
    }

    @Test
    void testConvertKelvinToCelsius() {
        assertEquals(50f, Temperatur.convertKelvinToCelsius(323.15f), 0.01f);
    }

    @Test
    void testConvertFahrenheitToCelsius() {
        assertEquals(0f, Temperatur.convertFahrenheitToCelsius(32f), 0.01f);
    }

    @Test
    void testGetTempCelsius() {
        Temperatur temperatur = Temperatur.createFromCelsius(30f);
        assertEquals(30f, temperatur.getTempCelsius(), 0.01f);
        assertThat(temperatur.getTempCelsius()).isEqualTo(30f);
    }

    @Test
    void testGetTempKelvin() {
        Temperatur temperatur = Temperatur.createFromCelsius(20f);
        assertEquals(293.15f, temperatur.getTempKelvin(), 0.01f);
    }

    @Test
    void testGetTempFahrenheit() {
        Temperatur temperatur = Temperatur.createFromCelsius(0f);
        assertEquals(32f, temperatur.getTempFahrenheit(), 0.01f);
    }

    @Test
    void testIfCreatFromCelsiusThrowsIllegalArgumentException() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Temperatur.createFromCelsius(-300f);
        });
        assertEquals("Temperaturwert kleiner als absoluter Nullpunkt", exception.getMessage());
    }

    @Test
    void testIfCreatFromKelvinThrowsIllegalArgumentException() {
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Temperatur.createFromKelvin(-1f);
        });
        assertEquals("Temperaturwert kleiner als absoluter Nullpunkt", exception.getMessage());
    }

    @Test
    void testIfCreatFromCelsiusThrowsIllegalArgumentExceptionAssertJ() {
        assertThatThrownBy(() -> {
            Temperatur.createFromCelsius(-300f);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Temperaturwert kleiner als absoluter Nullpunkt");
    }

    @Test
    void testIfCreatFromKelvinThrowsIllegalArgumentExceptionAssertJ() {
        assertThatThrownBy(() -> {
            Temperatur.createFromKelvin(-1f);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Temperaturwert kleiner als absoluter Nullpunkt");
    }
}