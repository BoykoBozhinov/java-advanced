package ExamPreparation;

import java.util.Scanner;

public class Bee {
    public static int startRow;
    public static int startCol;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        int pollinatedFlowers = 0;
        for (int row = 0; row < matrix.length; row++) {
            String matrixRow = scanner.nextLine();
            String[] territory = matrixRow.split("");
            matrix[row] = territory;

            if (matrixRow.contains("B")) {
                startRow = row;
                startCol = matrixRow.indexOf("B");
            }
        }
        boolean isOutOfBounds = false;
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String field = "";
            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        matrix[startRow + 1][startCol] = ".";
                        System.out.println("The bee got lost!");
                        isOutOfBounds = true;
                        break;
                    }
                    field = matrix[startRow][startCol];
                    matrix[startRow][startCol] = "B";
                    matrix[startRow + 1][startCol] = ".";
                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        matrix[startRow - 1][startCol] = ".";
                        System.out.println("The bee got lost!");
                        isOutOfBounds = true;
                        break;
                    }
                    field = matrix[startRow][startCol];
                    matrix[startRow][startCol] = "B";
                    matrix[startRow - 1][startCol] = ".";
                    break;
                case "left":
                    startCol--;
                    if (startCol < 0) {
                        matrix[startRow][startCol + 1] = ".";
                        System.out.println("The bee got lost!");
                        isOutOfBounds = true;
                        break;
                    }
                    field = matrix[startRow][startCol];
                    matrix[startRow][startCol] = "B";
                    matrix[startRow][startCol + 1] = ".";
                    break;
                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        matrix[startRow][startCol - 1] = ".";
                        System.out.println("The bee got lost!");
                        isOutOfBounds = true;
                        break;
                    }
                    field = matrix[startRow][startCol];
                    matrix[startRow][startCol] = "B";
                    matrix[startRow][startCol - 1] = ".";
                    break;

            }

            switch (field) {
                case "f":
                    pollinatedFlowers++;
                    break;
                case "O":
                    continue;
            }
            if (isOutOfBounds) {
                break;
            }
            command = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        printMatrix(matrix);
    }
    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}