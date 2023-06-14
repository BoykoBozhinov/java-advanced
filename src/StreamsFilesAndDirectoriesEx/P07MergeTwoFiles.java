package StreamsFilesAndDirectoriesEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("Resources/Exercises Resources/inputOne.txt");
        List<String> firstFile = Files.readAllLines(path);

        Path pathTwo = Paths.get("Resources/Exercises Resources/inputTwo.txt");
        List<String> secondFile = Files.readAllLines(pathTwo);

        Path output = Paths.get("Resources/Exercises Resources/output");
        Files.write(output, firstFile, StandardOpenOption.APPEND);
        Files.write(output, secondFile, StandardOpenOption.APPEND);


    }
}
