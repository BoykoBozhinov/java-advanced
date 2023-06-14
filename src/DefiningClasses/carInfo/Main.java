package DefiningClasses.carInfo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            String[] cars = scanner.nextLine().split("\\s+");

            Car car = new Car();
            car.setBrand(cars[0]);
            car.setModel(cars[1]);
            car.setHorsePower(Integer.parseInt(cars[2]));

            System.out.println(car.carInfo());
        }
    }
}
