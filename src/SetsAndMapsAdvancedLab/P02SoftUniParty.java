package SetsAndMapsAdvancedLab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while (!input.equals("PARTY")) {

            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }

        while (!input.equals("END")) {
            if (vip.contains(input)) {
                vip.remove(input);
            } else {
                regular.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
