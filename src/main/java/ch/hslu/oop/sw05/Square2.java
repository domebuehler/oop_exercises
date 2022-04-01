package ch.hslu.oop.sw05;

/* Kommentar zur Aufgabenstellung:
 *  Erbt direkt von der Klasse Rectangle, da ein Quadrat eine Spezialisierung eines Rechtecks ist.
 *  -Vorteil: erspart uns einige Zeilen an Code
 *  -Nachteil: es entsteht eine sehr grosse Kopplung!
 *  -Nachteil: Ein Quadrat lässt sich nicht problemlos als Rechteck interpretieren
 *             -> height / width können unabhängig voneinander ändern (können unterschiedlich werden)
 * */
public class Square2 extends Rectangle {

    public Square2(final int x, final int y, final int sideLength) {
        super(x, y, sideLength, sideLength);
    }
}
