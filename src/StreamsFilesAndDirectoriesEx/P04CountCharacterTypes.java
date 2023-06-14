package StreamsFilesAndDirectoriesEx;

import java.io.*;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "Resources/input.txt";
        BufferedReader bf = new BufferedReader(new FileReader(path));
        PrintWriter print = new PrintWriter(new FileWriter("Resources/output.txt"));
        String line = bf.readLine();

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                if (isVowel(symbol)) {
                    vowels++;
                } else if (isPunctuation(symbol)) {
                    punctuation++;
                } else if (symbol != ' ') {
                    consonants++;
                }
            }
            line = bf.readLine();
        }

        print.printf("Vowels: %d%n", vowels);
        print.printf("Consonants: %d%n", consonants);
        print.printf("Punctuation: %d%n", punctuation);
        bf.close();
        print.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}
