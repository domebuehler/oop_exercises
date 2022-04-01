package ch.hslu.oop.sw06.polymorphie;


public class Motor implements Switchable {

    private static final int MAX_RPM = 5000;
    private static final int MIN_RPM = 0;
    private int rpm;
    private long switchCount;
    private String nameOfTheMotor;

    @Override
    public void switchOn() {

        this.setRpm(2500);
        this.switchCount++;
    }

    @Override
    public void switchOff() {
        this.setRpm(0);
    }

    @Override
    public boolean isSwitchedOn() {
        return this.getRpm() > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.getRpm() == 0;
    }

    public int getRpm() {
        return rpm;
    }

    public void setRpm(int rpm) {
        if (rpm <= Motor.MAX_RPM && rpm >= Motor.MIN_RPM) {
            this.rpm = rpm;
        } else {
            System.out.println("Ungültige Eingabe");
        }
    }
}
