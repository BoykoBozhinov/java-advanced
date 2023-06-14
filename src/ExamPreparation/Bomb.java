package ExamPreparation;

import java.util.Scanner;

public class Bomb {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");

        String[][] matrix = new String[size][size];

        int playerRow = 0;
        int playerCol = 0;
        int bombCounter = 0;

        for (int row = 0; row < matrix.length; row++) {

            String[] line = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = line[col];

                if (matrix[row][col].contains("s")) {
                    playerRow = row;
                    playerCol = col;
                }
                if (matrix[row][col].contains("B")) {
                    bombCounter++;
                }
            }


        }

        int foundBombs = 0;
        for (int i = 0; i < directions.length; i++) {
            String command = directions[i];

            switch (command) {
                case "up":
                    if (playerRow != 0) {
                        playerRow--;
                    }
                    break;
                case "down":
                    if (playerRow != matrix.length - 1) {
                        playerRow++;
                    }
                    break;
                case "left":
                    if (playerCol != 0) {
                        playerCol--;
                    }
                    break;
                case "right":
                    if (playerCol != matrix.length - 1) {
                        playerCol++;
                    }
                    break;
            }
            if (matrix[playerRow][playerCol].equals("B")) {
                System.out.println("You found a bomb!");
                matrix[playerRow][playerCol] = "+";
                foundBombs++;
                if (foundBombs == bombCounter) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[playerRow][playerCol].equals("e")) {
                System.out.printf("END! %d bombs left on the field%n", bombCounter - foundBombs);
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombCounter - foundBombs, playerRow, playerCol);
    }
}
