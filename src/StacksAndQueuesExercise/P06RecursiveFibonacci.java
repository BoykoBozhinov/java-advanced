package StacksAndQueuesExercise;

import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static long[] fibonacciCache;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        fibonacciCache = new long[num + 1];
        System.out.println(fib(num));
    }

    private static long fib(int num) {
        if (num <= 2) {
            return num;
        }
        if (fibonacciCache[num] != 0) {
            return fibonacciCache[num];
        }
        long nthFibonacciNumber = (fib(num - 1) + fib(num - 2));
        fibonacciCache[num] = nthFibonacciNumber;
        return nthFibonacciNumber;
    }
}
