package ch.hslu.oop.sw08;

public final class Circle extends Shape {

    private int diameter;

    public Circle(final int x, final int y, final int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public void changeDiameter(final int newDiameter) {
        this.diameter = newDiameter;
    }

    @Override
    public int getPerimeter() {
        return (int) (diameter * Math.PI);
    }

    @Override
    public int getArea() {
        return (int) (Math.pow((double) this.diameter, 2.0) * Math.PI) / 4;
    }

    public double getExactArea() {
        return (Math.pow((double) this.diameter, 2) * Math.PI) / 4;
    }

    public int getDiameter() {
        return this.diameter;
    }
}