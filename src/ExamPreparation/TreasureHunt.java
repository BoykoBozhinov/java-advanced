package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[rows][cols];

        int startRow = 0;
        int starCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            String[] readLine = scanner.nextLine().split("\\s+");

            matrix[row] = readLine;
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].contains("Y")) {
                    startRow = row;
                    starCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        List<String> directions = new ArrayList<>();

        while (!command.equals("Finish")) {

            if (command.equals("up")) {
                if (startRow - 1 >= 0 && !matrix[startRow - 1][starCol].equals("T")) {
                    startRow--;
                    directions.add(command);
                }
            } else if (command.equals("down")) {
                if (startRow + 1 < rows && !matrix[startRow + 1][starCol].equals("T")) {
                    startRow++;
                    directions.add(command);
                }
            } else if (command.equals("left")) {
                if (starCol - 1 >= 0 && !matrix[startRow][starCol - 1].equals("T")) {
                    starCol--;
                    directions.add(command);
                }
            } else if (command.equals("right")) {
                if (starCol + 1 < cols && !matrix[startRow][starCol + 1].equals("T")) {
                    starCol++;
                    directions.add(command);
                }
            }
            command = scanner.nextLine();
        }

        if (matrix[startRow][starCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s", String.join(", ", directions));
        } else {
            System.out.println("The map is fake!");
        }
    }
}
