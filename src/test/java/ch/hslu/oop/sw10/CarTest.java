package ch.hslu.oop.sw10;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void testSwitchOn() {
        Car car = new Car("VW5");
        car.switchOn();
        assertThat(car.isSwitchedOn()).isTrue();
    }

    @Test
    void switchOff() {
        Car car = new Car("Audi");
        car.switchOff();
        assertThat(car.isSwitchedOff()).isTrue();
    }

    @Test
    void testIsSwitchedOnFalse() {
        Car car = new Car("BMW");
        car.switchOff();
        assertThat(car.isSwitchedOn()).isFalse();
    }

    @Test
    void testIsSwitchedOffFalse() {
        Car car = new Car("Peugot");
        car.switchOn();
        assertThat(car.isSwitchedOff()).isFalse();
    }

    @Test
    void testPropertyChangeManual() {
        Car car = new Car("Subaru");
        car.propertyChange(new PropertyChangeEvent
                (new Motor(), "motorState", MotorState.ON, MotorState.OFF));
    }

    @Test
    void testPropertyChangeMotorSwitchOn() {
        Car car = new Car("VW");
        car.switchOn();
        assertThat(car.isSwitchedOn()).isTrue();
    }

    @Test
    void testPropertyChangeMotorSwitchOff() {
        Car car = new Car("VW");
        car.switchOn();
        car.switchOff();
        assertThat(car.isSwitchedOff()).isTrue();
    }
}