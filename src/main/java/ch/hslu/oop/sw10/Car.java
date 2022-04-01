package ch.hslu.oop.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public final class Car implements Switchable, PropertyChangeListener {

    private static final Logger LOG = LogManager.getLogger(Car.class);


    private Motor motor;
    private Lamp lamp;
    private CarState running;
    private String model;

    public Car(String model) {
        this.motor = new Motor();
        this.lamp = new Lamp();
        this.running = CarState.OFF;
        this.model = model;
        this.motor.addPropertyChangeListener(this);
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.running = CarState.ON;
            this.lamp.switchOn();
            this.motor.switchOn();
        }
    }

    @Override
    public void switchOff() {
        this.running = CarState.OFF;
        this.motor.switchOff();
        this.lamp.switchOff();
    }

    @Override
    public boolean isSwitchedOn() {
        return this.running == CarState.ON;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.running == CarState.OFF;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() == MotorState.ON) {
            LOG.info("motor was switched on");
        } else {
            LOG.info("motor was switched off");
        }
    }
}
