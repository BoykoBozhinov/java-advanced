package MultidimensionalArraysEx;

import java.util.*;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        int[] firstArr = {3,5,6,10};
        int[] secondArr = {1,3,5,20};
        List<Integer> first = Arrays.asList(3,5,6,10);
        List<Integer> second = Arrays.asList(1,3,5,20);

        HashSet<Integer> set = new HashSet<>(first);
        set.retainAll(second);
        System.out.println(set);
        System.out.println(findCommon(firstArr,secondArr));
    }
    public static List<Integer> findCommon(int[] a, int[] b) {
        final Set<Integer> set = new HashSet<>(Arrays.stream(a).boxed().collect(Collectors.toList()));
        final List<Integer> result = new LinkedList<>();
        for (int element : b) {
            if (set.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
