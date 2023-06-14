package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] kids = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        for (String kid : kids) {
            kidsQueue.offer(kid);
        }

        int cycle = 1;
        while (kidsQueue.size() > 1) {
            for (int i = 1; i < number; i++) {
                kidsQueue.offer(kidsQueue.poll());
            }

            if (!isPrimeCycle(cycle)) {
                System.out.println("Removed " + kidsQueue.poll());
            } else {
                System.out.println("Prime " + kidsQueue.peek());
            }
            cycle++;
        }
        System.out.println("Last is " + kidsQueue.poll());
    }

    private static boolean isPrimeCycle(int cycle) {
        if (cycle == 1) {
            return false;
        }
        for (int i = 2; i < cycle; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}
