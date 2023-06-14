package IntroTesting;

import java.util.Arrays;
import java.util.Scanner;

public class RecursionLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int sum = sum(numbers,0);
        System.out.println(sum);
    }
    private static int sum(int[] numbers,int index) {
        if (index == numbers.length - 1) {
            return numbers[index];
        }
        return numbers[index] + sum(numbers,index +1);
    }
}
