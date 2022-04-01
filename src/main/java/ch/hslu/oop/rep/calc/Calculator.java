package ch.hslu.oop.rep.calc;

public final class Calculator implements Additionable {

    @Override
    public long addition(int numOne, int numTwo) {
        return (long) numOne + numTwo;
    }
}
