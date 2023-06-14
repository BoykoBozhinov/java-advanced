package ExamPreparation;

import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int count = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int playerRow = 0;
        int playerCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            char[] line = scanner.nextLine().toCharArray();

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            String command = scanner.nextLine();

            moveMatrix(command, playerRow, playerCol, matrix);
        }

        if (matrix[playerRow][playerCol] == 'P') {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printMatrix(matrix);
    }

    public static void moveMatrix(String command, int playerRow, int playerCol, char[][] matrix) {

        int oldRow = playerRow;
        int oldCol = playerCol;

        switch (command) {

            case "up":
                playerRow--;
                if (playerRow < 0) {
                    playerRow = matrix.length - 1;
                }
                break;
            case "down":
                playerRow++;
                if (playerRow > matrix.length - 1) {
                    playerRow = 0;
                }
                break;
            case "left":
                playerCol--;
                if (playerCol < 0) {
                    playerCol = matrix.length - 1;
                }
                break;
            case "right":
                playerCol++;
                if (playerCol > matrix.length - 1) {
                    playerCol = 0;
                }
                break;
        }
        char field = matrix[playerRow][playerCol];
        matrix[oldRow][oldCol] = '.';

        if (field == 'F') {
            matrix[playerRow][playerCol] = 'P';
           return;
        }
        if (field == 'B') {
            if (matrix[playerRow][playerCol] != 'B') {
                return;
            }
           moveMatrix(command, playerRow, playerCol, matrix);
        } else if (field == 'T') {
            if (command.equals("up")) {
                moveMatrix(command, playerRow++, playerCol, matrix);
            } else if (command.equals("down")) {
                moveMatrix(command, playerRow--, playerCol, matrix);
            } else if (command.equals("left")) {
                moveMatrix(command, playerRow, playerCol++, matrix);
            } else if (command.equals("right")) {
                moveMatrix(command, playerRow, playerCol--, matrix);
            }
        }
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
