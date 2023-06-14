package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;


public class P02WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Boyko\\Desktop\\Streams\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");
        int bytes = inputStream.read();
        Set<Character> punctuation = Set.of(',', '.', '!', '?');

       while (bytes != -1) {
           if (!punctuation.contains((char)bytes)) {
               outputStream.write((char)bytes);
           }
           bytes = inputStream.read();
       }
    }
}
