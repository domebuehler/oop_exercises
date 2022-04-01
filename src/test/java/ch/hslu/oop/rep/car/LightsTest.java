package ch.hslu.oop.rep.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LightsTest {

    @Test
    void testSwitchOn() {
        Lights lights = new Lights("Philipps");
        lights.switchOn();
        assertThat(lights.isSwitchedOn()).isTrue();
    }

    @Test
    void testSwitchOff() {
        Lights lights = new Lights("Philipps");
        lights.switchOn();
        lights.switchOff();
        assertThat(lights.isSwitchedOff()).isTrue();
    }

    @Test
    void testGetSwitchCount() {
        Lights lights = new Lights("Philipps");
        for (int i = 0; i < 35; i++) {
            lights.switchOn();
            lights.switchOff();
        }

        long count = lights.getSwitchCount();
        assertThat(count).isEqualTo(70);
    }

    @Test
    void testGetAndSetName() {
        Lights lights = new Lights("Philipps");
        lights.setName("otherName");
        String name = lights.getName();
        assertThat(name).isEqualTo("otherName");
    }
}