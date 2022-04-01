package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;

import java.util.Objects;

public class Lead extends Element {

    private static final Temperature EVAPORATION_POINT = new Temperature(1744.0f);
    private static final Temperature MELTING_POINT = new Temperature(327.4f);

    protected Lead() {
        super(EVAPORATION_POINT, MELTING_POINT);
    }

    /*@Override
    public int hashCode() {
        return Objects.hashCode(this.getClass());
    }*/

    /*@Override
    public boolean equals(Object obj) {
        if (obj == null || this == null) {
            return false;
        } else if (Objects.equals(obj.getClass(), this.getClass())) {
            return true;
        }
        return false;
    }*/
}
