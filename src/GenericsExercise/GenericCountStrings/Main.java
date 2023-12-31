package GenericsExercise.GenericCountStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();
        while (n-- > 0) {
            Double element = Double.parseDouble(scanner.nextLine());
            box.add(element);
        }
        Double elementToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.getGreaterElementsCount(elementToCompare));
    }
}
