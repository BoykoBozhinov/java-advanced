package ExamPreparation;

import java.util.Scanner;


public class Armory {
    private static int currentRowPosition = -1;
    private static int currentColPosition = -1;

    private static int nextRowPosition = 0;
    private static int nextColPosition = 0;

    private static int rowFirstMirror = 0;
    private static int colFirstMirror = 0;

    private static int rowSecondMirror = 0;
    private static int colSecondMirror = 0;

    private static int mirrorCounter = 0;

    private static int sumSwords = 0;

    private static boolean isOut = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String symbols = scanner.nextLine();

            matrix[row] = symbols.toCharArray();

            if (symbols.contains("A")) {
                currentRowPosition = row;
                currentColPosition = symbols.indexOf("A");

            } else if (symbols.contains("M") && mirrorCounter < 2) {
                if (mirrorCounter == 1) {
                    rowFirstMirror = row;
                    colFirstMirror = symbols.indexOf("M");
                    mirrorCounter++;

                } else if (mirrorCounter == 0) {
                    rowSecondMirror = row;
                    colSecondMirror = symbols.indexOf("M");
                    mirrorCounter++;
                }
            }
        }

        String command = scanner.nextLine();

        while (sumSwords < 65) {
            switch (command) {
                case "up":
                    getNewPosition(matrix, -1, 0);
                    break;
                case "down":
                    getNewPosition(matrix, 1, 0);
                    break;
                case "right":
                    getNewPosition(matrix, 0, 1);
                    break;
                case "left":
                    getNewPosition(matrix, 0, -1);
                    break;
            }
            if (isOut) {
                System.out.println("I do not need more swords!");
                break;
            }
            if (sumSwords >= 65) {
                break;
            } else {
                command = scanner.nextLine();
            }
        }
        if (!isOut) {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", sumSwords);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

    private static void getNewPosition(char[][] matrix, int row, int col) {

        nextRowPosition = currentRowPosition + row;
        nextColPosition = currentColPosition + col;

        char position = matrix[nextRowPosition][nextColPosition];
        matrix[currentRowPosition][currentColPosition] = '-';

        if (!isInRange(matrix, nextRowPosition, nextColPosition)) {
            matrix[currentRowPosition][currentColPosition] = '-';
            isOut = true;
            return;

        } else if (Character.isDigit(position)) {
            int currentNum = Character.getNumericValue(position);
            sumSwords += currentNum;
        } else if (position == 'M') {
            matrix[nextRowPosition][nextColPosition] = '-';
            if (nextRowPosition == rowFirstMirror && nextColPosition == colFirstMirror) {
                nextRowPosition = rowSecondMirror;
                nextColPosition = rowSecondMirror;
            } else if (nextRowPosition == rowSecondMirror && nextColPosition == colSecondMirror) {
                nextRowPosition = rowFirstMirror;
                nextColPosition = colFirstMirror;
            }
            matrix[currentRowPosition][currentColPosition] = '-';
            matrix[nextRowPosition][nextColPosition] = '-';
            isOut = true;
            return;
        }
        currentRowPosition = nextRowPosition;
        currentColPosition = nextColPosition;

        matrix[currentRowPosition][currentColPosition] = '-';
        matrix[nextRowPosition][nextColPosition] = 'A';
    }

    private static boolean isInRange(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
