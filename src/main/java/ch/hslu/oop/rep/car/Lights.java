package ch.hslu.oop.rep.car;

import ch.hslu.oop.rep.interfaces.NamedCountingSwitchable;

public class Lights implements NamedCountingSwitchable {

    private LightsState lightsState;
    private long switchCount;
    private String name;

    public Lights(String name) {
        this.lightsState = LightsState.OFF;
        this.switchCount = 0;
    }

    @Override
    public void switchOn() {
        if (this.isSwitchedOff()) {
            this.lightsState = LightsState.ON;
            this.switchCount++;
        }
    }

    @Override
    public void switchOff() {
        if (this.isSwitchedOn()) {
            this.lightsState = LightsState.OFF;
            this.switchCount++;
        }
    }

    @Override
    public boolean isSwitchedOn() {
        return this.lightsState == LightsState.ON;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.lightsState == LightsState.OFF;
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
}
