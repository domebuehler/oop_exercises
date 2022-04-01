package ch.hslu.oop.sw04;

public class Point {

    private int xValue;
    private int yValue;

    public Point(int xValue, int yValue) {
        this.setXValue(xValue);
        this.setYValue(yValue);
    }

    public int getXValue() {
        return xValue;
    }

    public void setXValue(int xValue) {
        this.xValue = xValue;
    }

    public int getYValue() {
        return yValue;
    }

    public void setYValue(int yValue) {
        this.yValue = yValue;
    }

    public String toString() {
        return "x=" + this.xValue + ", y=" + this.yValue;
    }
}
