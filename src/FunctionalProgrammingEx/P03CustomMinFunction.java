package FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> minNumber = Collections::min;

        System.out.println(minNumber.apply(numbers));

    }
}
