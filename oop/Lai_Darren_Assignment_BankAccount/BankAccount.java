public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;

    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances

    // CONSTRUCTOR
    // Be sure to increment the number of accounts

    public BankAccount() {
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        accounts++;
    }

    // GETTERS
    // for checking, savings, accounts, and totalMoney

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void depositChecking(double number) {
        this.checkingBalance += number;
        totalMoney += number;
        System.out.printf("\nYour checking account balance is now $%.2f", this.checkingBalance);
    }
    public void depositSavings(double number) {
        this.savingsBalance += number;
        totalMoney += number;
        System.out.printf("\nYour savings account balance is now $%.2f", this.savingsBalance);
    }

    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney

    public void withdrawChecking(double number) {
        if (this.checkingBalance >= number) {
        this.checkingBalance -= number;
        totalMoney -= number;
        System.out.printf("\nYour checking account balance is now $%.2f", this.checkingBalance);
        }
        else System.out.println("\nYou do not have enough funds in your checking account for this withdrawal.");
    }

    public void withdrawSavings(double number) {
        if (this.savingsBalance >= number) {
        this.savingsBalance -= number;
        totalMoney -= number;
        System.out.printf("\nYour savings account balance is now $%.2f", this.checkingBalance);
        }
        else System.out.println("\nYou do not have enough funds in your savings account for this withdrawal.");
    }

    // getBalance
    // - display total balance for checking and savings of a particular bank account

    public void getBalance() {
        System.out.printf("\nYour total balance is $%.2f", this.checkingBalance + this.savingsBalance);
    }

    // static methods
    public static void getTotalAccounts() {
        System.out.printf("\nThere are %d accounts in total.", accounts);
    }

    public static void getTotalMoney() {
        System.out.printf("\nThere is a total of $%.2f in across all bank accounts", totalMoney);
    }
}
