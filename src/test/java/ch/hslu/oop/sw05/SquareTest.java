package ch.hslu.oop.sw05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {

    @Test
    void getPerimeter() {
        Square square = new Square(1, 1, 5);
        assertEquals(20, square.getPerimeter(), "should be 20");
    }

    @Test
    void getArea() {
        Square square = new Square(1, 1, 5);
        assertEquals(25, square.getArea(), "Should be 25");
    }
}