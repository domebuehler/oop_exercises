package ch.hslu.oop.rep.point;

public final class Line {

    private Point startPoint;
    private Point endPoint;

    public Line(final Point startPoint, final Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return new Point(this.startPoint.getXValue(), this.startPoint.getYValue());
    }

    public Point getEndPoint() {
        return new Point(this.endPoint.getXValue(), this.endPoint.getYValue());
    }

    public void setStartPoint(final Point startPoint) {
        this.startPoint = new Point(startPoint.getXValue(), startPoint.getYValue());
    }

    public void setEndPoint(final Point endPoint) {
        this.endPoint = new Point(endPoint.getXValue(), endPoint.getYValue());
    }
}
