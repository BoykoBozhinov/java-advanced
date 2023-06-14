package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondBox::push);

        int loot = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.peek();
            int second = secondBox.peek();
            int sum = first + second;

            if (sum % 2 == 0) {
                loot += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                secondBox.poll();
                firstBox.offer(second);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (loot >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", loot);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", loot);
        }
    }
}
