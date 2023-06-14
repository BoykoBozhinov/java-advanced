package FunctionalProgrammingLab;

import java.util.Scanner;
import java.util.function.Function;

public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        Function<String, Integer> numbersCount = Integer::parseInt;
        int sum = 0;

        for (String s : input) {
            sum += numbersCount.apply(s);
        }
        System.out.println("Count = " + input.length);
        System.out.println("Sum = " + sum);
    }
}
