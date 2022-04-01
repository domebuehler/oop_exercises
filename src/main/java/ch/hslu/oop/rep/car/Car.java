package ch.hslu.oop.rep.car;

import ch.hslu.oop.rep.interfaces.CountingSwitchable;
import ch.hslu.oop.sw05.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements CountingSwitchable, Named, PropertyChangeListener {

    private static final Logger LOG = LogManager.getLogger(Car.class);

    private CarState carState;
    private long switchCount;
    private String name;
    private Motor motor;
    private Lights lights;

    public Car(String name) {
        this.name = name;
        this.carState = CarState.OFF;
        this.switchCount = 0;
        this.motor = new Motor();
        motor.switchOff();
        this.lights = new Lights("Philips");
        motor.switchOff();
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.carState = CarState.ON;
            motor.switchOn();
            lights.switchOn();
            this.switchCount++;
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.carState = CarState.OFF;
            motor.switchOff();
            lights.switchOff();
            this.switchCount++;
        }

    }

    @Override
    public boolean isSwitchedOn() {
        return this.carState == CarState.ON && this.lights.isSwitchedOn() && this.motor.isSwitchedOn();
    }

    @Override
    public boolean isSwitchedOff() {
        return this.carState == CarState.OFF && this.lights.isSwitchedOff() && this.motor.isSwitchedOff();
    }

    @Override
    public long getSwitchCount() {
        return this.switchCount;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LOG.info("Motor was switched {}!", evt.getNewValue());
    }

    public Motor getMotor() {
        return motor;
    }
}