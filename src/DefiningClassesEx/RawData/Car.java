package DefiningClassesEx.RawData;

import java.util.ArrayList;

public class Car {
    private String model;
    private Cargo cargo;
    private Engine engine;
    private ArrayList<Tires> tires;

    public Car(String model, Engine engine, Cargo cargo, ArrayList<Tires> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public ArrayList<Tires> getTires() {
        return tires;
    }
}
