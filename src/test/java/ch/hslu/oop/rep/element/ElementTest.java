package ch.hslu.oop.rep.element;

import ch.hslu.oop.rep.temp.Temperature;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ElementTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.forClass(Element.class).
                usingGetClass().
                withIgnoredFields("evaporationPoint", "meltingPoint")
                .verify();
    }

    @Test
    public void testEqualsFalse() {
        Lead lead = new Lead();
        Mercury mercury = new Mercury();
        assertThat(lead.equals(mercury)).isFalse();
    }

    @Test
    public void testEqualsTrue() {
        Lead lead = new Lead();
        Lead otherLead = new Lead();
        assertThat(lead.equals(otherLead)).isTrue();
    }

    @Test
    public void testPrintMsg() {
        Element element = new Nitrogen();
        Temperature temperature = new Temperature(-250);
        Element.printStateOfAggregationMessageFromElement(element, temperature);
    }
}