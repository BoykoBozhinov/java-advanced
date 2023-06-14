package MultidimensionalArraysEx;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] inputData = input.split("\\s+");
            String command = inputData[0];

            if (command.equals("swap") && inputData.length - 1 == 4 && isValidIndex(matrix, inputData)) {
                int row1 = Integer.parseInt(inputData[1]);
                int col1 = Integer.parseInt(inputData[2]);
                int row2 = Integer.parseInt(inputData[3]);
                int col2 = Integer.parseInt(inputData[4]);
                String oldElement = matrix[row1][col1];
                matrix[row1][col1] = matrix[row2][col2];
                matrix[row2][col2] = oldElement;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }

    private static boolean isValidIndex(String[][] matrix, String[] inputData) {
        int row1 = Integer.parseInt(inputData[1]);
        int col1 = Integer.parseInt(inputData[2]);
        int row2 = Integer.parseInt(inputData[3]);
        int col2 = Integer.parseInt(inputData[4]);

        return row1 >= 0 && row1 <= matrix.length && col1 >= 0 && col1 <= matrix.length
                && row2 >= 0 && row2 <= matrix.length && col2 >= 0 && col2 <= matrix.length;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
