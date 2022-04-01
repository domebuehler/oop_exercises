package ch.hslu.oop.sw04;

public class Main {

    public static void main(String[] args) {

        Point start = new Point(10, 5);
        Point end = new Point(24, 13);


        Line line1 = new Line(start, end);
        System.out.println(line1.toStringPoints());

        /*Line line2 = new Line(5,10, 17, 19);
        System.out.println(line2.toStringValues());*/

        Point point = line1.getStartPointA();
        point.setXValue(133);
        point.setYValue(155);
        System.out.println(line1.toStringPoints());
        line1.setEndPointA(point);
        System.out.println(line1.toStringPoints());
    }
}
