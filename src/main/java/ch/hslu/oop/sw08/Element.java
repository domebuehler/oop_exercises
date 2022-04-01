package ch.hslu.oop.sw08;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;


public abstract class Element implements Comparable<Element> {

    private static final Logger LOG = LogManager.getLogger(Element.class);

    private final String name;
    private final float evaporatePoint;
    private final float meltPoint;

    private static Map<StateTemperatures, Float> map;
    private final static float BLEI_EVAPORATIONPOINT = 1744f;
    private final static float BLEI_MELTINGPOINT = 327.4f;
    private final static float QUECKSILBER_EVAPORATIONPOINT = 357f;
    private final static float QUECKSILBER_MELTINGPOINT = -38.8f;
    private final static float STICKSTOFF_EVAPORATIONPOINT = -196f;
    private final static float STICKSTOFF_MELTINGPOINT = -210f;

    public Element(String name, float evaporatePoint, float meltPoint) {
        this.evaporatePoint = evaporatePoint;
        this.meltPoint = meltPoint;
        this.name = name;
        LOG.info("created object");
    }

    public StateOfAggregation getStateDependingOnTemp(Temperatur temperatur) {
        if (temperatur.getTempCelsius() > this.evaporatePoint) {
            return StateOfAggregation.GAS;
        } else if (temperatur.getTempCelsius() < this.meltPoint) {
            return StateOfAggregation.SOLID;
        } else {
            return StateOfAggregation.LIQUID;
        }
    }

    public String getStateDependingOnTempString(Temperatur temperatur) {
        StateOfAggregation state = getStateDependingOnTemp(temperatur);
        return this.getClass().getSimpleName() + " ist bei " +
                temperatur.getTempCelsius() + "°C " + state.getStringRepresentation() + ".";
    }

    private final static void initMap() {
        if (map == null) {
            map = new EnumMap<>(StateTemperatures.class);
            map.put(StateTemperatures.BLEI_EVAPOINT, BLEI_EVAPORATIONPOINT);
            map.put(StateTemperatures.BLEI_MELTINGPOINT, BLEI_MELTINGPOINT);
            map.put(StateTemperatures.STICKSTOFF_EVAPOINT, STICKSTOFF_EVAPORATIONPOINT);
            map.put(StateTemperatures.STICKSTOFF_MELTINGPOINT, STICKSTOFF_MELTINGPOINT);
            map.put(StateTemperatures.QUECKSILBER_EVAPOINT, QUECKSILBER_EVAPORATIONPOINT);
            map.put(StateTemperatures.QUECKSILBER_MELTINGPOINT, QUECKSILBER_MELTINGPOINT);
        } else {
            System.out.println("map already initialized");
        }
    }

    public StateOfAggregation getStateUsingEnumMap(Temperatur temperatur) {
        initMap();
        StateOfAggregation state = StateOfAggregation.LIQUID;
        if (temperatur.getTempCelsius() > map.get(getStateTemperatureEvaporationPoint(this))) {
            state = StateOfAggregation.GAS;
        } else if (temperatur.getTempCelsius() < map.get(getStateTemperatureMeltingPoint(this))) {
            state = StateOfAggregation.SOLID;
        }
        return state;
    }

    private StateTemperatures getStateTemperatureEvaporationPoint(Element element) {
        if (element.equals(new Blei())) {
            return StateTemperatures.BLEI_EVAPOINT;
        } else if (element.equals(new Stickstoff())) {
            return StateTemperatures.STICKSTOFF_EVAPOINT;
        } else {
            return StateTemperatures.QUECKSILBER_EVAPOINT;
        }
    }

    private StateTemperatures getStateTemperatureMeltingPoint(Element element) {
        if (element.equals(new Blei())) {
            return StateTemperatures.BLEI_MELTINGPOINT;
        } else if (element.equals(new Stickstoff())) {
            return StateTemperatures.STICKSTOFF_MELTINGPOINT;
        } else {
            return StateTemperatures.QUECKSILBER_MELTINGPOINT;
        }
    }

    @Override
    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Element)) {
            return false;
        }
        return Objects.equals(this.getClass(), other.getClass());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.getClass());
    }

    @Override
    public int compareTo(Element other) {
        if (this == other) {
            return 0;
        }
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "[Element: " + this.name + ",\tSchmelzpunkt: " + this.meltPoint +
                "°C,\tSiedepunkt: " + this.evaporatePoint + "°C]";
    }

    public float getEvaporatePoint() {
        return evaporatePoint;
    }

    public float getMeltPoint() {
        return meltPoint;
    }
}