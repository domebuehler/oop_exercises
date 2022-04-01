package ch.hslu.oop.rep.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void testSwitchOn() {
        Car car = new Car("VW");
        car.switchOn();
        assertThat(car.isSwitchedOn()).isTrue();
    }

    @Test
    void testSwitchOff() {
        Car car = new Car("BMW");
        car.switchOn();
        car.switchOff();
        assertThat(car.isSwitchedOff()).isTrue();
    }

    @Test
    void testGetSwitchCount() {
        Car car = new Car("Toyota");
        for (int i = 0; i < 20; i++) {
            car.switchOn();
            car.switchOff();
        }

        long count = car.getSwitchCount();
        assertThat(count).isEqualTo(40);
    }

    @Test
    void testGetAndSetName() {
        Car car = new Car("Audi");
        car.setName("Mercedes");
        String name = car.getName();
        assertThat(name).isEqualTo("Mercedes");
    }
}