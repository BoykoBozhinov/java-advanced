package SetsAndMapsAdvancedEx;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] length = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        for (int i = 0; i < length[0];i++) {
            int number = Integer.parseInt(scanner.nextLine());
            first.add(number);
        }

        for (int j = 0; j < length[1]; j++) {
            int number = Integer.parseInt(scanner.nextLine());
            second.add(number);
        }
       first.retainAll(second);
        for (int num : first) {
            System.out.print(num + " ");
        }
    }
}
