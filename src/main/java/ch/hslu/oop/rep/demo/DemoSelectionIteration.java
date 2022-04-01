package ch.hslu.oop.rep.demo;

import java.util.Arrays;

public final class DemoSelectionIteration {

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static int maxOfThreeArgs(int a, int b, int c) {
        int max;
        if ((max = max(a, b)) > c) {
            return max;
        } else {
            return c;
        }
    }

    public static int maxOfIntArray(int[] intValues) {
        int maxPos = 0;
        for (int i = 0; i < intValues.length; i++) {
            if (intValues[i] > intValues[maxPos]) {
                maxPos = i;
            }
        }
        return intValues[maxPos];
    }

    public static int maxOfIntArrayWithStream(int[] intValues) {
        return Arrays.stream(intValues).max().getAsInt();
    }

    public static void printNumsZeroToTenForLoop() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public static void printNumsZeroToTenWhileLoop() {
        int i = 0;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    public static void printNumsZeroToTenDoWhileLoop() {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);
    }

    public static void floatWhileLoop(float startValue, float addValue) {
        float floatToIncrease = startValue;
        int iterCount = 0;

        while (floatToIncrease < 1.0f) {
            floatToIncrease += addValue;
            iterCount++;
        }

        System.out.println("float value: " + floatToIncrease);
        System.out.println("iter count: " + iterCount);
    }

    public static void floatForLoop(float startValue, float addValue, int numOfIter) {
        float floatToIncrease = startValue;

        for (int i = 0; i <= numOfIter; i++) {
            floatToIncrease += addValue;
        }

        System.out.println("float value: " + floatToIncrease);
        System.out.println("iter count: " + numOfIter);
    }

    public static void printBox(final int height, final int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    System.out.print("#");
                } else {
                    if (j == 0 || j == width - 1) {
                        System.out.print("#");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
