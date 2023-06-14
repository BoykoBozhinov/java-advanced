package ExamPreparation;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int mouseRow = 0;
        int mouseCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            char[] line = scanner.nextLine().toCharArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];

                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        int eatenCheese = 0;

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            int oldRow = mouseRow;
            int oldCol = mouseCol;

            if (command.equals("up")) {
                mouseRow--;
                if (mouseRow < 0) {
                    matrix[oldRow][oldCol] = '-';
                    break;
                }
            } else if (command.equals("down")) {
                mouseRow++;
                if (mouseRow > matrix.length) {
                    matrix[oldRow][oldCol] = '-';
                    break;
                }
            } else if (command.equals("left")) {
                mouseCol--;
                if (mouseCol < 0) {
                    matrix[oldRow][oldCol] = '-';
                    break;
                }
            } else if (command.equals("right")) {
                mouseCol++;
                if (mouseCol > matrix.length) {
                    matrix[oldRow][oldCol] = '-';
                    break;
                }
            }
            char field = matrix[mouseRow][mouseCol];
            matrix[oldRow][oldCol] = '-';
            matrix[mouseRow][mouseCol] = 'M';

            if (field == 'c') {
                eatenCheese++;
            } else if (field == 'B') {
                continue;
            }
            command = scanner.nextLine();
        }
        if (!isOutOfBounds(matrix, mouseRow, mouseCol)) {
            System.out.println("Where is the mouse?");
        }

        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }

        printMatrix(matrix);
    }

    public static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix.length;
    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
