package MultidimensinalArraysLab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        char[][] secondMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            secondMatrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        char[][] output = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char firstSymbol = firstMatrix[row][col];
                char secondSymbol = secondMatrix[row][col];
                if (firstSymbol != secondSymbol) {
                    output[row][col] = '*';
                } else {
                    output[row][col] = firstSymbol;
                }
            }
        }
        for (char[] arr : output) {
            for (char symbol : arr) {
                System.out.print(symbol + " ");
            }
            System.out.println();
        }
    }
}
