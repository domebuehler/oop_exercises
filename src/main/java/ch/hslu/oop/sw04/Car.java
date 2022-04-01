package ch.hslu.oop.sw04;

public class Car implements Switchable {

    private Motor motor;
    private Lamp lamp;
    private boolean ignition;

    public Car() {
        this.motor = new Motor();
        this.lamp = new Lamp();
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.setIgnition(true);
            this.lamp.switchOn();
            this.motor.switchOn();
        }
    }

    @Override
    public void switchOff() {
        this.setIgnition(false);
        this.motor.switchOff();
        this.lamp.switchOff();
    }

    @Override
    public boolean isSwitchedOn() {
        return this.ignition;
    }

    @Override
    public boolean isSwitchedOff() {
        return !this.ignition;
    }

    public void setIgnition(boolean stateOfIgnition) {
        this.ignition = stateOfIgnition;
    }
}
