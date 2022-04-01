package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NitrogenTest {

    @Test
    public void testGetStateGas() {
        Nitrogen nitrogen = new Nitrogen();
        Temperature high = new Temperature(100f);
        StateOfAggregation state = nitrogen.getStateOfAggregation(high);
        assertThat(state).isEqualTo(StateOfAggregation.GASEOUS);
    }

    @Test
    public void testGetStateFluid() {
        Nitrogen nitrogen = new Nitrogen();
        Temperature medium = new Temperature(-200f);
        StateOfAggregation state = nitrogen.getStateOfAggregation(medium);
        assertThat(state).isEqualTo(StateOfAggregation.FLUID);
    }

    @Test
    public void testGetStateSolid() {
        Nitrogen nitrogen = new Nitrogen();
        Temperature low = new Temperature(-250f);
        StateOfAggregation state = nitrogen.getStateOfAggregation(low);
        assertThat(state).isEqualTo(StateOfAggregation.SOLID);
    }

}