package DefiningClassesEx.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {

            String[] carInfo = scanner.nextLine().split("\\s+");

            String carModel = carInfo[0];
            int enginePower = Integer.parseInt(carInfo[2]);
            String cargoType = carInfo[4];

            ArrayList<Tires> tiresList = new ArrayList<>();
            Tires tires = new Tires(Double.parseDouble(carInfo[5])
                    , Double.parseDouble(carInfo[7])
                    , Double.parseDouble(carInfo[9])
                    , Double.parseDouble(carInfo[11]));
            tiresList.add(tires);
            Engine engine = new Engine(enginePower);
            Cargo cargo = new Cargo(cargoType);
            Car car = new Car(carModel, engine, cargo, tiresList);
            cars.add(car);
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")) {
            List<String> model = new ArrayList<>();
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getCargo().getCargoType().equals("fragile")) {
                    model = getModel(cars);
                }
            }
            model.forEach(System.out::println);
        } else if (cargoType.equals("flamable")) {
            cars.forEach(e -> {
                if (e.getEngine().getEnginePower() >= 250) {
                    System.out.printf("%s%n", e.getModel());
                }
            });
        }
    }

    public static List<String> getModel(List<Car> cars) {
        List<String> model = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getTires().get(0).getTirePressure1() < 1 || cars.get(i).getTires().get(0).getTirePressure2() < 1
                    || cars.get(i).getTires().get(0).getTirePressure3() < 1
                    || cars.get(i).getTires().get(0).getTirePressure4() < 1) {
                model.add(cars.get(i).getModel());
            }
        }
        return model;
    }
}
