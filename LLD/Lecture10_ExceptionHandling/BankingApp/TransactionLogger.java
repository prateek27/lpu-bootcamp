package Lecture10_ExceptionHandling.BankingApp;

import java.util.logging.Logger;

public class TransactionLogger {
    private static final Logger logger = Logger.getLogger(TransactionLogger.class.getName());

    public static void logTransaction(String message){
        logger.info(message);
    }

    public static void logException(Exception e){
        logger.severe("Exception " + e.getMessage());
    }
}
