package ch.hslu.oop.sw05;

/* Kommentar zur Aufgabenstellung
 *  Erbt von der Klasse Shape!
 *  -Vorteil: verringert die Kopplung! weniger missverständlich als Vererbung von Rectangle
 *  -Nachteil: erzeugt in diesem Beispiel viel doppelten Code
 * */
public class Square extends Shape {

    private int sideLength;

    public Square(final int x, final int y, final int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    public void changeSideLength(int newSideLength) {
        this.sideLength = newSideLength;
    }

    @Override
    public int getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public int getArea() {
        return (int) Math.pow((double) sideLength, 2.0);
    }
}
