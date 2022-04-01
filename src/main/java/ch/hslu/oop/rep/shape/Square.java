package ch.hslu.oop.rep.shape;

public final class Square extends Shape {

    private int sideLength;

    protected Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public int getPerimeter() {
        return this.sideLength * 4;
    }

    @Override
    public int getArea() {
        return this.sideLength * this.sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(final int sideLength) {
        this.sideLength = sideLength;
    }
}
