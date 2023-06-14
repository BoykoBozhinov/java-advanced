package IntroTesting;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] number = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = number[0];
        int col = number[1];
        int wrongNumber = matrix[row][col];

        int[][] result = new int[size][size];


        for (int r = 0; r < size; r++) {
            result[r] = matrix[r].clone();
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (result[r][c] == wrongNumber) {
                    result[r][c] = getNewNumber(matrix, r, c, wrongNumber);
                }
            }
        }

        for (int[] arr : result) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

    private static int getNewNumber(int[][] matrix, int row, int col, int wrongNumber) {
        int sum = 0;
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongNumber) {
            sum += matrix[row - 1][col];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongNumber) {
            sum += matrix[row + 1][col];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongNumber) {
            sum += matrix[row][col - 1];
        }
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongNumber) {
            sum += matrix[row][col + 1];
        }
        return sum;
    }
}
