package DefiningClassesEx.Google;

public class Car {
    private String carModel;
    private int speed;

    public Car(String carModel, int speed) {
        this.carModel = carModel;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %d", carModel, speed);
    }
}
