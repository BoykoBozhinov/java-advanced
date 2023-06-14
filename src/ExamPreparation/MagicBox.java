package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondBoxStack::push);

        int claimedItems = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstBox = firstBoxQueue.peek();
            int secondBox = secondBoxStack.pop();

            int sum = firstBox + secondBox;

            if (sum % 2 == 0) {
                claimedItems += sum;
                firstBoxQueue.poll();
            } else {
                firstBoxQueue.offer(secondBox);
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d%n", claimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d%n", claimedItems);
        }
    }
}
