package MultidimensinalArraysLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            sum += Arrays.stream(arr).sum();
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
