package ExamPreparation;

import java.util.*;


public class P01OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tasks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray();

        int[] threads = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();

        int taskToKill = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stackTask = fillStack(tasks);
        Deque<Integer> queueThreads = fillDeque(threads);


        while (stackTask.peekLast() != taskToKill) {

            if (queueThreads.peekFirst() >= stackTask.peek()) {
                stackTask.pop();
            }
                queueThreads.poll();

            if (stackTask.peekFirst() == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", queueThreads.peekFirst(), stackTask.peekFirst());
                for (Integer n : queueThreads) {
                    System.out.print(n + " ");
                }
                return;
            }
        }
    }

    public static Deque<Integer> fillDeque(int[] numbers) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int number : numbers) {
            queue.offer(number);
        }
        return queue;
    }

    public static Deque<Integer> fillStack(int[] threads) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int thread : threads) {
            stack.push(thread);
        }
        return stack;
    }
}
