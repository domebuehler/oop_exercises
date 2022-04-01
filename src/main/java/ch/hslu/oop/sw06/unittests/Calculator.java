package ch.hslu.oop.sw06.unittests;

public class Calculator implements AdditionInterface {

    @Override
    public long addition(int a, int b) {
        return (long) a + b;
    }
}
