package sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Habitat {
    private List<Elephant> data;
    private int capacity;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (data.size() < capacity) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Elephant getElephant(String retiredFrom) {
        for (Elephant elephant : data) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant() {
        return Collections.max(data, Comparator.comparingInt(Elephant::getAge));
    }

    public int getAllElephants() {
        return data.size();
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder("Saved elephants in the park:");
        sb.append(System.lineSeparator());
        for (Elephant elephant:data) {
            sb.append(String.format("%s came from: %s%n", elephant.getName(), elephant.getRetiredFrom()));
        }
        return sb.toString();
    }
}
