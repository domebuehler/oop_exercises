package ch.hslu.oop.rep.point;

import java.util.Objects;

public final class Point {

    private static final int NOT_IN_A_QUADRANT = 0;
    private static final int FIRST_QUADRANT = 1;
    private static final int SECOND_QUADRANT = 2;
    private static final int THIRD_QUADRANT = 3;
    private static final int FOURTH_QUADRANT = 4;
    private int xValue;
    private int yValue;

    public Point(final int xValue, final int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public Point(Point point) {
        this(point.getXValue(), point.getYValue());
    }

    public void moveRelative(int xValue, int yValue) {
        this.xValue += xValue;
        this.yValue += yValue;
    }

    public void moveRelativ(Point vector) {
        this.moveRelative(vector.getXValue(), vector.getYValue());
    }

    public void moveRelativeFromPolarCoordinates(int value, double angle) {
        this.moveRelativ(convertPolarCoordinatesToPoint(value, angle));
    }

    private static Point convertPolarCoordinatesToPoint(int value, double angleInRadians) {
        int xValue = (int) (value * Math.cos(angleInRadians));
        int yValue = (int) (value * Math.sin(angleInRadians));
        return new Point(xValue, yValue);
    }

    public int getQuadrant() {
        if (this.xValue > 0 && this.yValue > 0) {
            return FIRST_QUADRANT;
        } else if (this.xValue < 0 && this.yValue > 0) {
            return SECOND_QUADRANT;
        } else if (this.xValue < 0 && this.yValue < 0) {
            return THIRD_QUADRANT;
        } else if (this.xValue > 0 && this.yValue < 0) {
            return FOURTH_QUADRANT;
        } else {
            return NOT_IN_A_QUADRANT;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        Point other = (Point) o;
        return other.xValue == this.xValue &&
                other.yValue == this.yValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.xValue, this.yValue);
    }

    @Override
    public String toString() {
        return "Point[" +
                "xValue=" + xValue +
                ", yValue=" + yValue +
                ']';
    }

    public int getXValue() {
        return xValue;
    }

    public int getYValue() {
        return yValue;
    }

    public void setXValue(final int xValue) {
        this.xValue = xValue;
    }

    public void setYValue(final int yValue) {
        this.yValue = yValue;
    }
}
