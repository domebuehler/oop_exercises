package ch.hslu.oop.sw05;

/* Kommentar zur Aufgabenstellung:
 *   Dieses Interface bietet uns dieselben Möglichkeiten wie das Named Interface.
 *   Da es aber von dem CountingSwitchable Interface erbt ist die Kopplung sehr stark.
 *   Eine Klasse erlaubt uns beliebige Interfaced zu implementieren. Darum ist diese
 *   Vorgehensweise eher ungewöhnlich.
 * */

/**
 * This Interface allows to name CountingSwitchable-Objects.
 */
public interface NamedCountingSwitchable extends CountingSwitchable {
    /**
     * Sets the Name of an object.
     *
     * @param name Name of the object.
     */
    void setName(final String name);

    /**
     * Return the name of an object.
     *
     * @return Name of the object.
     */
    String getName();
}
