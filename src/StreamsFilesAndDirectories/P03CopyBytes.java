package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Set;

public class P03CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Boyko\\Desktop\\Streams\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("outputBytes.txt");
        PrintWriter printer = new PrintWriter(outputStream);
        int oneByte = inputStream.read();

        while (oneByte != -1) {
            String digits = String.valueOf(oneByte);
            for (int i = 0; i < digits.length(); i++) {
                if (oneByte == 32) {
                    System.out.print(" ");
                    break;
                } else if (oneByte == 10) {
                    System.out.println();
                    break;
                } else {
                    System.out.print(digits.charAt(i));
                }
            }
            oneByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
