package DefiningClasses.carConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        List<Car01> cars = new ArrayList<>();

        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            if (tokens.length == 1) {
                Car01 car = new Car01(tokens[0]);
                cars.add(car);

            } else {
                Car01 car01 = new Car01(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                cars.add(car01);
            }
        }
        for (Car01 car : cars) {
            System.out.println(car);
        }
    }

}
