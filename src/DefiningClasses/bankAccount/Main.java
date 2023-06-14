package DefiningClasses.bankAccount;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Integer, BankAccount> bank = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] commandData = input.split("\\s+");
            String command = commandData[0];

            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    bank.putIfAbsent(bankAccount.getId(), bankAccount);
                    System.out.printf("Account ID%d created%n", bankAccount.getId());
                    break;
                case "Deposit":
                    int accountID = Integer.parseInt(commandData[1]);
                    int amount = Integer.parseInt(commandData[2]);

                    if (!bank.containsKey(accountID)) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount currentBankAccount = bank.get(accountID);
                        currentBankAccount.deposit(amount);
                        System.out.printf("Deposited %d to ID%d%n", amount, currentBankAccount.getId());
                    }
                    break;
                case "GetInterest":
                    int accountId = Integer.parseInt(commandData[1]);
                    int period = Integer.parseInt(commandData[2]);

                    if (!bank.containsKey(accountId)) {
                        System.out.println("Account does not exist");
                    } else {
                        BankAccount mapAccount = bank.get(accountId);
                        System.out.printf("%.2f%n", mapAccount.getInterestRate(period));
                    }
                    break;
                case "SetInterest":
                    double rate = Double.parseDouble(commandData[1]);
                    BankAccount.setInterestRate(rate);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
