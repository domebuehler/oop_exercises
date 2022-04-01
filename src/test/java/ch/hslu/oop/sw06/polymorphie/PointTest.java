package ch.hslu.oop.sw06.polymorphie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    void testMoveRelativeIntParameter() {
        Point point = new Point(5, 5);
        point.moveRelative(5, 10);
        /*assertEquals(10, point.getXValue());
        assertEquals(15, point.getYValue());
        assertAll("point",
                () -> assertEquals(10, point.getXValue()),
                () -> assertEquals(15, point.getYValue()));*/
        assertEquals(true, point.equals(new Point(10, 15)));
    }

    @Test
    void testMoveRelativePointParameter() {
        Point point = new Point(5, 5);
        point.moveRelative(new Point(5, 10));
        /*assertEquals(10, point.getXValue());
        assertEquals(15, point.getYValue());*/
        assertEquals(true, point.equals(new Point(10, 15)));
    }

    @Test
    void testMoveRelativePolarParameter() {
        Point point = new Point(5, 10);
        point.moveRelativePolar(10, 90.0);
        /*assertEquals(5, point.getXValue());
        assertEquals(20, point.getYValue());*/
        assertEquals(true, point.equals(new Point(5, 20)));
    }
}