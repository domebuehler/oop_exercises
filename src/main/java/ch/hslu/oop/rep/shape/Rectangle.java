package ch.hslu.oop.rep.shape;

public final class Rectangle extends Shape {

    private int width;
    private int height;

    protected Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public int getPerimeter() {
        return 2 * this.width + 2 * this.height;
    }

    @Override
    public int getArea() {
        return this.width * this.height;
    }

    public void changeDimension(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
