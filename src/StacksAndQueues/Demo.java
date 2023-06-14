package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        System.out.println("Stack:");
        stack.push(13);
        stack.push(5);
        stack.push(77);
        stack.pop();
        System.out.println(stack);

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        System.out.println("Queue:");
        queue.offer(13);
        queue.offer(5);
        queue.offer(77);
        queue.offer(99);
        System.out.println(queue);
    }
}
