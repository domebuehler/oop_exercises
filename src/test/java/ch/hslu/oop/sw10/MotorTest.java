package ch.hslu.oop.sw10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MotorTest {

    @Test
    void testSwitchOn() {
        Motor motor = new Motor();
        motor.switchOn();
        assertThat(motor.isSwitchedOn()).isTrue();
    }

    @Test
    void testSwitchOff() {
        Motor motor = new Motor();
        motor.switchOff();
        assertThat(motor.isSwitchedOff()).isTrue();
    }

    @Test
    void testIsSwitchedOnFalse() {
        Motor motor = new Motor();
        motor.switchOff();
        assertThat(motor.isSwitchedOn()).isFalse();
    }

    @Test
    void testIsSwitchedOffFalse() {
        Motor motor = new Motor();
        motor.switchOn();
        assertThat(motor.isSwitchedOff()).isFalse();
    }

    @Test
    void getMotorState() {
        Motor motor = new Motor();
        motor.switchOn();
        assertThat(motor.getMotorState()).isEqualTo(MotorState.ON);
    }
}