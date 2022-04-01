package ch.hslu.oop.sw09;

public class ImpossibleTemperaturException extends Exception {
    public ImpossibleTemperaturException(String msg) {
        super(msg);
    }

    public ImpossibleTemperaturException() {
        super();
    }
}
