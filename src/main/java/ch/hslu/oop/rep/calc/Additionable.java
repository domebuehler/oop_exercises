package ch.hslu.oop.rep.calc;

/**
 * Interface for additions.
 */
public interface Additionable {

    /**
     * Adds two integers and returns the sum.
     *
     * @param numOne {@code int} value of the first Summand.
     * @param numTwo {@code int} value of the second Summand.
     * @return the {@code int} value of the sum.
     */
    public long addition(int numOne, int numTwo);
}
