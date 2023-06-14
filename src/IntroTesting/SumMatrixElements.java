package IntroTesting;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = elements;

            sum += Arrays.stream(elements).sum();
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
