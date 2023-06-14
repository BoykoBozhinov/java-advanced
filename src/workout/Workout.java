package workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                exercises.remove(exercise);
                return true;
            }
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream().filter(e -> e.getName().equals(name) && e.getMuscle().equals(muscle))
                .findAny().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max((e1, e2) -> Integer.compare(e1.getBurnedCalories(), e2.getBurnedCalories()))
                .orElse(null);
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Workout type: ").append(type).append(System.lineSeparator());
        for (Exercise e : exercises) {
            sb.append(e).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
