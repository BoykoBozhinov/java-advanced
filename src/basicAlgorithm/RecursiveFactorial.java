package basicAlgorithm;

import java.util.Scanner;

public class RecursiveFactorial {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num = Integer.parseInt(scanner.nextLine());

        long factorial = multiplyNumbers(num);
        System.out.println(factorial);
    }

    public static long multiplyNumbers(int num) {
        if (num >= 1)
            return num * multiplyNumbers(num - 1);
        else
            return 1;
    }
}
