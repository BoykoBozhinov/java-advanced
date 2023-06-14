package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestNum = list -> {
            int min = numbers.stream().mapToInt(e -> e).min().getAsInt();
            return list.lastIndexOf(min);
        };
        System.out.println(smallestNum.apply(numbers));
    }
}
