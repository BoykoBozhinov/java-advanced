package IntroTesting;

import java.util.Scanner;

public class MultidimensionalArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[3][4];

        int start = 1;

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
               matrix[row][col] = start;
               start++;
            }
        }
    }
}
