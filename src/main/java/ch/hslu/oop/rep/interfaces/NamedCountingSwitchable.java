package ch.hslu.oop.rep.interfaces;

/**
 * Names a switch-events counting object.
 */

public interface NamedCountingSwitchable extends CountingSwitchable {

    /**
     * Sets the name of an object.
     *
     * @param name The name in form of a String.
     */
    public void setName(final String name);

    /**
     * Gets the name of an object.
     *
     * @return the name in form of an {@code String} value of an object.
     */
    public String getName();
}
