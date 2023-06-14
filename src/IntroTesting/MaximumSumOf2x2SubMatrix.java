package IntroTesting;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = matrixReader(scanner);

        int maxSum = Integer.MIN_VALUE;

        int[][] result = new int[2][2];
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    result = new int[][]{
                            {matrix[row][col], matrix[row][col + 1]},
                            {matrix[row + 1][col], matrix[row + 1][col + 1]}
                    };
                }
            }
        }
        printMatrix(result);
        System.out.println(maxSum);
    }


    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] matrixReader(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] elements = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = elements;
        }
        return matrix;
    }
}
