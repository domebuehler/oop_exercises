package ch.hslu.oop.sw06.polymorphie;

public class Quecksilber extends Element {

    public Quecksilber() {
        super("Hg", 357.0f, -38.8f);
    }

    @Override
    public String toString() {
        return "!GIFTIG! " + super.toString();
    }
}
