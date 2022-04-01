package ch.hslu.oop.sw08;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ElementTest {

    @Test
    public void testEqualsContract() {
        EqualsVerifier.
                forClass(Element.class).
                usingGetClass().
                withIgnoredFields("name", "evaporatePoint", "meltPoint").
                verify();
    }

    @Test
    public void testEqualsValueEquality() {
        Quecksilber quecksilber = new Quecksilber();
        Quecksilber quecksilber1 = new Quecksilber();
        assertThat(quecksilber.equals(quecksilber1)).isTrue();
    }

    @Test
    public void testEqualsFalse() {
        Blei blei = new Blei();
        Stickstoff stickstoff = new Stickstoff();
        assertThat(blei.equals(stickstoff)).isFalse();
    }

    @Test
    public void testEqualsIfNull() {
        Blei blei = new Blei();
        Blei blei2 = null;
        assertThat(blei.equals(blei2)).isFalse();
    }

    @Test
    public void testEqualsIfOtherClass() {
        Blei blei = new Blei();
        Object obj = new Object();
        assertThat(blei.equals(obj)).isFalse();
    }

    @Test
    public void testCompareToIfEqual() {
        Quecksilber quecksilber = new Quecksilber();
        Quecksilber quecksilber1 = new Quecksilber();
        assertThat(quecksilber.compareTo(quecksilber1)).isEqualTo(0);
    }

    @Test
    public void testCompareToSmaller() {
        Quecksilber quecksilber = new Quecksilber();
        Stickstoff stickstoff = new Stickstoff();
        assertThat(quecksilber.compareTo(stickstoff)).isNegative();
    }

    @Test
    public void testCompareToBigger() {
        Quecksilber quecksilber = new Quecksilber();
        Stickstoff stickstoff = new Stickstoff();
        assertThat(stickstoff.compareTo(quecksilber)).isPositive();
    }

    @Test
    public void testGetStateBleiSolid() {
        Temperatur temperatur = new Temperatur(20.0f);
        Blei blei = new Blei();

        System.out.println(blei.getStateDependingOnTempString(temperatur));
        assertThat(blei.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.SOLID);
    }

    @Test
    public void testGetStateBleiLiquid() {
        Temperatur temperatur = new Temperatur(330.0f);
        Blei blei = new Blei();

        System.out.println(blei.getStateDependingOnTempString(temperatur));
        assertThat(blei.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.LIQUID);
    }

    @Test
    public void testGetStateBleiGas() {
        Temperatur temperatur = new Temperatur(1800f);
        Blei blei = new Blei();

        System.out.println(blei.getStateDependingOnTempString(temperatur));
        assertThat(blei.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.GAS);
    }

    @Test
    public void testGetStateStickstoffGas() {
        Temperatur temperatur = new Temperatur(20f);
        Stickstoff stickstoff = new Stickstoff();

        System.out.println(stickstoff.getStateDependingOnTempString(temperatur));
        assertThat(stickstoff.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.GAS);
    }

    @Test
    public void testGetStateStickstoffLiquid() {
        Temperatur temperatur = new Temperatur(-200f);
        Stickstoff stickstoff = new Stickstoff();

        System.out.println(stickstoff.getStateDependingOnTempString(temperatur));
        assertThat(stickstoff.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.LIQUID);
    }

    @Test
    public void testGetStateStickstoffSolid() {
        Temperatur temperatur = new Temperatur(-220f);
        Stickstoff stickstoff = new Stickstoff();

        System.out.println(stickstoff.getStateDependingOnTempString(temperatur));
        assertThat(stickstoff.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.SOLID);
    }

    @Test
    public void testGetStateQuecksilberGas() {
        Temperatur temperatur = new Temperatur(360f);
        Quecksilber quecksilber = new Quecksilber();

        System.out.println(quecksilber.getStateDependingOnTempString(temperatur));
        assertThat(quecksilber.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.GAS);
    }

    @Test
    public void testGetStateQuecksilberLiquid() {
        Temperatur temperatur = new Temperatur(-30f);
        Quecksilber quecksilber = new Quecksilber();

        System.out.println(quecksilber.getStateDependingOnTempString(temperatur));
        assertThat(quecksilber.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.LIQUID);
    }

    @Test
    public void testGetStateQuecksilberSolid() {
        Temperatur temperatur = new Temperatur(-50f);
        Quecksilber quecksilber = new Quecksilber();

        System.out.println(quecksilber.getStateDependingOnTempString(temperatur));
        assertThat(quecksilber.getStateDependingOnTemp(temperatur)).isEqualTo(StateOfAggregation.SOLID);
    }

    @Test
    public void testCompareTo() {
        Quecksilber quecksilber1 = new Quecksilber();
        Quecksilber quecksilber2 = new Quecksilber();
        Blei blei1 = new Blei();
        Blei blei2 = new Blei();
        Stickstoff stickstoff1 = new Stickstoff();
        Stickstoff stickstoff2 = new Stickstoff();

        ArrayList<Element> list = new ArrayList<>();
        list.add(quecksilber1);
        list.add(blei1);
        list.add(stickstoff1);
        list.add(quecksilber2);
        list.add(stickstoff2);
        list.add(blei2);

        System.out.println("before Sorting");
        for (Element element : list) {
            System.out.println(element.getClass().getSimpleName());
        }

        Collections.sort(list);

        System.out.println("after Sorting");
        for (Element element : list) {
            System.out.println(element.getClass().getSimpleName());
        }

        assertThat(list.get(5)).isEqualTo(blei1);
    }

    @Test
    public void testGetStateUsingEnumMapQuecksilberGas() {
        Quecksilber quecksilber = new Quecksilber();
        Temperatur temperatur = new Temperatur(400f);

        assertThat(quecksilber.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.GAS);
    }

    @Test
    public void testGetStateUsingEnumMapQuecksilberLiquid() {
        Quecksilber quecksilber = new Quecksilber();
        Temperatur temperatur = new Temperatur(25f);

        assertThat(quecksilber.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.LIQUID);
    }

    @Test
    public void testGetStateUsingEnumMapQuecksilberSolid() {
        Quecksilber quecksilber = new Quecksilber();
        Temperatur temperatur = new Temperatur(-40f);

        assertThat(quecksilber.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.SOLID);
    }

    @Test
    public void testGetStateUsingEnumMapBleiGas() {
        Blei blei = new Blei();
        Temperatur temperatur = new Temperatur(1800f);

        assertThat(blei.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.GAS);
    }

    @Test
    public void testGetStateUsingEnumMapBleiLiquid() {
        Blei blei = new Blei();
        Temperatur temperatur = new Temperatur(400f);

        assertThat(blei.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.LIQUID);
    }

    @Test
    public void testGetStateUsingEnumMapBleiSolid() {
        Blei blei = new Blei();
        Temperatur temperatur = new Temperatur(20f);

        assertThat(blei.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.SOLID);
    }

    @Test
    public void testGetStateUsingEnumMapStickstoffGas() {
        Stickstoff stickstoff = new Stickstoff();
        Temperatur temperatur = new Temperatur(20f);

        assertThat(stickstoff.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.GAS);
    }

    @Test
    public void testGetStateUsingEnumMapStickstoffLiquid() {
        Stickstoff stickstoff = new Stickstoff();
        Temperatur temperatur = new Temperatur(-200f);

        assertThat(stickstoff.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.LIQUID);
    }

    @Test
    public void testGetStateUsingEnumMapStickstoffSolid() {
        Stickstoff stickstoff = new Stickstoff();
        Temperatur temperatur = new Temperatur(-220f);

        assertThat(stickstoff.getStateUsingEnumMap(temperatur)).isEqualTo(StateOfAggregation.SOLID);
    }
}