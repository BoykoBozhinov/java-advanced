package ExamPreparation;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] moves = scanner.nextLine().split(",");


        String[][] matrix = new String[size][size];

        int startRow = 0;
        int startCol = 0;
        for (int row = 0; row < matrix.length; row++) {
            String[] field = scanner.nextLine().split("\\s+");
            matrix[row] = field;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("D")) {
                    startRow = row;
                    startCol = col;
                }
            }
        }

        int stolenMoney = 0;
        boolean isCaught = false;
        for (int i = 0; i < moves.length; i++) {
            String command = moves[i];

            switch (command) {
                case "up":
                    if (startRow - 1 >= 0) {
                        startRow--;
                        matrix[startRow + 1][startCol] = "+";
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (startRow + 1 < matrix.length) {
                        startRow++;
                        matrix[startRow - 1][startCol] = "+";
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (startCol - 1 >= 0) {
                        startCol--;
                        matrix[startRow][startCol + 1] = "+";
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (startCol + 1 < matrix.length) {
                        startCol++;
                        matrix[startRow][startCol - 1] = "+";
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }
            String field = matrix[startRow][startCol];
            matrix[startRow][startCol] = "D";

            if (field.equals("$")) {
                System.out.printf("You successfully stole %d$.%n", startRow * startCol);
                stolenMoney += startRow * startCol;

            }
            if (field.equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                matrix[startRow][startCol] = "#";
                isCaught = true;
                break;
            }
        }
        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }
        printMatrix(matrix);
    }

    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
