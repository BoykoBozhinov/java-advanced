package SetsAndMapsAdvancedEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> contacts = new HashMap<>();
        while (!input.equals("search")) {
            String[] info = input.split("-");

            String name = info[0];
            String number = info[1];

            contacts.putIfAbsent(name, number);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {

            if (contacts.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, contacts.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = scanner.nextLine();
        }
    }
}
