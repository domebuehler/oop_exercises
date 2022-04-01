package ch.hslu.oop.rep.interfaces;

/**
 * Counts switching-events.
 */
public interface CountingSwitchable extends Switchable {

    /**
     * Returns actual SwitchCount.
     *
     * @return the {@code long} value of the SwitchCount.
     */
    public long getSwitchCount();
}
