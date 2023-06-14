package dealership;

public class Car {
    private String manufacturer;
    private String model;
    private int year;

    public Car(String manufacturer, String model, int year) {
        setManufacturer(manufacturer);
        setModel(model);
        setYear(year);
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d)", manufacturer, model, year);
    }
}
