package ch.hslu.oop.sw10;


public final class Lamp implements Switchable {

    private static final int MAX_LUMEN = 1000;
    private static final int MIN_LUMEN = 0;
    private int lumen;

    @Override
    public void switchOn() {
        this.setLumen(500);
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
}
