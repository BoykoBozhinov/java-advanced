package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");
        ArrayDeque<String> calculator = new ArrayDeque<>();

      Collections.addAll(calculator,elements);
        while (calculator.size() > 1) {
            int first = Integer.parseInt(calculator.pop());
            String operation = calculator.pop();
            int second = Integer.parseInt(calculator.pop());

            switch (operation) {
                case "+":
                    calculator.push(String.valueOf(first + second));
                    break;
                case "-":
                    calculator.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(calculator.pop());
    }
}
