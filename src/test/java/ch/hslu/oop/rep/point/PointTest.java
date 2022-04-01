package ch.hslu.oop.rep.point;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    public void testGetQuadrantFirst() {
        Point point = new Point(5, 5);
        int quadrant = point.getQuadrant();
        assertThat(quadrant).isEqualTo(1);
    }

    @Test
    public void testGetQuadrantSecond() {
        Point point = new Point(-5, 5);
        int quadrant = point.getQuadrant();
        assertThat(quadrant).isEqualTo(2);
    }

    @Test
    public void testGetQuadrantThird() {
        Point point = new Point(-5, -5);
        int quadrant = point.getQuadrant();
        assertThat(quadrant).isEqualTo(3);
    }

    @Test
    public void testGetQuadrantFourth() {
        Point point = new Point(5, -5);
        int quadrant = point.getQuadrant();
        assertThat(quadrant).isEqualTo(4);
    }

    @Test
    public void testGetQuadrantNone() {
        Point point = new Point(0, 5);
        int quadrant = point.getQuadrant();
        assertThat(quadrant).isEqualTo(0);
    }

    @Test
    public void testGetQuadrantNoneSecond() {
        Point point = new Point(5, 0);
        int quadrant = point.getQuadrant();
        assertThat(quadrant).isEqualTo(0);
    }

    @Test
    public void testMoveRelativ() {
        Point vector = new Point(10, 5);
        Point startPoint = new Point(5, 10);
        startPoint.moveRelativ(vector);
        assertThat(startPoint.getXValue()).isEqualTo(15);
        assertThat(startPoint.getYValue()).isEqualTo(15);
    }

    @Test
    public void testMoveRelativFromPolar() {
        Point startPoint = new Point(10, 10);
        startPoint.moveRelativeFromPolarCoordinates(10, Math.PI);
        assertThat(startPoint.getXValue()).isEqualTo(0);
        assertThat(startPoint.getYValue()).isEqualTo(10);
    }

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Point.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
}