package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;


public class P01ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\Boyko\\Desktop\\Streams\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
           int bytes = fileInputStream.read();

           while (bytes != -1) {
                   System.out.printf("%s", Integer.toBinaryString(bytes) + " ");

               bytes = fileInputStream.read();
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
