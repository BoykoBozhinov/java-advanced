package GenericsLab.ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 5, 50, 30, 8, 70);
        Integer maxInt = ListUtils.getMax(numbers);
        System.out.println(maxInt);

        List<String> letters = List.of("e", "b", "a", "f", "c");
        String stringMin = ListUtils.getMin(letters);
        System.out.println(stringMin);
    }
}
