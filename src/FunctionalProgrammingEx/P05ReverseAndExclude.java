package FunctionalProgrammingEx;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int divisible = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);

        Predicate<Integer> isDivisible = e -> e % divisible != 0;

        numbers = numbers.stream().filter(isDivisible).collect(Collectors.toList());
        numbers.forEach(e -> System.out.print(e + " "));
    }
}
