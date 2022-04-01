package ch.hslu.oop.sw04;

/* Kommentar zur Aufgabenstellung:
 *  Die Überraschung hat uns gezeigt, dass Java ungewünscht Objekte abändert, wenn
 *  mit diesen nicht richtig umgeht! Stichwort: Information Hiding!
 *  Denn Java arbeitet bei Objekten nur mit deren Referenzen.
 *  Das heisst, dass bei der Übergabe oder Übernahme (Setter und Getter) eines Objekts jeweils eine
 *  Kopie erstellt werden sollte! Siehe Beispiel Get/Set-Methoden unten.
 *  Alternativ lassen sich auch Immutable Objects erzeugen (unveränderbare Objekte)*/
public class Line {

    //---Variante A---
    private Point startPoint;
    private Point endPoint;

    //---Variante B---
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;

    //---Variante A---
    public Line(Point startPoint, Point endPoint) {
        this.endPoint = endPoint;
        this.startPoint = startPoint;
    }

    //---Variante B---
    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    //---Variante A---
    public String toStringPoints() {
        return "---Linie---\n" + "Startpunkt: " + this.startPoint.toString() + "\n" +
                "Endpunkt: " + this.endPoint.toString();
    }

    //--- Variante B---
    public String toStringValues() {
        return "---Linie---\n" + "Startpunkt: x=" + this.xStart + ", y=" + this.yEnd +
                "\nEndpunkt: x=" + this.xEnd + ", y=" + this.yStart;
    }

    //---Variante A---
    public Point getStartPointA() {
        //return this.startPoint;
        return new Point(this.startPoint.getXValue(), this.startPoint.getYValue());
    }

    public Point getEndPointA() {
        //return this.endPoint;
        return new Point(this.endPoint.getXValue(), this.endPoint.getYValue());
    }

    //---Variante B---
    public Point getStartPointB() {
        return new Point(this.xStart, this.yStart);
    }

    public Point getEndPointB() {
        return new Point(this.xEnd, this.yEnd);
    }

    //---Variante A---
    public void setStartPointA(Point newPoint) {
        this.startPoint = new Point(newPoint.getXValue(), newPoint.getYValue());
    }

    public void setEndPointA(Point newPoint) {
        this.endPoint = new Point(newPoint.getXValue(), newPoint.getYValue());
    }

    //---Variante B---
    public void setStartPointB(int xValue, int yValue) {
        this.xStart = xValue;
        this.yStart = yValue;
    }

    public void setEndPointB(int xValue, int yValue) {
        this.xEnd = xValue;
        this.yEnd = yValue;
    }
}
