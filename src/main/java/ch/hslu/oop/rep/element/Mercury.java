package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;

public class Mercury extends Element {

    private static final Temperature EVAPORATION_POINT = new Temperature(357.0f);
    private static final Temperature MELTING_POINT = new Temperature(-38.8f);

    protected Mercury() {
        super(EVAPORATION_POINT, MELTING_POINT);
    }

    @Override
    public String toString() {
        return "Giftig! " + super.toString();
    }
}
