package StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class P08NestedFolders2 {
    public static void main(String[] args) {
        String path = "C:\\Users\\Boyko\\Desktop\\Streams";
        File root = new File(path);
        File[] files = root.listFiles();
        Deque<File> dirs = new ArrayDeque<>(Arrays.asList(files));
        int count = 0;
        while (!dirs.isEmpty()) {
            File currentFile = dirs.poll();

            if (currentFile.isDirectory()) {
                System.out.println(currentFile.getName());
                List<File> filesList = Arrays.asList(currentFile.listFiles());
                dirs.addAll(filesList);
                count++;
            }
        }
        System.out.println(count + " folders");
    }
}
