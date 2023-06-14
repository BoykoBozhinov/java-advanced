package MultidimensinalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqualMatrices = compareMatrices(firstMatrix, secondMatrix);
        if (areEqualMatrices) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static int[][] readMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int r = 0; r < firstMatrix.length; r++) {
            int[] firstArr = firstMatrix[r];
            int[] secondArr = secondMatrix[r];

            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int c = 0; c < firstArr.length; c++) {
                int firstElement = firstArr[c];
                int secondElement = secondArr[c];

                if (firstElement != secondElement) {
                    return false;
                }
            }
        }
        return true;
    }
}
