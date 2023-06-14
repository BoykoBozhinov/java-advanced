package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {

            int firstNum = firstDeck.iterator().next();
            firstDeck.remove(firstNum);
            int secondNum = secondDeck.iterator().next();
            secondDeck.remove(secondNum);

            if (firstNum > secondNum) {
                firstDeck.add(firstNum);
                firstDeck.add(secondNum);
            } else if (secondNum > firstNum) {
                secondDeck.add(firstNum);
                secondDeck.add(secondNum);
            }

            if (firstDeck.isEmpty() || secondDeck.isEmpty()) {
                break;
            }
        }
        if (firstDeck.size() > secondDeck.size()) {
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
