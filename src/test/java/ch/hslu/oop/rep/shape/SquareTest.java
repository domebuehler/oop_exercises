package ch.hslu.oop.rep.shape;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SquareTest {

    @Test
    void getPerimeter() {
        Square square = new Square(1, 1, 10);
        int perimeter = square.getPerimeter();
        assertThat(perimeter).isEqualTo(40);
    }

    @Test
    void getArea() {
        Square square = new Square(1, 1, 10);
        int area = square.getArea();
        assertThat(area).isEqualTo(100);
    }
}