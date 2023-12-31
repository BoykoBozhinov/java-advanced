package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P08InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Deque<String> numbersQueue = new ArrayDeque<>();
        Deque<String> operatorStack = new ArrayDeque<>();

        for (String symbol : input) {
            if (Character.isDigit(symbol.charAt(0)) || Character.isLetter(symbol.charAt(0))) {
                numbersQueue.offer(symbol);
            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(symbol);
                } else {
                    String lastOperator = operatorStack.peek();
                    switch (symbol) {
                        case "+":
                        case "-":
                            if (lastOperator.equals("(")) {
                                operatorStack.push(symbol);
                            } else {
                                numbersQueue.offer(operatorStack.pop());
                                operatorStack.push(symbol);
                            }
                            break;
                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                numbersQueue.offer(operatorStack.pop());
                                operatorStack.push(symbol);
                            } else {
                                operatorStack.push(symbol);
                            }
                            break;
                        case "(":
                            operatorStack.push(symbol);
                            break;
                        case ")":
                            while (!operatorStack.peek().equals("(")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            operatorStack.pop();
                            break;
                    }
                }
            }
        }

        while (!numbersQueue.isEmpty()) {
            System.out.print(numbersQueue.poll() + " ");
        }

        while (!operatorStack.isEmpty()) {
            System.out.print(operatorStack.pop() + " ");
        }
        System.out.println();
    }
}
