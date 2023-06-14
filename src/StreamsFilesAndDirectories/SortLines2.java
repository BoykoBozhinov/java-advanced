package StreamsFilesAndDirectories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines2 {
    public static void main(String[] args) throws IOException {

        String directory = "C:\\Users\\Boyko\\Desktop\\Streams\\input.txt";

        FileInputStream inputStream = new FileInputStream(directory);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        FileOutputStream output = new FileOutputStream("sorting.txt");
        BufferedWriter writer  = new BufferedWriter(new OutputStreamWriter(output));

        String line = reader.readLine();
        List<String> lines = new ArrayList<>();

        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }

       List<String> sorted = lines.stream().sorted().collect(Collectors.toList());
        for (String word: sorted) {
            writer.write(word);
            writer.newLine();
        }
        writer.close();
    }
}
