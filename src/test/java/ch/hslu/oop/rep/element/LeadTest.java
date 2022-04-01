package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeadTest {

    @Test
    public void testGetStateGas() {
        Lead lead = new Lead();
        Temperature high = new Temperature(2000f);
        StateOfAggregation state = lead.getStateOfAggregation(high);
        lead.printStateOfAggregationMessage(high);
        assertThat(state).isEqualTo(StateOfAggregation.GASEOUS);
    }

    @Test
    public void testGetStateFluid() {
        Lead lead = new Lead();
        Temperature medium = new Temperature(350f);
        StateOfAggregation state = lead.getStateOfAggregation(medium);
        assertThat(state).isEqualTo(StateOfAggregation.FLUID);
    }

    @Test
    public void testGetStateSolid() {
        Lead lead = new Lead();
        Temperature low = new Temperature(-0f);
        StateOfAggregation state = lead.getStateOfAggregation(low);
        assertThat(state).isEqualTo(StateOfAggregation.SOLID);
    }
}