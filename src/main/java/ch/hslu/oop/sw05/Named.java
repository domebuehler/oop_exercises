package ch.hslu.oop.sw05;

/* Kommentar zur Aufgabenstellung
 *  Diese Vorgehensweise wird bevorzugt!
 * */

/**
 * Interface allows to name an Object.
 */
public interface Named {

    /**
     * Sets the name of the Object.
     *
     * @param name Name of the Object
     */
    void setName(final String name);

    /**
     * Returns the name of the Object.
     *
     * @return Name of the Object
     */
    String getName();
}
