package MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        int col = 0;
        for (int row = 0; row < matrix.length; row++) {
            primaryDiagonal += matrix[row][col];
            col++;
        }
        int row = 0;
        col = matrix.length - 1;

        while (row >= 0 && row <= matrix.length && col <= matrix.length - 1 && col >= 0) {
            secondaryDiagonal += matrix[row][col];
            row++;
            col--;
        }
        int diff = Math.abs(primaryDiagonal - secondaryDiagonal);
        System.out.println(diff);
    }
}
