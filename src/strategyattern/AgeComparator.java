package strategyattern;

import java.util.Comparator;
import java.util.TreeSet;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person first, Person second) {
        return first.getAge() - second.getAge();
    }
}
