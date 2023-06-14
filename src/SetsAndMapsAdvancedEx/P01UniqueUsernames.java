package SetsAndMapsAdvancedEx;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();
            set.add(input);
        }

        for (String word : set) {
            System.out.println(word);
        }
    }
}
