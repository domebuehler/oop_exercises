package ch.hslu.oop.sw05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CircleTest {

    private Circle circle = new Circle(1, 1, 10);

    @Test
    public void testGetPerimeter() {
        assertEquals("Should be 31", 31, this.circle.getPerimeter());
    }

    @Test
    public void testGetArea() {
        assertEquals("Should be 78", 78, this.circle.getArea());
    }

    @Test
    public void testGetExactArea() {
        assertEquals(78.5398, this.circle.getExactArea(), 0.0001);
    }
}