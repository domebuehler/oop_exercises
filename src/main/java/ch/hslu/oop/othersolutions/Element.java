package ch.hslu.oop.othersolutions;

import java.util.ArrayList;

/**
 * Die Klasse Element repraesentiert ein chemisches Element.
 * Sie stellt Methoden zur Verfuegung um den Aggregatzustand zu ermitteln.
 *
 * @author (Dominik Buehler)
 * @version (06.10.2021)
 */
public class Element {
    private String elementName;
    private float evaporatePoint;
    private float meltPoint;

    private static ArrayList<Element> elementList = new ArrayList<Element>();

    /**
     * Nimmt alle wichtigen Parameter entgegen und initialisiert das Objekt.
     *
     * @param elementName    der Name des Elements
     * @param evaporatePoint Siedepunkt des Elements in Grad Celsius
     * @param meltPoint      Schmelzpunkt des Elements in Grad Celsius
     */
    public Element(String elementName, float evaporatePoint, float meltPoint) {
        this.elementName = elementName;
        this.evaporatePoint = evaporatePoint;
        this.meltPoint = meltPoint;
    }

    /**
     * Initialisiert ein "Default"-Element.
     */
    public Element() {
        this.elementName = "NA";
        this.evaporatePoint = 0f;
        this.meltPoint = 0f;
    }

    /**
     * Ermittelt den Agregatszustand anhand der Temperatur.
     *
     * @param elementName Element, von welchem der Zustand ermittelt wird.
     * @param actualTemp  die aktuelle Temperatur
     * @return gibt den Zustand in Form eines String zurueck (fest, fluessig, gasfoermig)
     */
    public static String getState(String elementName, float actualTemp) {
        String state = "";
        Element element = new Element();
        element = Element.findElement(elementName);
        if (actualTemp < element.meltPoint) {
            state = "fest";
        } else if (actualTemp > element.meltPoint && actualTemp < element.evaporatePoint) {
            state = "flüssig";
        } else if (actualTemp > element.evaporatePoint) {
            state = "gasförmig";
        } else {
            state = "fail";
        }
        return state;
    }

    /**
     * Sucht ein Element innerhalb der ArrayList.
     *
     * @param elementName zu findendes Element
     * @return gibt die Position des Elements in der ArrayList zurueck.
     */
    private static Element findElement(String elementName) {
        int elementPosition = 0;
        for (Element element : Element.elementList) {
            if (element.elementName.equals(elementName)) {
                elementPosition = Element.elementList.indexOf(element);
            }
        }
        return Element.elementList.get(elementPosition);
    }

    /**
     * Initialisiert einige Elemente.
     */
    public static void initSomeElements() {
        Element stickstoff = new Element("N", -196.0f, -210.1f);
        Element blei = new Element("Pb", 1744.0f, 327.4f);
        Element quecksilber = new Element("Hg", 357.0f, -38.8f);

        elementList.add(stickstoff);
        elementList.add(blei);
        elementList.add(quecksilber);
    }
}
