package ch.hslu.oop.rep.exceptions;

public class EmptyTemperatureCourseException extends Exception {

    public EmptyTemperatureCourseException() {
    }

    public EmptyTemperatureCourseException(String msg) {
        super(msg);
    }

    public EmptyTemperatureCourseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public EmptyTemperatureCourseException(Throwable cause) {
        super(cause);
    }

}
