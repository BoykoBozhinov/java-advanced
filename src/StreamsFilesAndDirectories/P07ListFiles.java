package StreamsFilesAndDirectories;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\Boyko\\Desktop\\Streams\\Files-and-Streams";
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f:files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n",
                                f.getName(), f.length());
                    }
                }
            }
        }
    }
}
