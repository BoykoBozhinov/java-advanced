package workout;

public class Exercise {

    private String name;
    private String muscle;
    private int burnedCalories;

    public Exercise(String name, String muscle, int burnedCalories) {
        setName(name);
        setMuscle(muscle);
        setBurnedCalories(burnedCalories);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setBurnedCalories(int burnedCalories) {
        this.burnedCalories = burnedCalories;
    }

    public int getBurnedCalories() {
        return burnedCalories;
    }

    @Override
    public String toString() {
        return String.format("Exercise: %s, %s, %d", getName(), getMuscle(), getBurnedCalories());
    }
}
