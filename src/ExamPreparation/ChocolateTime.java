package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble)
                .forEach(cacaoStack::push);

        double percentage = 0;
        Map<String, Integer> chocolates = new TreeMap<>();
        int milk = 0;
        int dark = 0;
        int baking = 0;

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            double firstMilk = milkQueue.peek();
            double cacao = cacaoStack.peek();

            percentage = cacao / (cacao + firstMilk) * 100;

            if (percentage == 30) {
                milk++;
                chocolates.put("Milk Chocolate", milk);
            } else if (percentage == 50) {
                dark++;
                chocolates.put("Dark Chocolate", dark);

            } else if (percentage == 100) {
                baking++;
                chocolates.put("Baking Chocolate", baking);
            } else {
                firstMilk += 10;
                milkQueue.offer(firstMilk);
            }
            milkQueue.poll();
            cacaoStack.pop();
        }
        if (hasChocolate(milk, dark, baking)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolates.forEach((key, value) -> System.out.printf("# %s --> %d%n", key, value));
    }

    public static boolean hasChocolate(int milk, int dark, int baking) {
        return milk >= 1 && dark >= 1 && baking >= 1;
    }
}
