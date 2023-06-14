package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class BlackSmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(carbonStack::push);

        Map<String, Integer> swords = new TreeMap<>();
        int swordsForged = 0;
        int gladius = 0;
        int shamshir = 0;
        int katana = 0;
        int sabre = 0;

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steel = steelQueue.peek();
            int carbon = carbonStack.peek();

            int sum = steel + carbon;

            switch (sum) {
                case 70:
                    swordsForged++;
                    gladius++;
                    swords.put("Gladius", gladius);
                    steelQueue.poll();
                    carbonStack.pop();
                    break;
                case 80:
                    swordsForged++;
                    shamshir++;
                    swords.put("Shamshir", shamshir);
                    steelQueue.poll();
                    carbonStack.pop();
                    break;
                case 90:
                    swordsForged++;
                    katana++;
                    swords.put("Katana", katana);
                    steelQueue.poll();
                    carbonStack.pop();
                    break;
                case 110:
                    swordsForged++;
                    sabre++;
                    swords.put("Sabre", sabre);
                    steelQueue.poll();
                    carbonStack.pop();
                    break;
                default:
                    steelQueue.poll();
                    carbonStack.pop();
                    carbon += 5;
                    carbonStack.push(carbon);
                    break;
            }
        }

        if (swordsForged >= 1) {
            System.out.printf("You have forged %d swords.%n", swordsForged);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            for (Integer steel : steelQueue) {
                System.out.print(String.join(", ", steelQueue.toString().replace("[", "").replace("]", "")));
            }
        }
        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");
            System.out.println(String.join(", ", carbonStack.toString().replace("[", "").replace("]", "")));
        }
        swords.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
