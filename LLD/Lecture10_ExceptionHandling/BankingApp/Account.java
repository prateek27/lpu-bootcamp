package Lecture10_ExceptionHandling.BankingApp;

public class Account {
    private String accountNumber;
    private double balance;
    private String accountHolderName;

    public Account(String accountNumber,String accountHolderName,double initBalance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initBalance;
    }

    public synchronized void deposit(double amount) throws InvalidTransactionException {
        if(amount<=0){
          throw new InvalidTransactionException("Deposit amount should be positive!");
        }
        balance += amount;
        //Log this as well
        TransactionLogger.logTransaction("Deposit of "+amount+" was successful to this " + accountNumber);

    }
    public synchronized void withdraw(double amount) throws InsufficientFundsException {
        if(balance<amount){
            throw new InsufficientFundsException("Insufficients funds") ; //insufficient exception
        }
        balance -= amount;
        //log this transaction
        TransactionLogger.logTransaction("Withdraw of "+amount+" was successful from this " + accountNumber);


    }
    public synchronized void transfer(Account destAccount,double amount) throws AccountNotFoundException, InsufficientFundsException, InvalidTransactionException {
        if(destAccount==null){
            throw new AccountNotFoundException("Account No is NULL");
        }
        if(amount>balance){
            throw new InsufficientFundsException("Account balance too low!");
        }
        withdraw(amount); //it can also throw an insufficient funds
        destAccount.deposit(amount);
        //log this transaction later
        TransactionLogger.logTransaction("Transfer of "+amount+" was successful  from " + accountNumber + "to "+ destAccount.getAccountNumber());
    }

    public String getAccountNumber(){
        return accountNumber;
    }

}
