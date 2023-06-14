package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(lilies::push);

        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int wreaths = 0;
        int storedFlowersSum = 0;
        while (lilies.size() != 0 && roses.size() != 0) {
            int sumFlowers = lilies.peek() + roses.peek();
            if (sumFlowers == 15) {
                wreaths++;
                lilies.pop();
                roses.poll();
            } else if (sumFlowers > 15) {
                while (sumFlowers > 15) {
                    sumFlowers -= 2;
                }
                if (sumFlowers == 15) {
                    wreaths++;
                    lilies.pop();
                    roses.poll();
                }
            }
            if (sumFlowers < 15) {
                storedFlowersSum += sumFlowers;
                lilies.pop();
                roses.poll();
            }
        }

        while (storedFlowersSum >= 15) {
            wreaths++;
            storedFlowersSum -= 15;
        }

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }
    }

}
