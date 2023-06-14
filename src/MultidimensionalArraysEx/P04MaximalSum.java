package MultidimensionalArraysEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[0];

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int maxSum = Integer.MIN_VALUE;
        int startingRow = 0;
        int startingCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    startingRow = row;
                    startingCol = col;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = startingRow; row < startingRow + 3; row++) {
            for (int col = startingCol; col < startingCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
