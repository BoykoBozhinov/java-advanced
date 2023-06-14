package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Set<String> cars = new LinkedHashSet<>();
        while (!input.equals("END")) {
            String[] carNumber = input.split(", ");

            String command = carNumber[0];
            String licencePlate = carNumber[1];

            if (command.equals("IN")) {
                cars.add(licencePlate);
            } else if (command.equals("OUT")){
                cars.remove(licencePlate);
            }
            input = scanner.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
