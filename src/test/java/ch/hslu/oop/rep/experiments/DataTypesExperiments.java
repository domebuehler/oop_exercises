package ch.hslu.oop.rep.experiments;

public final class DataTypesExperiments {

    public static int returnMaxIntPlusOne() {
        return Integer.MAX_VALUE + 1;
    }

    public static int returnMaxInt() {
        return Integer.MAX_VALUE;
    }

    public static int returnMinIntMinusOne() {
        return Integer.MIN_VALUE - 1;
    }

    public static float returnMaxFloatPlusOne() {
        return Float.MAX_VALUE + 1;
    }

    public static float returnMaxFloatAddWithEffect() {
        return Float.MAX_VALUE + 2e31f;
    }

    public static float returnFalseResult() {
        return 2 + 5 / 2;
    }

    public static float returnCorrectResult() {
        return 2 + 5 / (float) 2;
    }
}
