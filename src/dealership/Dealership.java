package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        Car car = getCar(manufacturer, model);
        if (data.contains(car)) {
            data.remove(car);
            return true;
        }
        return false;
    }

    public Car getLatestCar() {
        return data.stream().max(Comparator.comparingInt(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model) {
        return data.stream().filter(car -> car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:%n", name));
        for (Car car : data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
