package ch.hslu.oop.sw07;

import java.util.Objects;

public abstract class Element implements Comparable<Element> {

    private final String name;
    private final float evaporatePoint;
    private final float meltPoint;

    public Element(String name, float evaporatePoint, float meltPoint) {
        this.evaporatePoint = evaporatePoint;
        this.meltPoint = meltPoint;
        this.name = name;
    }

    @Override
    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Element)) {
            return false;
        }
        return Objects.equals(this.getClass().getSimpleName(), other.getClass().getSimpleName());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.getClass().getSimpleName());
    }

    @Override
    public int compareTo(Element other) {
        if (this == other) {
            return 0;
        }
        return this.name.compareTo(other.name);
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