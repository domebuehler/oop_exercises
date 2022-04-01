package ch.hslu.oop.sw07;

import java.util.Objects;

public class Point implements Comparable<Point> {

    private int xValue;
    private int yValue;

    public Point(int xValue, int yValue) {
        this.setXValue(xValue);
        this.setYValue(yValue);
    }

    public Point(Point point) {
        this(point.getXValue(), point.getYValue());
    }

    public void moveRelative(int x, int y) {
        this.xValue += x;
        this.yValue += y;
    }

    public void moveRelative(Point point) {
        this.moveRelative(point.getXValue(), point.getYValue());
        /* Weniger elegante Lösung, da redundanter Code!
        this.xValue += point.getXValue();
        this.yValue += point.getYValue();*/
    }

    /**
     * Verschiebt einen Punkt um einen Vektor, der in Polarkoordinaten angegeben ist.
     *
     * @param value Betrag der Polarkoordinaten
     * @param angle Winkel der Polarkoordinaten
     */
    public void moveRelativePolar(int value, double angle) {
        Point point = getRelativeCoordinatesOfAnVektor(value, angle);
        this.moveRelative(point);
    }

    private Point getRelativeCoordinatesOfAnVektor(int value, double angle) {
        return new Point((int) (value * Math.cos(Math.toRadians(angle))),
                (int) (value * Math.sin(Math.toRadians(angle))));

    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Point)) {
            return false;
        }
        Point other = (Point) object;
        return this.xValue == other.xValue && this.yValue == other.yValue;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.xValue, this.yValue);
    }

    @Override
    public int compareTo(Point other) {
        if (this == other) {
            return 0;
        }
        if (Integer.compare(this.xValue, other.xValue) != 0) {
            return Integer.compare(this.xValue, other.xValue);
        } else {
            return Integer.compare(this.yValue, other.yValue);
        }
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

    @Override
    public String toString() {
        return "[Point: x=" + this.xValue + ", y=" + this.yValue + " ]";
    }
}
