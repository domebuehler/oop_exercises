package ch.hslu.oop.sw10;

import java.util.Scanner;

public final class TemperaturApp {

    public static void main(String[] args) {
        TemperaturAppControlUnit controlUnit = new TemperaturAppControlUnit();
        String input = "AppStart";
        Scanner scanner = new Scanner(System.in);

        while (!controlUnit.checkForExit(input)) {
            System.out.println("Temperatur in Celsius eingeben (exit zum abbrechen):");
            input = scanner.next();
            if (!controlUnit.checkForExit(input)) {
                controlUnit.handleNewInput(input);
            }
        }
        System.out.println(controlUnit.getStatsInString());
        System.out.println("---Programm beendet---");
    }
}
