package GenericsExercise.GenericCountStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        values.add(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(values, index1, index2);
    }

    public int getGreaterElementsCount(T toCompare) {
        return (int)values.stream().filter(elements -> elements.compareTo(toCompare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s%n", value.getClass().getName(), value.toString()));
        }
        return sb.toString();
    }
}
