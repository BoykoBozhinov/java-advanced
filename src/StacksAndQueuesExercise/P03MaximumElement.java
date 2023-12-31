package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();
        while (count-- > 0) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];

            switch (command) {
                case "1":
                    int elementToPush = Integer.parseInt(commands[1]);
                    stack.push(elementToPush);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
