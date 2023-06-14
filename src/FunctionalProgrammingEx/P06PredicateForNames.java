package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> isLengthCorrect = name -> name.length() <= length;

        Arrays.stream(names).filter(isLengthCorrect).forEach(System.out::println);
    }
}
