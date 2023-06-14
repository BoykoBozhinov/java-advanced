package SetsAndMapsAdvancedEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> phonebook = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                phonebook.put(input, email);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> map : phonebook.entrySet()) {
            System.out.printf("%s -> %s%n", map.getKey(), map.getValue());
        }
    }
}
