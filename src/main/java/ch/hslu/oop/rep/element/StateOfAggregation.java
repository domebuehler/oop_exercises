package ch.hslu.oop.rep.element;

public enum StateOfAggregation {
    FLUID("flüssig"), GASEOUS("gasförmig"), SOLID("fest");

    private final String description;

    StateOfAggregation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
