package StreamsFilesAndDirectoriesEx;

import java.io.File;
import java.util.ArrayDeque;

public class P08GetFolderSize {
    public static void main(String[] args) {
        File folder = new File("Resources/Exercises Resources");
        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int sumOfBytes = 0;

        while (!directories.isEmpty()) {
            File currentFile = directories.poll();
            File[] files = currentFile.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    directories.offer(file);
                } else {
                    sumOfBytes += file.length();
                }
            }
        }
        System.out.println("Folder size:" + " " + sumOfBytes);
    }
}
