package ch.hslu.oop.sw05;

public class Lamp implements CountingSwitchable, Named {

    private static final int MAX_LUMEN = 1000;
    private static final int MIN_LUMEN = 0;
    private int lumen;
    private long switchCounter;
    private String nameOfTheLamp;

    public Lamp(String nameOfTheLamp) {
        this.nameOfTheLamp = nameOfTheLamp;
    }

    @Override
    public void switchOn() {

        this.setLumen(500);
        this.switchCounter++;
    }

    @Override
    public void switchOff() {
        this.setLumen(0);
    }

    @Override
    public boolean isSwitchedOn() {
        return this.getLumen() > 0;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.getLumen() == 0;
    }

    public int getLumen() {
        return lumen;
    }

    public void setLumen(int lumen) {
        if (lumen <= Lamp.MAX_LUMEN && lumen >= Lamp.MIN_LUMEN) {
            this.lumen = lumen;
        } else {
            System.out.println("Ungültige Eingabe");
        }
    }

    @Override
    public long getSwitchCount() {
        return this.switchCounter;
    }

    @Override
    public void setName(String name) {
        this.nameOfTheLamp = name;
    }

    @Override
    public String getName() {
        return this.nameOfTheLamp;
    }
}
