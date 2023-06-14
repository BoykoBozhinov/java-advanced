package MultidimensinalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int maxSum = 0;
        String first = "";
        String second = "";
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1];
                if (maxSum < sum) {
                    maxSum = sum;
                    first = (matrix[row][col] + " " + matrix[row][col + 1]);
                    second = (matrix[row + 1][col] + " " + matrix[row + 1][col + 1]);
                }
            }
        }
        System.out.println(first);
        System.out.println(second);
        System.out.println(maxSum);
    }
}
