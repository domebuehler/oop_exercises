package ch.hslu.oop.rep.element;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ElementEnumTest {

    @Test
    public void testToString() {
        assertThat(ElementEnum.LEAD.toString()).isEqualTo("LEAD");
    }

    @Test
    public void testValueOf() {
        assertThat(ElementEnum.valueOf("LEAD")).isEqualTo(ElementEnum.LEAD);
    }

}