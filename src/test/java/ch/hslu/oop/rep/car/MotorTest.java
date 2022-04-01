package ch.hslu.oop.rep.car;

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
        motor.switchOn();
        motor.switchOff();
        assertThat(motor.isSwitchedOff()).isTrue();
    }

    @Test
    void testGetSwitchCount() {
        Motor motor = new Motor();
        for (int i = 0; i < 10; i++) {
            motor.switchOn();
            motor.switchOff();
        }

        long count = motor.getSwitchCount();
        assertThat(count).isEqualTo(20);
    }
}