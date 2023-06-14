package MultidimensionalArraysEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rotation = scanner.nextLine();
        String rotationDegree = rotation.split("[()]")[1];
        int rotationNumber = Integer.parseInt(rotationDegree);
        int angleOfRotation = rotationNumber % 360;

        String command = scanner.nextLine();

        List<String> words = new ArrayList<>();

        while (!command.equals("END")) {
            words.add(command);

            command = scanner.nextLine();
        }
        int rows = words.size();
        int cols = getLongestWord(words);

        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (col >= words.get(row).length()) {
                    matrix[row][col] = ' ';
                } else {
                    matrix[row][col] = words.get(row).charAt(col);
                }
            }
        }
        switch (angleOfRotation) {
            case 0:
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

    private static int getLongestWord(List<String> words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord.length();
    }
}
