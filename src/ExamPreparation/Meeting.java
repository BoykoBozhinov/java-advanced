package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(malesStack::push);

        ArrayDeque<Integer> femalesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int matchesCount = 0;

        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int maleValue = malesStack.peek();
            int femaleValue = femalesQueue.peek();

            if (maleValue <= 0) {
                malesStack.pop();
                continue;
            } else if (femaleValue <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (maleValue % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            } else if (femaleValue % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }

            if (maleValue == femaleValue) {
                matchesCount++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                malesStack.pop();
                maleValue -= 2;
                malesStack.push(maleValue);
            }
        }
        System.out.printf("Matches: %d%n", matchesCount);

        if (!malesStack.isEmpty()) {
            System.out.print("Males left: ");
            System.out.println(malesStack.toString().replace("[", "").replace("]", ""));
        } else {
            System.out.println("Males left: none");
        }

        if (!femalesQueue.isEmpty()) {
            System.out.print("Females left: ");
            System.out.println(femalesQueue.toString().replace("[", "").replace("]", ""));
        } else {
            System.out.println("Females left: none");
        }
    }
}
