package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;

public final class Nitrogen extends Element {

    private static final Temperature EVAPORATION_POINT = new Temperature(-196.0f);
    private static final Temperature MELTING_POINT = new Temperature(-210.1f);

    protected Nitrogen() {
        super(EVAPORATION_POINT, MELTING_POINT);
    }
}
