package ch.hslu.oop.sw12;

import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
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
        controlUnit.write();
        System.out.println(controlUnit.getStatsInString());
        System.out.println("---Programm beendet---");
        controlUnit.read();
    }
}
