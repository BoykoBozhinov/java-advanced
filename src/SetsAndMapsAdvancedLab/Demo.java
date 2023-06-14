package SetsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();

        set.add("EH0266KH");
        set.add("EH0263KH");
        System.out.println(set);

        double num = 456.939129349;
        double numOne = 43.2350000;
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(num);
        System.out.println(df.format(numOne));
        LinkedHashSet<Integer> mySet = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
