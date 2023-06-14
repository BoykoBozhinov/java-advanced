package IntroTesting;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int rol = 0; rol < size; rol++) {
           matrix[rol]= Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int index = 0;index < size;index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();

        int row = size - 1;
        int col = 0;
        while (row >= 0 && row < size && col >= 0 && col < size) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }

    }
}
