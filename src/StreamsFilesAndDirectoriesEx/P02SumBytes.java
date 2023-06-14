package StreamsFilesAndDirectoriesEx;

import java.io.*;

public class P02SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "Resources/input.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        int sum = 0;
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            line = br.readLine();
        }
        System.out.println(sum);
        br.close();
    }
}
