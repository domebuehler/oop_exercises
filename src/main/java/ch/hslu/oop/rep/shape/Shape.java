package ch.hslu.oop.rep.shape;

/**
 * Represents a simple shape with a position in x/y-Coordinates.
 */
public abstract class Shape {
    private int x;
    private int y;

    protected Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }

    /**
     * Calculates the perimeter of the shape.
     *
     * @return actual perimeter int int
     */
    public abstract int getPerimeter();

    /**
     * Calculates the area of the shape.
     *
     * @return actual area in int
     */
    public abstract int getArea();

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }
}
