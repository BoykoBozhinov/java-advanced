package SetsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> world = new LinkedHashMap<>();
        while (number-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String town = input[2];

            world.putIfAbsent(continent, new LinkedHashMap<>());
            world.get(continent).putIfAbsent(country, new ArrayList<>());
            world.get(continent).get(country).add(town);
        }

        world.entrySet().stream().forEach(entry -> {
            System.out.printf("%s:%n", entry.getKey());
            entry.getValue().entrySet().forEach(element -> {
                System.out.printf("%s -> %s%n", element.getKey(), String.join(", ", element.getValue()));
            });
        });
    }
}
