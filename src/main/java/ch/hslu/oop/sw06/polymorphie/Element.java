package ch.hslu.oop.sw06.polymorphie;

public abstract class Element {

    private String name;
    private float evaporatePoint;
    private float meltPoint;

    public Element(String name, float evaporatePoint, float meltPoint) {
        this.evaporatePoint = evaporatePoint;
        this.meltPoint = meltPoint;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Element: " + this.name + ",\tSchmelzpunkt: " + this.meltPoint +
                "°C,\tSiedepunkt: " + this.evaporatePoint + "°C]";
    }

    public float getEvaporatePoint() {
        return evaporatePoint;
    }

    public float getMeltPoint() {
        return meltPoint;
    }
}
