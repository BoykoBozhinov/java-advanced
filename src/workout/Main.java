package workout;

public class Main {
    public static void main(String[] args) {
        Workout workout = new Workout("strength", 3);
        Exercise exercise  = new Exercise("Bench press", "chest", 30);
        System.out.println(exercise);

        workout.addExercise(exercise);
        System.out.println(workout.removeExercise("Bench press", "arms")); // false
        System.out.println(workout.removeExercise("Bench press", "chest")); // true

        System.out.println(workout.getExercise("Bench Press", "chest")); // null

        Exercise secondExercise = new Exercise("Deadlift", "back", 50);
        Exercise thirdExercise = new Exercise("Barbell Curl", "biceps", 25);
        Exercise fourthExercise = new Exercise("Squats", "legs", 60);
        Exercise fifthExercise = new Exercise("Deadlift", "legs", 55);

        workout.addExercise(secondExercise);
        workout.addExercise(thirdExercise);
        workout.addExercise(fourthExercise);
        workout.addExercise(fifthExercise);

        Exercise mostBurnedCaloriesExercise = workout.getMostBurnedCaloriesExercise();
        System.out.println(mostBurnedCaloriesExercise);

        Exercise exerciseByNameAndMuscle = workout.getExercise("Deadlift", "back");
        System.out.println(exerciseByNameAndMuscle);

        System.out.println(workout.getExerciseCount()); // 3
        System.out.println(workout.removeExercise("Barbell Curl", "biceps")); // true

        // Print Statistics
        System.out.println(workout.getStatistics());
//Workout type: strength
//Exercise: Deadlift, back, 50
//Exercise: Squats, legs, 60


    }
}
