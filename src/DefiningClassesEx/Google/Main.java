package DefiningClassesEx.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Person> personMap = new HashMap<>();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            personMap.putIfAbsent(name, new Person());
            String enteredData = data[1];

            switch (enteredData) {
                case "company":
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department, salary);
                    personMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(name).getPokemon().add(pokemon);
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    personMap.get(name).getParent().add(parent);
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    Child child = new Child(childName, childBirthday);
                    personMap.get(name).getChild().add(child);
                    break;
                case "car":
                    String model = data[2];
                    int speed = Integer.parseInt(data[3]);
                    Car car = new Car(model, speed);
                    personMap.get(name).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }

        String personName = scanner.nextLine();
        System.out.println(personName);

        Person personData = personMap.get(personName);
        System.out.print(personData);
    }
}
