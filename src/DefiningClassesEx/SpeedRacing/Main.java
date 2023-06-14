package DefiningClassesEx.SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> cars = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            int fuelAmount = Integer.parseInt(carInfo[1]);
            double fuelCost = Double.parseDouble(carInfo[2]);
            Car car = new Car(model, fuelAmount, fuelCost);
            cars.put(model, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            String model = data[1];
            int kmToDrive = Integer.parseInt(data[2]);

            Car carToDrive = cars.get(model);
            carToDrive.drive(kmToDrive);
            input = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
