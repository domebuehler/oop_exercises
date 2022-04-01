package ch.hslu.oop.sw05;

public class Main {

    public static void main(String[] args) {

        Car car = new Car("VW Golf 5");

        System.out.println(car);

        // Counting-Test

        for (int i = 0; i < 11; i++) {
            car.switchOn();
            car.switchOff();
        }
        System.out.println(car.getSwitchCount());
        System.out.println(car.motor.getSwitchCount());
        System.out.println(car.lamp.getSwitchCount());
    }

}
