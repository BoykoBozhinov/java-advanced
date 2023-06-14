package ExamPreparation;

import java.util.Scanner;

public class Armory1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int rowOfficer = 0;
        int colOfficer = 0;

        int firstMirrorRow = 0;
        int firstMirrorCol = 0;

        int secondMirrorRow = 0;
        int secondMirrorCol = 0;

        boolean foundFirst = false;
        String[][] matrix = new String[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] rows = scanner.nextLine().split("");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = rows[col];
                if (matrix[row][col].equals("A")) {
                    rowOfficer = row;
                    colOfficer = col;
                }
                if (matrix[row][col].equals("M") && !foundFirst) {
                    firstMirrorRow = row;
                    firstMirrorCol = col;
                    foundFirst = true;
                }
                if (matrix[row][col].equals("M") && foundFirst) {
                    secondMirrorRow = row;
                    secondMirrorCol = col;
                }
            }
        }
        int swordsPrice = 0;
        while (swordsPrice < 65) {

            String command = scanner.nextLine();
            int oldRow = rowOfficer;
            int oldCol = colOfficer;
            matrix[rowOfficer][colOfficer] = "-";
            switch (command) {
                case "up":
                    rowOfficer--;

                    break;
                case "down":
                    rowOfficer++;
                    break;
                case "left":
                    colOfficer--;
                    break;
                case "right":
                    colOfficer++;
                    break;
            }
            if (isOutOfBounds(matrix, rowOfficer, colOfficer)) {
                System.out.println("I do not need more swords!");
                matrix[oldRow][oldCol] = "-";
                break;
            }
            String field = matrix[rowOfficer][colOfficer];
            matrix[rowOfficer][colOfficer] = "A";

            if (field.equals("9")) {
                swordsPrice += Integer.parseInt(field);
            }
            if (rowOfficer == firstMirrorRow && colOfficer == firstMirrorCol) {
                rowOfficer = secondMirrorRow;
                colOfficer = secondMirrorCol;
                matrix[oldRow][oldCol] = "-";
                matrix[firstMirrorRow][firstMirrorCol] = "-";
                matrix[rowOfficer][colOfficer] = "A";
            }
        }

        if (swordsPrice >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", swordsPrice);

        printMatrix(matrix);

    }

    public static boolean isOutOfBounds(String[][] matrix, int r, int c) {
        return r < 0 || r > matrix.length - 1 || c < 0 || c > matrix.length - 1;
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
