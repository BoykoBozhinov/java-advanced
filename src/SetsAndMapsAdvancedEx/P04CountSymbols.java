package SetsAndMapsAdvancedEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (!map.containsKey(symbol)) {
                map.put(symbol, 1);
            } else {
                int occurrences = map.get(symbol);
                map.put(symbol, occurrences + 1);
            }
        }
        for (Map.Entry<Character, Integer> symbol : map.entrySet()) {
            System.out.printf("%c: %d time/s%n", symbol.getKey(), symbol.getValue());
        }
    }
}
