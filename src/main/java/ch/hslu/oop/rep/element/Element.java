package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;

import java.util.Objects;

public abstract class Element {

    private final Temperature evaporationPoint;
    private final Temperature meltingPoint;

    protected Element(Temperature evaporationPoint, Temperature meltingPoint) {
        this.meltingPoint = meltingPoint;
        this.evaporationPoint = evaporationPoint;
    }

    public static final StateOfAggregation getStateFromElement(Element element, Temperature temperature) {
        if (temperature.compareTo(element.evaporationPoint) > 0) {
            return StateOfAggregation.GASEOUS;
        } else if (temperature.compareTo(element.meltingPoint) > 0) {
            return StateOfAggregation.FLUID;
        } else {
            return StateOfAggregation.SOLID;
        }
    }

    public static final void printStateOfAggregationMessageFromElement(Element element, Temperature temperature) {
        String message = element.getClass().getSimpleName() +
                " ist bei " + temperature.getTemperatureInCelsius() + " °C " +
                getStateFromElement(element, temperature).getDescription();
        System.out.println(message);
    }


    public final StateOfAggregation getStateOfAggregation(Temperature temperature) {
        if (temperature.compareTo(this.evaporationPoint) > 0) {
            return StateOfAggregation.GASEOUS;
        } else if (temperature.compareTo(this.meltingPoint) > 0) {
            return StateOfAggregation.FLUID;
        } else {
            return StateOfAggregation.SOLID;
        }
    }

    public final void printStateOfAggregationMessage(Temperature temperature) {
        String message = this.getClass().getSimpleName() +
                " ist bei " + temperature.getTemperatureInCelsius() + " °C " +
                getStateOfAggregation(temperature).getDescription();
        System.out.println(message);
    }

    @Override
    public final boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Element)) {
            return false;
        }
        Element other = (Element) o;
        return Objects.equals(other.getClass(), this.getClass());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(this.getClass());
    }

    @Override
    public String toString() {
        return "Element[" +
                "evaporationPoint=" + evaporationPoint +
                ", meltingPoint=" + meltingPoint +
                ']';
    }

    public Temperature getEvaporationPoint() {
        return evaporationPoint;
    }

    public Temperature getMeltingPoint() {
        return meltingPoint;
    }
}
