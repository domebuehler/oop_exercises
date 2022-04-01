package ch.hslu.oop.rep.car;

public class CarApp {
    public static void main(String[] args) {
        Car car = new Car("Volvo");
        car.getMotor().addPropertyChangeListener(car);

        for (int i = 0; i < 10; i++) {
            car.switchOn();
            car.switchOff();
        }
    }
}
