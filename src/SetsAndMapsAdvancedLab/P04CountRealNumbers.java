package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");

        Map<Double, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            double currentNumber = Double.parseDouble(numbers[i]);
            if (!map.containsKey(currentNumber)) {
                map.put(currentNumber, 1);
            } else {
                int num = map.get(currentNumber);
                map.put(currentNumber, num + 1);
            }
        }

        for (var num : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", num.getKey(), num.getValue());
        }
    }
}
