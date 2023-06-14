package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        Consumer<String> printPeople = p -> System.out.printf("Sir %s%n", p);

        people.forEach(printPeople);
    }
}
