public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        account1.depositChecking(350.40);
        account1.depositSavings(520.09);
        account2.depositChecking(49);
        account2.depositSavings(105.2);

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        account1.withdrawChecking(9999.99);
        account1.withdrawChecking(99.99);
        account2.withdrawChecking(10);
        account2.withdrawSavings(44.10);

        // Static Test (print the number of bank accounts and the totalMoney)
        BankAccount.getTotalAccounts();
        BankAccount.getTotalMoney();
    }
}
