package ch.hslu.oop.rep.shape;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CircleTest {

    @Test
    public void testGetArea() {
        Circle circle = new Circle(1, 1, 10);
        int area = circle.getArea();
        assertThat(area).isEqualTo(78);
    }

    @Test
    public void testGetPerimeter() {
        Circle circle = new Circle(1, 1, 10);
        int perimeter = circle.getPerimeter();
        assertThat(perimeter).isEqualTo(31);
    }

}