package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        for (String kid : kids) {
            kidsQueue.offer(kid);
        }

        while (kidsQueue.size() > 1) {
            for (int i = 1; i < number; i++) {
                kidsQueue.offer(kidsQueue.poll());
            }
            System.out.println("Removed " + kidsQueue.pollFirst());
        }
        System.out.println("Last is " + kidsQueue.poll());
    }
}
