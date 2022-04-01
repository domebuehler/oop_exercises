package ch.hslu.oop.sw05;

/**
 * Used to count how often an Object is Switched on.
 */
public interface CountingSwitchable extends Switchable {

    /**
     * Returns how many times an Object was switched on.
     *
     * @return the count
     */
    long getSwitchCount();
}
