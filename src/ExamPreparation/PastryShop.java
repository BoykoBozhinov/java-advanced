package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredientStack::push);

        Map<String, Integer> food = new LinkedHashMap<>();
        food.put("Biscuit", 0);
        food.put("Cake", 0);
        food.put("Pie", 0);
        food.put("Pastry", 0);

        while (!ingredientStack.isEmpty() && !liquidsQueue.isEmpty()) {

            int ingredient = ingredientStack.pop();

            int mix = liquidsQueue.poll() + ingredient;

            String cookedFood = "";
            switch (mix) {
                case 25:
                    cookedFood = "Biscuit";
                    break;
                case 50:
                    cookedFood = "Cake";
                    break;
                case 75:
                    cookedFood = "Pastry";
                    break;
                case 100:
                    cookedFood = "Pie";
                    break;
                default:
                    cookedFood = null;
                    break;
            }

            if (cookedFood != null) {
                int value = food.get(cookedFood) + 1;
                food.put(cookedFood, value);
            } else {
                ingredientStack.push(ingredient + 3);
            }
        }

        boolean allFoodsAreCooked = food.entrySet().stream().allMatch(e -> e.getValue() > 0);
        if (allFoodsAreCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquidsQueue.toString().replace("[", "").replace("]", ""));

        }

        if (ingredientStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredientStack.toString().replace("[", "").replace("]", ""));
        }

        food.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    public static boolean hasEnoughFood(int biscuit, int cake, int pastry, int pie) {
        return biscuit >= 1 && cake >= 1 && pastry >= 1 && pie >= 1;
    }
}
