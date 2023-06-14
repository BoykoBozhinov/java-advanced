package StreamsFilesAndDirectories;

import java.io.File;

public class P08NestedFolders {
    public static void main(String[] args) {

        String directory = "C:\\Users\\Boyko\\Desktop\\Streams\\Files-and-Streams";

        File file = new File(directory);

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println(f.getName());
            }
            System.out.println(files.length + 1 +  " folders");
        }

    }
}
