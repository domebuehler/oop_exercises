package ch.hslu.oop.rep.shape;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShapeTest {

    @Test
    public void testMove() {
        Shape shape = new Circle(1, 1, 10);
        shape.move(10, 1);
        assertThat(shape.getX()).isEqualTo(10);
    }

    @Test
    public void testPolymorphie() {
        Shape shape1 = new Circle(1, 1, 10);
        Shape shape2 = new Rectangle(1, 1, 10, 10);
        shape1.move(10, 10);
        shape2.move(10, 10);

        int diameter = ((Circle) shape1).getDiameter();
        int width = ((Rectangle) shape2).getWidth();

        assertThat(diameter).isEqualTo(10);
        assertThat(width).isEqualTo(10);
    }

}