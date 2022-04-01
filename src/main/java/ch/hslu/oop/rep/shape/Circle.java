package ch.hslu.oop.rep.shape;

public final class Circle extends Shape {

    private int diameter;

    protected Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    @Override
    public int getPerimeter() {
        return (int) (this.diameter * Math.PI);
    }

    @Override
    public int getArea() {
        return (int) (Math.pow((double) this.diameter / 2, 2) * Math.PI);
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
