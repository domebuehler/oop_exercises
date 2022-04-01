package ch.hslu.oop.rep.interfaces;

/**
 * Declares a switchable object.
 */
public interface Switchable {
    /**
     * Switches an object on.
     */
    void switchOn();

    /**
     * Switches an object off.
     */
    void switchOff();

    /**
     * Checks if object is switched on.
     *
     * @return {@code true} when object is switched on. {@code false} when object ist switched off.
     */
    boolean isSwitchedOn();

    /**
     * Checks if object is switched off.
     *
     * @return {@code true} when is object switched off. {@code false} when object ist switched on.
     */
    boolean isSwitchedOff();
}
