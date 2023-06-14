package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshnessStack::push);

        Map<String, Integer> cocktails = new TreeMap<>();
        int pear = 0;
        int harvest = 0;
        int apple = 0;
        int fashion = 0;

        while (!freshnessStack.isEmpty() && !ingredientQueue.isEmpty()) {
            int ingredient = ingredientQueue.peek();
            int freshness = freshnessStack.peek();
            int sum = freshness * ingredient;

            if (ingredient == 0) {
                ingredientQueue.poll();
                continue;
            }

            switch (sum) {
                case 150:
                    pear++;
                    cocktails.put("Pear Sour", pear);
                    freshnessStack.pop();
                    ingredientQueue.poll();
                    break;
                case 250:
                    harvest++;
                    cocktails.put("The Harvest", harvest);
                    freshnessStack.pop();
                    ingredientQueue.poll();
                    break;
                case 300:
                    apple++;
                    cocktails.put("Apple Hinny", apple);
                    freshnessStack.pop();
                    ingredientQueue.poll();
                    break;
                case 400:
                    fashion++;
                    cocktails.put("High Fashion", fashion);
                    freshnessStack.pop();
                    ingredientQueue.poll();
                    break;
                default:
                    freshnessStack.pop();
                    ingredientQueue.poll();
                    ingredient += 5;
                    ingredientQueue.offer(ingredient);
                    break;
            }
        }

        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sumIngredients = 0;
        for (Integer i : ingredientQueue) {
            sumIngredients += i;
        }

        if (sumIngredients > 0) {
            System.out.printf("Ingredients left: %d%n", sumIngredients);
        }

        cocktails.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
    }
}