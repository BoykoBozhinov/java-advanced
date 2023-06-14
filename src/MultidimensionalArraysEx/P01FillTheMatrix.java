package MultidimensionalArraysEx;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(", ");
        int size = Integer.parseInt(elements[0]);
        String pattern = elements[1];

        int count = 1;

        if (pattern.equals("A")) {
            getPatternA(count, size);
        } else if (pattern.equals("B")) {
            getPatternB(count, size);
        }
    }

    private static void getPatternA(int count, int size) {
        int[][] matrixA = new int[size][size];

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrixA[row][col] = count;
                count++;
            }
        }
        printMatrix(size, matrixA);
    }

    private static void getPatternB(int count, int size) {
        int[][] matrixB = new int[size][size];
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrixB[row][col] = count;
                    count++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrixB[row][col] = count;
                    count++;
                }
            }
        }
        printMatrix(size, matrixB);
    }

    private static void printMatrix(int size, int[][] matrix) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
