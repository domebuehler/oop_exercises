package ch.hslu.oop.sw08;

public enum StateOfAggregation {

    GAS("gasförmig"), LIQUID("flüssig"), SOLID("fest");

    private String stringRepresentation;

    StateOfAggregation(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return this.stringRepresentation;
    }

    @Override
    public String toString() {
        return "StateOfAggregation{" +
                "stringRepresentation='" + stringRepresentation + '\'' +
                '}';
    }
}
