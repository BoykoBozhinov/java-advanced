package DefiningClassesEx.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelForOneKm;
    private int traveledDistance;

    public Car(String model, int fuelAmount, double fuelForOneKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelForOneKm =fuelForOneKm;
    }

    public double calculateRequiredFuel(int distance) {
        return  this.fuelForOneKm * distance;
    }

    public boolean hasEnoughFuel(int distance) {
        return fuelAmount >= calculateRequiredFuel(distance);
    }

    public void drive(int distance) {
        if (hasEnoughFuel(distance)) {
           this.fuelAmount -= calculateRequiredFuel(distance);
           this.traveledDistance += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    private void setFuelForOneKm(double fuelForOneKm) {
        this.fuelForOneKm = fuelForOneKm;
    }

    public double getFuelForOneKm(double fuelForOneKm) {
        return fuelForOneKm;
    }

    public void setTraveledDistance(int traveledDistance) {
        this.traveledDistance = traveledDistance;
    }

    public int getTraveledDistance() {
        return traveledDistance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", model, fuelAmount, traveledDistance);
    }
}
