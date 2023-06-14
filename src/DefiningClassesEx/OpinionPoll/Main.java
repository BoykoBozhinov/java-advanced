package DefiningClassesEx.OpinionPoll;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personSet = new ArrayList<>();

        while (n-- > 0) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            String name = personInfo[0];
            int age = Integer.parseInt(personInfo[1]);
            Person person = new Person(name, age);
            personSet.add(person);
        }

        personSet.stream().filter(person -> person.getAge() > 30)
                .sorted((left, right) -> left.getName().compareTo(right.getName()))
                .forEach(System.out::println);

    }
}
