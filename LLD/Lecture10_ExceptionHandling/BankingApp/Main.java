package Lecture10_ExceptionHandling.BankingApp;

public class Main {
    public static void main(String[] args) {
        Account a1 = new Account("1123","Amit",100);
        Account a2 = new Account("456","Rohan",200);

        Bank bank = new Bank();
        bank.createAccount(a1);
        bank.createAccount(a2);

        try {
            //concurrent execution
            a1.deposit(-50);
            a1.withdraw(20);
            a1.transfer(a2,10);

        } catch (InvalidTransactionException | InsufficientFundsException | AccountNotFoundException e) {
           //Log the Exceptions here
            TransactionLogger.logException(e);
        }
    }
}
