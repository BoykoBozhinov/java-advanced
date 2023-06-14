package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        int numbersToPush = Integer.parseInt(numbers[0]);
        int elementsToPop = Integer.parseInt(numbers[1]);
        int elementToCheck = Integer.parseInt(numbers[2]);

        String[] stackNumbers = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersToPush; i++) {
            stack.push(Integer.parseInt(stackNumbers[i]));
        }

        for (int j = 0; j < elementsToPop; j++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(elementToCheck)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
