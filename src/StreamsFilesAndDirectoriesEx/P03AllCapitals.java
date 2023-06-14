package StreamsFilesAndDirectoriesEx;


import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "Resources/input.txt";

        BufferedReader br = new BufferedReader(new FileReader(path));
        PrintWriter pw = new PrintWriter(new FileWriter("Resources/allCapital.txt"));
        br.lines().forEach(line -> pw.println(line.toUpperCase()));
        pw.close();
        br.close();
    }
}
