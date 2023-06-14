package FunctionalProgrammingLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class P03CountUpperCaseWords {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Predicate<String> isWordWithUpperCase = e -> Character.isUpperCase(e.charAt(0));

        List<String> words = new ArrayList<>();
        Arrays.stream(input).filter(isWordWithUpperCase).forEach(words::add);

        System.out.println(words.size());
        for (String word : words) {
            System.out.println(word);
        }
    }
}
