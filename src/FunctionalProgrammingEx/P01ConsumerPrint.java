package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] people = scanner.nextLine().split("\\s+");

        Consumer<String> print = System.out::println;

        Arrays.stream(people).forEach(print);
    }
}
