package SetsAndMapsAdvancedLab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Map<String, Double>> products = new TreeMap<>();
        while (!input.equals("Revision")) {
            String[] info = input.split(", ");
            String shop = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            products.putIfAbsent(shop, new LinkedHashMap<>());
            products.get(shop).put(product, price);

            input = scanner.nextLine();
        }
        products.entrySet().stream().forEach(e -> {
            System.out.printf("%s->%n", e.getKey());
            e.getValue().entrySet().forEach(element -> System.out.printf("Product: %s, Price: %.1f%n", element.getKey(), element.getValue()));
        });
    }
}
