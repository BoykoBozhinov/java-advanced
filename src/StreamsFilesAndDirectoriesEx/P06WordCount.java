package StreamsFilesAndDirectoriesEx;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06WordCount {
    public static void main(String[] args) throws IOException {
        Scanner wordScanner = new Scanner(new FileReader("Resources/words.txt"));
        String[] wordsToSearch = wordScanner.nextLine().split("\\s+");

        Map<String, Integer> wordMap = new LinkedHashMap<>();
        for (String word : wordsToSearch) {
            wordMap.put(word, 0);
        }
        Scanner fileScanner = new Scanner(new FileReader("Resources/text.txt"));

        String word = fileScanner.next();
        while (fileScanner.hasNext()) {
            if (wordMap.containsKey(word)) {
                int occurrences = wordMap.get(word);
                wordMap.put(word, occurrences + 1);
            }
            word = fileScanner.next();
        }
        PrintWriter print = new PrintWriter(new FileWriter("Resources/results.txt"));

        wordMap.entrySet().stream().forEach(e -> print.printf("%s - %d%n", e.getKey(), e.getValue()));
        wordScanner.close();
        fileScanner.close();
        print.close();
    }
}
