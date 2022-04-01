package ch.hslu.oop.rep.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class FloatReader {

    private static final Logger LOG = LogManager.getLogger(FloatReader.class);

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            float value = 0;
            try {
                 value = Float.valueOf(input);
                 System.out.println("entered value: " + value);
            } catch (NumberFormatException e) {
                if (!input.equalsIgnoreCase("exit")) {
                    LOG.error("{} throws {}", input, e);
                }
            }
        } while (!input.equals("exit"));
        LOG.info("exit");
    }
}
