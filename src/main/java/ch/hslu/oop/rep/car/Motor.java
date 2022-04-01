package ch.hslu.oop.rep.car;

import ch.hslu.oop.rep.interfaces.CountingSwitchable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public final class Motor implements CountingSwitchable {

    private MotorState motorState;
    private long switchCount;
    private List<PropertyChangeListener> changeListeners = new ArrayList<>();

    public Motor() {
        this.motorState = MotorState.OFF;
        this.switchCount = 0;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.motorState = MotorState.ON;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "motorState", MotorState.OFF, MotorState.ON));
            this.switchCount++;
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.motorState = MotorState.OFF;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "motorState", MotorState.ON, MotorState.OFF));
            this.switchCount++;
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

    @Override
    public long getSwitchCount() {
        return this.switchCount;
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
        } else {
            throw new NullPointerException();
        }
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListeners.remove(listener);
        } else {
            throw new NullPointerException();
        }
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent event) {
        for (PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(event);
        }
    }
}
