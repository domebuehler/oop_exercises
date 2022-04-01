package ch.hslu.oop.sw05;

public class Car implements CountingSwitchable, Named {

    protected Motor motor;
    protected Lamp lamp;
    private boolean ignition;
    private long switchCount;
    private String nameOfTheCar;

    public Car(String nameOfTheCar) {
        this.nameOfTheCar = nameOfTheCar;
        this.motor = new Motor("Motor von " + nameOfTheCar);
        this.lamp = new Lamp("Lampe von " + nameOfTheCar);
    }

    public String toString() {
        return "Auto: " + this.nameOfTheCar + "\nLampe: " + this.lamp.getName() +
                "\nMotor: " + this.motor.getName();
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.setIgnition(true);
            this.lamp.switchOn();
            this.motor.switchOn();
            this.switchCount++;
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

    @Override
    public long getSwitchCount() {
        return this.switchCount;
    }

    @Override
    public void setName(String name) {
        this.nameOfTheCar = name;
    }

    @Override
    public String getName() {
        return this.nameOfTheCar;
    }
}
