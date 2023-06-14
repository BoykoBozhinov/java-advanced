package DefiningClassesEx.CarSalesman;

public class Engine {
    private String engineModel;
    private int enginePower;
    private int displacement;
    private String efficiency;

    public Engine(String engineModel, int enginePower) {
        this.engineModel = engineModel;
        this.enginePower = enginePower;
        this.displacement = -1;
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, int enginePower, int displacement) {
        this(engineModel, enginePower);
        this.displacement = displacement;
    }

    public Engine(String engineModel, int enginePower, String efficiency) {
        this(engineModel, enginePower);
        this.efficiency = efficiency;
    }

    public Engine(String engineModel, int enginePower, int displacement, String efficiency) {
        this(engineModel, enginePower, displacement);
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        String displacement = this.displacement == -1
                ? "n/a"
                : String.valueOf(this.displacement);
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%n", this.engineModel
                , this.enginePower, displacement, this.efficiency);
    }
}
