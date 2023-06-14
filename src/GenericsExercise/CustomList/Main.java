package GenericsExercise.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        CustomList<String> customList = new CustomList<>();
        while (!input.equals("END")) {
            String command = input.split("\\s+")[0];

            switch (command) {
                case "Add":
                    String element = input.split("\\s+")[1];
                    customList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    String containsElement = input.split("\\s+")[1];
                    System.out.println(customList.contains(containsElement));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(input.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(input.split("\\s+")[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String greaterElement = input.split("\\s+")[1];
                    System.out.println(customList.countGreaterThan(greaterElement));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.print(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
            }
            input = scanner.nextLine();
        }
    }
}
