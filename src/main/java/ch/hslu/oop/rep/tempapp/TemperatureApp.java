package ch.hslu.oop.rep.tempapp;

import ch.hslu.oop.rep.exceptions.EmptyTemperatureCourseException;
import ch.hslu.oop.rep.temp.ImmutableTemperature;
import ch.hslu.oop.rep.temp.TemperatureCourse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class TemperatureApp implements TemperatureMaximaEventListener, TemperatureMinimaEventListener {
    private static final Logger LOG = LogManager.getLogger(TemperatureApp.class);

    private static final TemperatureCourse temperatureCourse = new TemperatureCourse();

    public TemperatureApp() {
        temperatureCourse.addTemperatureMaximaEventListener(this);
        temperatureCourse.addTemperatureMinimaEventListener(this);
    }

    public static void main(String[] args) {
        TemperatureApp app = new TemperatureApp();
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            try {
                ImmutableTemperature temperature = ImmutableTemperature.createFromCelsius(Float.valueOf(input));
                temperatureCourse.add(temperature);
                LOG.info("{} has been added", temperature);
            } catch (NumberFormatException e) {
                if (!input.equalsIgnoreCase("exit")) {
                    LOG.error("{} throws {}", input, e);
                }
            } catch (IllegalArgumentException e) {
                LOG.error("{} throws {}", input, e);
            }
        } while (!checkForExit(input));
        LOG.info("exit");
        printStats();
    }

    private static void printStats() {
        try {
            System.out.println("---Stats---" +
                    "\nMaxima: " + temperatureCourse.getMaxima() +
                    "\nMinima: " + temperatureCourse.getMinima() +
                    "\nAverage: " + temperatureCourse.getAverage());
        } catch (EmptyTemperatureCourseException e) {
            LOG.error("stats not available", e);
        }
    }

    private static boolean checkForExit(String input) {
        return "exit".equalsIgnoreCase(input);
    }

    @Override
    public void handleTemperatureMaximaEvent(TemperatureMaximaEvent event) {
        LOG.info("new maxima");
    }

    @Override
    public void handleTemperatureMinimaEvent(TemperatureMinimaEvent event) {
        LOG.info("new minima");
    }
}
