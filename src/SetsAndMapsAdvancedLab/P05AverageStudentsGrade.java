package SetsAndMapsAdvancedLab;

import java.util.*;

public class P05AverageStudentsGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> average = new TreeMap<>();
        while (number-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            if (!average.containsKey(name)) {
                average.put(name, new ArrayList<>());
                average.get(name).add(grade);
            } else {
                average.get(name).add(grade);
            }
        }
        average.forEach((key, value) -> {
            double sum = 0;
            for (int i = 0; i <= value.size() - 1; i++) {
                sum += value.get(i);
            }
            double avgSum = sum / value.size();

            System.out.print(key + " -> ");
            value.forEach(element -> System.out.printf("%.2f ", element));
            System.out.printf("(avg: %.2f)%n", avgSum);
        });
    }
}
