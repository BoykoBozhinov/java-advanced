package DefiningClassesEx.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int enginesCount = Integer.parseInt(scanner.nextLine());

        Map<String, Engine> engineMap = new LinkedHashMap<>();

        while (enginesCount-- > 0) {
            String[] engineInfo = scanner.nextLine().split("\\s+");
            String model = engineInfo[0];
            int power = Integer.parseInt(engineInfo[1]);
            Engine engine;

            if (engineInfo.length == 2) {
                engine = new Engine(model, power);
            } else if (engineInfo.length == 4) {
                engine = new Engine(model, power, Integer.parseInt(engineInfo[2]), engineInfo[3]);
            } else {
                try {
                    int displacement = Integer.parseInt(engineInfo[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException ex) {
                    engine = new Engine(model, power, engineInfo[2]);
                }
            }
            engineMap.put(model, engine);
        }


        int carsCount = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();
        while (carsCount-- > 0) {
            String[] carsInfo = scanner.nextLine().split("\\s+");
            Car car;
            String model = carsInfo[0];
            String engine = carsInfo[1];

            if (carsInfo.length == 2) {
                car = new Car(model, engineMap.get(engine));
            } else if (carsInfo.length == 4) {
                car = new Car(model, engineMap.get(engine), Integer.parseInt(carsInfo[2]), carsInfo[3]);
            } else {
                try {
                    int weight = Integer.parseInt(carsInfo[2]);
                    car = new Car(model, engineMap.get(engine), weight);
                } catch (NumberFormatException exception) {
                    car = new Car(model, engineMap.get(engine), carsInfo[2]);
                }
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
