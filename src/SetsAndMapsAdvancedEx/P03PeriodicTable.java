package SetsAndMapsAdvancedEx;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Set<String> chemicals = new TreeSet<>();
        for (int i = 0; i < number; i++) {
            String[] elements = scanner.nextLine().split(" ");
            chemicals.addAll(Arrays.asList(elements));
        }
        String result = String.join(" ", chemicals);
        System.out.println(result);
    }
}
