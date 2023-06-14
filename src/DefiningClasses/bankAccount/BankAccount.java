package DefiningClasses.bankAccount;

public class BankAccount {
    private static int bankAccount = 1;
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public BankAccount(){
       this.id = bankAccount++;
    }

    public int getId() {
       return this.id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
