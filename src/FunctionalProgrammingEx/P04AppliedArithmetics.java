package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = numbers -> numbers.stream().map(number -> number + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = numbers -> numbers.stream().map(num -> num - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = numbers -> numbers.stream().map(num -> num * 2).collect(Collectors.toList());

        Consumer<List<Integer>> print = e -> e.forEach(number -> System.out.print(number + " "));
        String command = scanner.nextLine();

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    input = add.apply(input);
                    break;
                case "subtract":
                    input = subtract.apply(input);
                    break;
                case "multiply":
                    input = multiply.apply(input);
                    break;
                case "print":
                    print.accept(input);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
