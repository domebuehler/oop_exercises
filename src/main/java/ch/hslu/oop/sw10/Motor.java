package ch.hslu.oop.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Motor implements Switchable {

    private static final Logger LOG = LogManager.getLogger(Motor.class);

    private MotorState motorState;
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    public Motor() {
        this.motorState = MotorState.OFF;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.motorState = MotorState.ON;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "motorState", MotorState.OFF, MotorState.ON));
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.motorState = MotorState.OFF;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "motorState", MotorState.ON, MotorState.OFF));
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.motorState == MotorState.ON;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.motorState == MotorState.OFF;
    }

    public MotorState getMotorState() {
        return this.motorState;
    }

    public void addPropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            this.changeListeners.add(propertyChangeListener);
        } else {
            LOG.info("add failed because actual parameter was null");
        }
    }

    public void removePropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            this.changeListeners.remove(propertyChangeListener);
        } else {
            LOG.info("remove failed because actual parameter was null");
        }
    }

    public void firePropertyChangeEvent(final PropertyChangeEvent propertyChangeEvent) {
        if (this.changeListeners.size() > 0) {
            for (PropertyChangeListener listener : this.changeListeners) {
                listener.propertyChange(propertyChangeEvent);
            }
        }
    }
}
