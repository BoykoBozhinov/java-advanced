package IntroTesting;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackQueue {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(15);
        queue.push(90);
        queue.push(70);
        queue.push(100);
        for (int n:queue) {
            System.out.println(n);
        }
        System.out.println();
        for (int n : queue) {
            System.out.println(queue.poll());
        }
    }
}
