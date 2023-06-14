package ExamPreparation;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        int startRow = 0;
        int startCol = 0;

        boolean hasWon = false;

        for (int row = 0; row < matrix.length; row++) {
            String[] elements = scanner.nextLine().split("");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = elements[col];
                if (matrix[row][col].equals("f")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        matrix[startRow][startCol] = "-";
        String command = scanner.nextLine();

        while (commandsCount-- > 0) {
            int prevRow = startRow;
            int prevCol = startCol;

            String field = "";

            switch (command) {
                case "up":
                    startRow--;
                    if (startRow < 0) {
                        startRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    startRow++;
                    if (startRow > matrix.length - 1) {
                        startRow = 0;
                    }
                    break;
                case "left":
                    startCol--;
                    if (startCol < 0) {
                        startCol = matrix.length - 1;
                    }
                    break;
                case "right":
                    startCol++;
                    if (startCol > matrix.length - 1) {
                        startCol = 0;
                    }
                    break;
            }

            field = matrix[startRow][startCol];

            if (field.equals("B")) {
                commandsCount--;
                continue;

            } else if (field.equals("T")) {
                startRow = prevRow;
                startCol = prevCol;
                field = matrix[startRow][startCol];

            } else if (field.equals("F")) {
                System.out.println("Player won!");
                hasWon = true;
                break;
            }
            if (commandsCount <= 0) {
                break;
            }
            command = scanner.nextLine();
        }

        if (!hasWon) {
            System.out.println("Player lost!");
        }
        matrix[startRow][startCol] = "f";
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
