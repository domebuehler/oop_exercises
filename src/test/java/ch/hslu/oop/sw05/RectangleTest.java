package ch.hslu.oop.sw05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void testGetPerimeter() {
        Rectangle rectangle = new Rectangle(1, 1, 10, 20);
        assertEquals("Perimeter should be 60", 60, rectangle.getPerimeter());
    }

    @Test
    public void testGetArea() {
        Rectangle rectangle = new Rectangle(1, 1, 10, 20);
        assertEquals("Area should be 200", 200, rectangle.getArea());
    }
}