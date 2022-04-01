package ch.hslu.oop.sw06.polymorphie;


public class Rectangle extends Shape {

    private int height;
    private int width;

    public Rectangle(final int x, final int y, final int height, final int width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public void changeDimension(final int newHeight, final int newWidth) {
        this.height = newHeight;
        this.width = newWidth;
    }

    @Override
    public int getPerimeter() {
        return this.height * 2 + this.width * 2;
    }

    @Override
    public int getArea() {
        return this.height * this.width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
