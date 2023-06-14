package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Kat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> platesQueue = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(carsStack::push);

        int registeredCarsCount = 0;
        int daysCount = 0;
        while (!platesQueue.isEmpty() && !carsStack.isEmpty()) {
            daysCount++;

            int currentPlates = 0;
            for (int i = 0; i < 1; i++) {
                currentPlates = platesQueue.poll();
            }

            int currentCars = 0;
            for (int i = 0; i < 1; i++) {
                currentCars = carsStack.pop();
            }

            if (currentPlates > (currentCars * 2)) {
                platesQueue.offer(currentPlates - (currentCars * 2));
                registeredCarsCount += currentCars;
            } else if (currentPlates < (currentCars * 2)) {
                int leftCars = currentCars - (currentPlates / 2);
                carsStack.addLast(leftCars);
                registeredCarsCount += currentPlates / 2;
            } else {
                registeredCarsCount += currentCars;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", registeredCarsCount, daysCount);
        if (!platesQueue.isEmpty()) {
            int sumOfUnplacedPlates = 0;
            while (!platesQueue.isEmpty()) {
                sumOfUnplacedPlates += platesQueue.poll();
            }
            System.out.printf("%d license plates remain!", sumOfUnplacedPlates);
        } else if (!carsStack.isEmpty()) {
            long sumOfCarsWithoutPlate = 0;
            while (!carsStack.isEmpty()) {
                sumOfCarsWithoutPlate += carsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!", sumOfCarsWithoutPlate);
        } else {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
