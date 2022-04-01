package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElementTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.
                forClass(Element.class).
                usingGetClass().
                withIgnoredFields("name", "evaporatePoint", "meltPoint").
                verify();
    }

    @Test
    public void testEqualsValueEquality() {
        Quecksilber quecksilber = new Quecksilber();
        Quecksilber quecksilber1 = new Quecksilber();
        assertThat(quecksilber.equals(quecksilber1)).isTrue();
    }

    @Test
    public void testEqualsFalse() {
        Blei blei = new Blei();
        Stickstoff stickstoff = new Stickstoff();
        assertThat(blei.equals(stickstoff)).isFalse();
    }

    @Test
    public void testEqualsIfNull() {
        Blei blei = new Blei();
        Blei blei2 = null;
        assertThat(blei.equals(blei2)).isFalse();
    }

    @Test
    public void testEqualsIfOtherClass() {
        Blei blei = new Blei();
        Object obj = new Object();
        assertThat(blei.equals(obj)).isFalse();
    }

    @Test
    public void testCompareToIfEqual() {
        Quecksilber quecksilber = new Quecksilber();
        Quecksilber quecksilber1 = new Quecksilber();
        assertThat(quecksilber.compareTo(quecksilber1)).isEqualTo(0);
    }

    @Test
    public void testCompareToSmaller() {
        Quecksilber quecksilber = new Quecksilber();
        Stickstoff stickstoff = new Stickstoff();
        assertThat(quecksilber.compareTo(stickstoff)).isNegative();
    }

    @Test
    public void testCompareToBigger() {
        Quecksilber quecksilber = new Quecksilber();
        Stickstoff stickstoff = new Stickstoff();
        assertThat(stickstoff.compareTo(quecksilber)).isPositive();
    }
}