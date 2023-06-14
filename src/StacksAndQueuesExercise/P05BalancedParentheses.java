package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String parentheses = scanner.nextLine();
        boolean isBalanced = true;
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char currentSymbol = parentheses.charAt(i);

            if (currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '[') {
                openingBrackets.push(currentSymbol);
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpeningBracket = openingBrackets.pop();
                if (currentSymbol == '}' && lastOpeningBracket != '{') {
                    isBalanced = false;
                    break;
                } else if (currentSymbol == ')' && lastOpeningBracket != '(') {
                    isBalanced = false;
                    break;
                } else if (currentSymbol == ']' && lastOpeningBracket != '[') {
                    isBalanced = false;
                    break;
                }
            }

        }
        if (isBalanced && openingBrackets.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
