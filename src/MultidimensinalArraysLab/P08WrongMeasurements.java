package MultidimensinalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int wrongValue = matrix[input[0]][input[1]];

        List<int[]> newValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int newValue = getSumNumbers(matrix, row, col, wrongValue);
                    newValues.add(new int[]{row, col, newValue});
                }
            }
        }
        for (int[] correctValue : newValues) {
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];
        }
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static int getSumNumbers(int[][] matrix, int r, int c, int wrongValue) {
        int sum = 0;
        if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != wrongValue) {
            sum += matrix[r + 1][c];
        }
        if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != wrongValue) {
            sum += matrix[r - 1][c];
        }
        if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != wrongValue) {
            sum += matrix[r][c - 1];
        }
        if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != wrongValue) {
            sum += matrix[r][c + 1];
        }
        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
