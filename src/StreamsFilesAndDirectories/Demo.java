package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String path = "C:\\Users\\Boyko\\Desktop\\Streams\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(fileInputStream);

            String input = scanner.nextLine();
            List<String> fileContent = new ArrayList<>();
            while (!input.isEmpty()) {
                input = scanner.nextLine();
                fileContent.add(input);
            }
            System.out.println(String.join(System.lineSeparator(), fileContent));
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
