package ch.hslu.oop.sw07;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    public void testEqualsTrue() {
        Point point = new Point(5, 5);
        Point secondPoint = new Point(5, 5);
        assertThat(point.equals(secondPoint)).isTrue();
    }

    @Test
    public void testEqualsAllDifferent() {
        Point point = new Point(5, 5);
        Point secondPoint = new Point(10, 10);
        assertThat(point.equals(secondPoint)).isFalse();
    }

    @Test
    public void testEqualsXDifferent() {
        Point point = new Point(5, 5);
        Point secondPoint = new Point(10, 5);
        assertThat(point.equals(secondPoint)).isFalse();
    }

    @Test
    public void testEqualsYDifferent() {
        Point point = new Point(5, 5);
        Point secondPoint = new Point(5, 10);
        assertThat(point.equals(secondPoint)).isFalse();
    }

    @Test
    public void testEqualsIdentity() {
        Point point = new Point(5, 5);
        Point secondPoint = point;
        assertThat(point.equals(secondPoint)).isTrue();
    }

    @Test
    public void testEqualsOtherClass() {
        Point point = new Point(5, 5);
        Object object = new Object();
        assertThat(point.equals(object)).isFalse();
    }

    @Test
    public void testEqualsNull() {
        Point point = new Point(10, 10);
        Point secondPoint = null;
        assertThat(point.equals(secondPoint)).isFalse();
    }

    @Test
    public void testHashCodeIfEqual() {
        Point point = new Point(10, 10);
        Point secondPoint = new Point(10, 10);
        assertThat(point.hashCode()).isEqualTo(secondPoint.hashCode());
    }

    @Test
    public void testHashCodeIfNotEqual() {
        Point point = new Point(10, 5);
        Point secondPoint = new Point(10, 10);
        assertThat(point.hashCode()).isNotEqualTo(secondPoint.hashCode());
    }

    @Test
    public void TestCompareToIfEqual() {
        Point point = new Point(10, 10);
        Point secondPoint = new Point(10, 10);
        assertThat(point.compareTo(secondPoint)).isEqualTo(0);
    }

    @Test
    public void TestCompareToXBigger() {
        Point point = new Point(20, 10);
        Point secondPoint = new Point(10, 10);
        assertThat(point.compareTo(secondPoint)).isEqualTo(1);
    }

    @Test
    public void TestCompareToXSmaller() {
        Point point = new Point(10, 10);
        Point secondPoint = new Point(20, 10);
        assertThat(point.compareTo(secondPoint)).isEqualTo(-1);
    }

    @Test
    public void TestCompareToXEqualYBigger() {
        Point point = new Point(10, 20);
        Point secondPoint = new Point(10, 10);
        assertThat(point.compareTo(secondPoint)).isEqualTo(1);
    }

    @Test
    public void TestCompareToXEqualYSmaller() {
        Point point = new Point(10, 10);
        Point secondPoint = new Point(10, 20);
        assertThat(point.compareTo(secondPoint)).isEqualTo(-1);
    }
}