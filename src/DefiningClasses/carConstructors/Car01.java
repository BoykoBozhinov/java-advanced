package DefiningClasses.carConstructors;

public class Car01 {
    private String brand;
    private String model;
    private int horsePower;

    public Car01(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car01(String brand) {
        this(brand, "unknown", -1);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.",brand, model, horsePower);
    }
}
