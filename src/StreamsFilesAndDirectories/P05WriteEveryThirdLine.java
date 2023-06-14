package StreamsFilesAndDirectories;

import java.io.*;


public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Boyko\\Desktop\\Streams\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        FileOutputStream fileWrite = new FileOutputStream("EveryThirdLine.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileWrite));
        String line = reader.readLine();
        int lineCounter = 1;

        while (line != null) {
            if (lineCounter % 3 == 0) {
                writer.write(line);
                writer.newLine();
        }
            lineCounter++;
            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}
