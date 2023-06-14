package IntroTesting;

import java.util.Scanner;

public class PrimeOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        if (number == 1) {
            System.out.println("not prime");
        }
        for (int i = 2; i < number;i++) {
            if (number % i == 0) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}
