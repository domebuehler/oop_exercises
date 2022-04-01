package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemperaturTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
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
}