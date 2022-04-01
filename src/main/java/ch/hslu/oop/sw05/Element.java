package ch.hslu.oop.sw05;

public abstract class Element {

    private String name;
    private float evaporatePoint;
    private float meltPoint;

    public Element(String name, float evaporatePoint, float meltPoint) {
        this.evaporatePoint = evaporatePoint;
        this.meltPoint = meltPoint;
        this.name = name;
    }

    public float getEvaporatePoint() {
        return evaporatePoint;
    }

    public float getMeltPoint() {
        return meltPoint;
    }
}
