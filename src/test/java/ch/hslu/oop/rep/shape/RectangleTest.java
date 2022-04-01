package ch.hslu.oop.rep.shape;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RectangleTest {

    @Test
    void testGetPerimeter() {
        Rectangle rectangle = new Rectangle(1, 1, 10, 5);
        int perimeter = rectangle.getPerimeter();
        assertThat(perimeter).isEqualTo(30);
    }

    @Test
    void testGetArea() {
        Rectangle rectangle = new Rectangle(1, 1, 10, 5);
        int area = rectangle.getArea();
        assertThat(area).isEqualTo(50);
    }
}