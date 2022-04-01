package ch.hslu.oop.rep.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DemoSelectionIterationTest {

    @Test
    public void testMaxFirstNumBigger() {
        int max = DemoSelectionIteration.max(40, 35);
        assertThat(max).isEqualTo(40);
    }

    @Test
    public void testMaxSecondNumBigger() {
        int max = DemoSelectionIteration.max(45, 55);
        assertThat(max).isEqualTo(55);
    }

    @Test
    public void testMaxSameNums() {
        int max = DemoSelectionIteration.max(60, 60);
        assertThat(max).isEqualTo(60);
    }

    @Test
    public void testMinFirstNumSmaller() {
        int min = DemoSelectionIteration.min(10, 12);
        assertThat(min).isEqualTo(10);
    }

    @Test
    public void testMinSecondNumSmaller() {
        int min = DemoSelectionIteration.min(20, 15);
        assertThat(min).isEqualTo(15);
    }

    @Test
    public void testMinFirstSameNums() {
        int min = DemoSelectionIteration.min(30, 30);
        assertThat(min).isEqualTo(30);
    }

    @Test
    public void testMaxOfThreeArgsFirstNumBiggest() {
        int max = DemoSelectionIteration.maxOfThreeArgs(100, 90, 80);
        assertThat(max).isEqualTo(100);
    }

    @Test
    public void testMaxOfThreeArgsSecondNumBiggest() {
        int max = DemoSelectionIteration.maxOfThreeArgs(120, 130, 110);
        assertThat(max).isEqualTo(130);
    }

    @Test
    public void testMaxOfThreeArgsThirdNumBiggest() {
        int max = DemoSelectionIteration.maxOfThreeArgs(150, 170, 180);
        assertThat(max).isEqualTo(180);
    }

    @Test
    public void testMaxOfThreeArgsAllTheSame() {
        int max = DemoSelectionIteration.maxOfThreeArgs(200, 200, 200);
        assertThat(max).isEqualTo(200);
    }

    @Test
    public void testMaxOfIntArray() {
        int[] testArray = {1, 34, 46, 12, 32432544, 2343, 123, 463456, 24, 5435, 324324};
        int max = DemoSelectionIteration.maxOfIntArray(testArray);
        assertThat(max).isEqualTo(32432544);
    }

    @Test
    public void testMaxOfIntArrayWithStream() {
        int[] testArray = {1, 34, 46, 12, 32432544, 2343, 123, 463456, 24, 5435, 324324};
        int max = DemoSelectionIteration.maxOfIntArrayWithStream(testArray);
        assertThat(max).isEqualTo(32432544);
    }

    @Test
    public void testPrintNumsZeroToTenForLoop() {
        DemoSelectionIteration.printNumsZeroToTenForLoop();
    }

    @Test
    public void testPrintNumsZeroToTenWhileLoop() {
        DemoSelectionIteration.printNumsZeroToTenWhileLoop();
    }

    @Test
    public void testPrintNumsZeroToTenDoWhileLoop() {
        DemoSelectionIteration.printNumsZeroToTenDoWhileLoop();
    }

    @Test
    public void testFloatWhileLoop() {
        DemoSelectionIteration.floatWhileLoop(0.9f, 0.000025f);
    }

    @Test
    public void testFloatForLoop() {
        DemoSelectionIteration.floatForLoop(0.9f, 0.000025f, 4003);
    }

    @Test
    public void testPrintBox() {
        DemoSelectionIteration.printBox(10, 5);
    }

}