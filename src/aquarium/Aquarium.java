package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
       return fishInPool.size();
    }

    public void add(Fish fish) {
        if (fishInPool.isEmpty()) {
            fishInPool.add(fish);
        }
        if (fishInPool.size() < capacity) {
            if (!fishInPool.contains(fish)) {
                fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        return fishInPool.removeIf(f -> f.getName().equals(name));
    }

    public Fish findFish(String name) {
        return fishInPool.stream().filter(f -> f.getName().equals(name)).findFirst().orElse(null);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", name, size));
       fishInPool.forEach(sb::append);
       return sb.toString().trim();
    }
}
