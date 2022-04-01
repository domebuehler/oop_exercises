package ch.hslu.oop.othersolutions;

public enum ElementEnum {

    N("N", -196.0f, -210.1f),
    Pb("Pb", 1744.0f, 327.4f),
    Hg("Hg", 357.0f, -38.8f);

    private String elementName;
    private float evaporatePoint;
    private float meltPoint;

    ElementEnum(String elementName, float evaporatePoint, float meltPoint) {
        this.elementName = elementName;
        this.evaporatePoint = evaporatePoint;
        this.meltPoint = meltPoint;
    }

    public static StateOfAgregation getStateOfAgregationOfAnElement(String elementName, float actualTemp) {
        ElementEnum element = ElementEnum.valueOf(elementName);

        if (element.meltPoint > actualTemp) {
            return StateOfAgregation.fest;
        } else if (element.meltPoint < actualTemp && element.evaporatePoint > actualTemp) {
            return StateOfAgregation.fluessig;
        } else {
            return StateOfAgregation.gasfoermig;
        }
    }
}
