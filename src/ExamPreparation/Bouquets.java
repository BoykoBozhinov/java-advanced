package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                .forEach(tulipsStack::push);

        ArrayDeque<Integer> daffodilsQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int bouquets = 0;
        int storedSum = 0;
        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int tulips = tulipsStack.pop();
            int daffodils = daffodilsQueue.poll();

            int sum = tulips + daffodils;

            while (sum > 15) {
                tulips -= 2;
                sum = tulips + daffodils;
            }
            if (sum == 15) {
                bouquets++;
            } else {
                storedSum += sum;
            }
        }

        while (storedSum >= 15) {
            storedSum -= 15;
            bouquets++;
        }
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", 5 - bouquets);
        }
    }
}
