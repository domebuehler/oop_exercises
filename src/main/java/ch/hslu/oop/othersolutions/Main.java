package ch.hslu.oop.othersolutions;

public class Main {

    public static void main(String[] args) {

        Temperatur temp = new Temperatur(400.0f);

        System.out.println("Stickstoff:\t" + temp.getStateDependingOnTempEnum("N"));
        System.out.println("Blei:\t" + temp.getStateDependingOnTempEnum("Pb"));
        System.out.println("Quecksilber:\t" + temp.getStateDependingOnTempEnum("Hg"));

    }
}
