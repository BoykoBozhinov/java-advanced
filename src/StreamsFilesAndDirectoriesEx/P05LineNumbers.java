package StreamsFilesAndDirectoriesEx;

import java.io.*;

public class P05LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "Resources/inputLineNumbers.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        PrintWriter printer = new PrintWriter(new FileWriter("Resources/lineNumbers.txt"));

        String line = br.readLine();
        int counter = 1;
        while (line != null ) {
            printer.printf("%d. %s%n", counter, line);
            counter++;
            line = br.readLine();
        }
        br.close();
        printer.close();
    }
}
