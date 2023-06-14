package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Boyko\\Desktop\\Streams\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        PrintWriter output = new PrintWriter("integers");
        Scanner scanner = new Scanner(inputStream);
        int bytes = inputStream.read();

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                output.println(scanner.nextInt());
            }
            scanner.next();
        }
        output.close();
    }
}
