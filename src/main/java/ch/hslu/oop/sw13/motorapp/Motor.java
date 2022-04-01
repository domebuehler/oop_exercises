package ch.hslu.oop.sw13.motorapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public final class Motor implements Switchable {

    private static final Logger LOG = LogManager.getLogger(Motor.class);

    private final static int FAILURE_COUNT = 3;
    private final static int MAX_RPM = 5000;
    private final static int MIN_RPM = 1000;

    private MotorState motorState;
    private int rpm;
    private int failureCounter;
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();
    private final List<ReachedMaxRpmEventListener> rpmEventListeners = new ArrayList<>();

    public Motor() {
        this.motorState = MotorState.OFF;
        this.failureCounter = 0;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff() && this.failureCounter < FAILURE_COUNT) {
            this.motorState = MotorState.ON;
            increaseRpm();
            this.failureCounter++;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "motorState", MotorState.OFF, MotorState.ON));
        } else if (this.isSwitchedOff() && this.failureCounter == FAILURE_COUNT) {
            this.motorState = MotorState.FAILURE;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "motorState", MotorState.OFF, MotorState.FAILURE));
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.motorState = MotorState.OFF;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "motorState", MotorState.ON, MotorState.OFF));
            final int oldRpm = this.rpm;
            this.rpm = 0;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "rpm", oldRpm, this.rpm));
        } else if (this.hasError()) {
            this.motorState = MotorState.OFF;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "motorState", MotorState.FAILURE, MotorState.OFF));
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

    public void resetMotor() {
        this.failureCounter = 0;
        this.switchOff();
    }

    public void increaseRpm() {
        if (this.rpm < MAX_RPM && isSwitchedOn()) {
            final int oldRpm = this.rpm;
            this.rpm += 1000;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "rpm", oldRpm, this.rpm));
        } else {
            fireReachedMaxRpmEvent(new ReachedMaxRpmEvent(this));
        }
    }

    public void decreaseRpm() {
        if (this.rpm > MIN_RPM && isSwitchedOn()) {
            final int oldRpm = this.rpm;
            this.rpm -= 1000;
            firePropertyChangeEvent(new PropertyChangeEvent
                    (this, "rpm", oldRpm, this.rpm));
        } else {
            switchOff();
        }
    }

    public MotorState getMotorState() {
        return this.motorState;
    }

    public void addPropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            this.changeListeners.add(propertyChangeListener);
        } else {
            throw new NullPointerException();
        }
    }

    public void removePropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        if (propertyChangeListener != null) {
            this.changeListeners.remove(propertyChangeListener);
        } else {
            throw new NullPointerException();
        }
    }

    public void firePropertyChangeEvent(final PropertyChangeEvent propertyChangeEvent) {
        if (this.changeListeners.size() > 0) {
            for (PropertyChangeListener listener : this.changeListeners) {
                listener.propertyChange(propertyChangeEvent);
            }
        }
    }

    public void addReachedMaxRmpEventListener(final ReachedMaxRpmEventListener reachedMaxRpmEventListener) {
        if (reachedMaxRpmEventListener != null) {
            this.rpmEventListeners.add(reachedMaxRpmEventListener);
        } else {
            throw new NullPointerException();
        }
    }

    public void removeReachedMaxRmpEventListener(final ReachedMaxRpmEventListener reachedMaxRpmEventListener) {
        if (reachedMaxRpmEventListener != null) {
            this.rpmEventListeners.remove(reachedMaxRpmEventListener);
        } else {
            throw new NullPointerException();
        }
    }

    public void fireReachedMaxRpmEvent(final ReachedMaxRpmEvent reachedMaxRpmEvent) {
        if (this.rpmEventListeners.size() > 0) {
            for (ReachedMaxRpmEventListener reachedMaxRpmEventListener : rpmEventListeners) {
                reachedMaxRpmEventListener.handleRpmEvent(reachedMaxRpmEvent);
            }
        }
    }

    private boolean hasError() {
        return this.motorState == MotorState.FAILURE;
    }
}