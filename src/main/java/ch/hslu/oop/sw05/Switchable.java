package ch.hslu.oop.sw05;

/**
 * Dient als Schnittstelle fuer ein schaltbares Objekt.
 */
public interface Switchable {
    /**
     * Schaltet ein Objekt ein.
     */
    void switchOn();

    /**
     * Schaltet ein Objekt aus.
     */
    void switchOff();

    /**
     * Ueberprueft, ob ein Objekt eingeschaltet ist.
     *
     * @return {@code true} wenn Objekt eingeschaltet, {@code false} wenn Objekt ausgeschaltet.
     */
    boolean isSwitchedOn();

    /**
     * Ueberprueft, ob ein Objekt ausgeschaltet ist.
     *
     * @return {@code true} wenn Objekt ausgeschaltet,{@code false} wenn Objekt eingeschaltet.
     */
    boolean isSwitchedOff();
}
