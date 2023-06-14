package StreamsFilesAndDirectoriesEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01SumLines {
    public static void main(String[] args) throws IOException {
        String path = "Resources/input.txt";
        BufferedReader bf = new BufferedReader(new FileReader(path));
        String line = bf.readLine();
        while (line != null) {
            int sum = 0;
            for (char c : line.toCharArray()) {
                sum += c;
            }
            System.out.println(sum);
            line = bf.readLine();
        }
    }
}