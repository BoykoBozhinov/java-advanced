package IntroTesting;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StacksAndQueues {
    public static void main(String[] args) {

        ArrayDeque<Integer> myStack = new ArrayDeque<>();

        myStack.push(42);
        myStack.push(67);
        myStack.push(46);
        myStack.push(33);

        System.out.println(myStack);

        myStack.poll();

        System.out.println(myStack);
    }
}
