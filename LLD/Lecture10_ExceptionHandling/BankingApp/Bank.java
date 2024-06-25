package Lecture10_ExceptionHandling.BankingApp;
import java.util.HashMap;
import java.util.Map;
public class Bank {
    private Map<String,Account> accounts;

    Bank(){
        accounts = new HashMap<>();
    }
    public void createAccount(Account account){
        accounts.put(account.getAccountNumber(),account);
        //logging
        TransactionLogger.logTransaction("Account " + account.getAccountNumber() + " created successfully");
    }
    public Account getAccount(String accountNumber){
        Account account = accounts.get(accountNumber);
        return account;
    }

}
