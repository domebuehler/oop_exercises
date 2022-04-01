package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MercuryTest {

    @Test
    public void testGetStateGas() {
        Mercury mercury = new Mercury();
        Temperature high = new Temperature(400f);
        StateOfAggregation state = mercury.getStateOfAggregation(high);
        assertThat(state).isEqualTo(StateOfAggregation.GASEOUS);
    }

    @Test
    public void testGetStateFluid() {
        Mercury mercury = new Mercury();
        Temperature medium = new Temperature(0);
        StateOfAggregation state = mercury.getStateOfAggregation(medium);
        assertThat(state).isEqualTo(StateOfAggregation.FLUID);
    }

    @Test
    public void testGetStateSolid() {
        Mercury mercury = new Mercury();
        Temperature low = new Temperature(-100f);
        StateOfAggregation state = mercury.getStateOfAggregation(low);
        assertThat(state).isEqualTo(StateOfAggregation.SOLID);
    }

    @Test
    public void testToString() {
        Mercury mercury = new Mercury();
        String toString = mercury.toString();
        assertThat(toString).isEqualTo("Giftig! Element[evaporationPoint=Temperature[temperatureInCelsius=357.0]," +
                " meltingPoint=Temperature[temperatureInCelsius=-38.8]]");
    }
}