package FunctionalProgrammingEx;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
            String[] commandData = input.split(" ");

            String command = commandData[0];
            String commandType = commandData[1];
            String commandArgument = commandData[2];

            switch (command) {
                case "Remove":
                    people.removeIf(getPredicate(commandType, commandArgument));
                    break;
                case "Double":
                    for (int i = 0; i < people.size(); i++) {
                        String guest = people.get(i);
                        if (getPredicate(commandType, commandArgument).test(guest)) {
                            people.add(i++, guest);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            Collections.sort(people);
            System.out.println(String.format("%s are going to the party!", String.join(", ", people)));
        }
    }

    private static Predicate<String> getPredicate(String type, String argument) {
        switch (type) {
            case "StartsWith":
                return text -> text.startsWith(argument);
            case "EndsWith":
                return text -> text.endsWith(argument);
            case "Length":
                return text -> text.length() == Integer.parseInt(argument);
            default:
                return text -> false;
        }
    }
}
