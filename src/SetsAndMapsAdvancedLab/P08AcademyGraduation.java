package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();
        while (number-- > 0) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble).collect(Collectors.toList());

            students.putIfAbsent(name, grades);
        }
        DecimalFormat df = new DecimalFormat("#.#####");

        students.entrySet().stream().forEach(entry -> {
            System.out.printf("%s is graduated with ", entry.getKey());
            double avg = 0;
            for (double grade : entry.getValue()) {
                avg += grade;
            }
            avg /= entry.getValue().size();
            System.out.printf("%s%n", avg);
        });
    }
}
