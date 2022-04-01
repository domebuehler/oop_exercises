package ch.hslu.oop.sw06.polymorphie;

public class Polymorphy {

    public static void testPolymorphy() {

        //Up-Casting funktioniert immer!
        Shape shape1 = new Rectangle(1, 1, 5, 10);
        Shape shape2 = new Circle(1, 1, 10);

        //Funktioniert, da Methode move in Superklasse Shape definiert ist.
        shape1.move(4, 4);
        shape2.move(4, 4);

        //Damit dies funktioniert, muss ein Down-Casting geschehen
        //D.h. wir sagen dem Compiler, dass shape2 ein Circle ist.
        int diameter = ((Circle) shape2).getDiameter();

        //Auch Interfaces können als Subtypen verwendet werden!
        Switchable motor = new Motor();
        motor.switchOn();
        motor.switchOff();
        motor.isSwitchedOff();
        motor.isSwitchedOn();
    }
}
