package FunctionalProgrammingEx;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> sorting = (first,second) -> {
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (second % 2 == 0 && first % 2 !=0) {
                return  1;
            }
            return first.compareTo(second);
        };
        Arrays.sort(numbers,sorting);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
