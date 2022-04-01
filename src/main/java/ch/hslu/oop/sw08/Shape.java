package ch.hslu.oop.sw08;

public abstract class Shape {

    private int x;
    private int y;

    protected Shape(int newX, int newY) {
        this.x = x;
        this.y = y;
    }

    public final void move(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public abstract int getPerimeter();

    public abstract int getArea();

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
