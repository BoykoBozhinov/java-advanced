package IntroTesting;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsAndMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        Set<Integer> mySet = new HashSet<>();
        mySet.add(13);
        mySet.add(15);
        mySet.forEach(e -> System.out.print(e + " "));
        System.out.println();
        mySet.remove(15);
        mySet.forEach(e -> System.out.print(e + " "));
    }
}
