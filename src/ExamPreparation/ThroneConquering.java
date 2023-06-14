package ExamPreparation;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        int parisRow = 0;
        int parisCol = 0;

        int helenRow = 0;
        int helenCol = 0;

        for (int row = 0; row < matrix.length; row++) {

            String[] readLine = scanner.nextLine().split("");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = readLine[col];

                if (matrix[row][col].contains("P")) {
                    parisRow = row;
                    parisCol = col;
                }
                if (matrix[row][col].contains("H")) {
                    helenRow = row;
                    helenCol = col;
                }
            }
        }
        while (parisEnergy > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0];

            int spartaRow = Integer.parseInt(data[1]);
            int spartaCol = Integer.parseInt(data[2]);

            int oldRow = parisRow;
            int oldCol = parisCol;

            matrix[spartaRow][spartaCol] = "S";

            switch (command) {
                case "up":
                    parisRow--;
                    if (parisRow < 0) {
                        parisRow++;
                    }
                    parisEnergy -= 1;
                    break;
                case "down":
                    parisRow++;
                    if (parisRow > matrix.length - 1) {
                        parisRow--;
                    }
                    parisEnergy -= 1;
                    break;
                case "left":
                    parisCol--;
                    if (parisCol < 0) {
                        parisCol++;
                    }
                    parisEnergy -= 1;
                    break;
                case "right":
                    parisCol++;
                    if (parisCol > matrix.length - 1) {
                        parisCol--;
                    }
                    parisEnergy -= 1;
                    break;
            }
            if (parisEnergy <= 0 && parisRow == helenRow && parisCol == helenCol) {
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                break;
            }

            if (matrix[parisRow][parisCol].equals("S")) {
                parisEnergy -= 2;
            }

            if (parisEnergy <= 0) {
                matrix[parisRow][parisCol] = "X";
                matrix[oldRow][oldCol] = "-";
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                break;
            }
                matrix[parisRow][parisCol] = "-";
                matrix[oldRow][oldCol] = "-";

            if (parisRow == helenRow && parisCol == helenCol) {
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                break;
            }
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