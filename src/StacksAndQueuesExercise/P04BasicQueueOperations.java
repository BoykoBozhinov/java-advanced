package StacksAndQueuesExercise;

import java.util.*;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int elementsToAdd = Integer.parseInt(input[0]);
        int elementsToRemove = Integer.parseInt(input[1]);
        int elementToCheck = Integer.parseInt(input[2]);

        int[] elements = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < elements.length; i++) {
            queue.offer(elements[i]);
        }
        for (int i = 0; i < elementsToRemove; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(elementToCheck)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
