package ch.hslu.oop.sw13.motorapp;

/**
 * Gets notified whenever a ReachedMaxRpmEvent is fired.
 */
public interface ReachedMaxRpmEventListener {

    public void handleRpmEvent(ReachedMaxRpmEvent event);
}
