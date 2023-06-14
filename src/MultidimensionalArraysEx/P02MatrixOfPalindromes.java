package MultidimensionalArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrixOfStrings = new String[rows][cols];

        for (int row = 0; row < matrixOfStrings.length; row++) {
            for (int col = 0; col < matrixOfStrings[row].length; col++) {
                char outsideLetter = (char) ('a' + row);
                char middleLetter = (char) ('a' + col + row);
                matrixOfStrings[row][col] = String.valueOf(outsideLetter) + middleLetter + outsideLetter;
            }
        }
        for (int row = 0; row < matrixOfStrings.length; row++) {
            for (int col = 0; col < matrixOfStrings[row].length; col++) {
                System.out.print(matrixOfStrings[row][col] + " ");
            }
            System.out.println();
        }
    }
}
