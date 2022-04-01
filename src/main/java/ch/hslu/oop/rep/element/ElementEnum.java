package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;

public enum ElementEnum {

    NITROGEN(new Temperature(-196.0f), new Temperature(-210.1f)),
    MERCURY(new Temperature(357.0f), new Temperature(-38.8f)),
    LEAD(new Temperature(1744.0f), new Temperature(327.4f));

    private final Temperature evaporationPoint;
    private final Temperature meltingPoint;

    ElementEnum(Temperature evaporationPoint, Temperature meltingPoint) {
        this.evaporationPoint = evaporationPoint;
        this.meltingPoint = meltingPoint;
    }

    public Temperature getEvaporationPoint() {
        return evaporationPoint;
    }

    public Temperature getMeltingPoint() {
        return meltingPoint;
    }
}
