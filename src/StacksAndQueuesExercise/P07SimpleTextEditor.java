package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        Deque<String> deque = new ArrayDeque<>();
        String text = "";
        while (number-- > 0) {
            String[] commandData = scanner.nextLine().split("\\s+");
            int command = Integer.parseInt(commandData[0]);

            switch (command) {
                case 1:
                    String toAppend = commandData[1];
                    deque.push(text);
                    text += toAppend;
                    break;
                case 2:
                    deque.push(text);
                    int count = Integer.parseInt(commandData[1]);
                    text = text.substring(0, text.length() - count);
                    break;
                case 3:
                    int index = Integer.parseInt(commandData[1]);
                    System.out.println(text.charAt(index - 1));
                    break;
                case 4:
                    text = deque.pop();
                    break;
            }
        }
    }
}
