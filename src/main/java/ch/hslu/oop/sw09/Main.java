package ch.hslu.oop.sw09;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            //Input auf exit vor dem Exception-Handling prüfen!
            //weil Exception-Handling nür für Sonderfälle benutzt werden soll
            if (!input.equalsIgnoreCase("exit")) {
                try {
                    float value = Float.valueOf(input);
                    System.out.println("Eingabe: " + value + "°C");
                } catch (NumberFormatException numberFormatException) {
                    //Ausgabe mit Platzhalter {}
                    LOG.error("ungültige Eingabe", numberFormatException);
                }
            }
        } while (!input.equals("exit"));
        LOG.info("Programm beendet.");
    }

    //Beim Verwenden dieser Methode ist es Null-Safe
    static boolean programmShouldExit(String input) {
        return "exit".equalsIgnoreCase(input);
    }
}
