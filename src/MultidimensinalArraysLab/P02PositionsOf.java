package MultidimensinalArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            int[] number = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[r] = number;
        }
        int number = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == number) {
                    isFound = true;
                    System.out.printf("%d %d%n", r, c);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
