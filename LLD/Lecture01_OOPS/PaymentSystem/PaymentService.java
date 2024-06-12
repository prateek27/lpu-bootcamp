package Lecture01_OOPS.PaymentSystem;

import java.util.HashMap;

public class PaymentService {
    //hashmap to store multiple cards and UPI handle objects
    HashMap<String,PaymentMethod> paymentMethods;

    PaymentService(){
        paymentMethods = new HashMap<>();
    }
    public void addPaymentMethod(String name,PaymentMethod pm){
        paymentMethods.put(name,pm);
    }

    public void makePayment(String name){
        PaymentMethod pm = paymentMethods.get(name);
        pm.pay();
    }
}


