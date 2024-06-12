package Lecture01_OOPS.PaymentSystem;

public class Test {

    public static void main(String[] args) {
        PaymentService ps = new PaymentService();
        ps.addPaymentMethod("PrateekICICI",new DebitCard("1101","Prateek Narang",12345));
        ps.addPaymentMethod("PrateekCreditCard",new CreditCard("1102","Prateek Narang"));
        ps.addPaymentMethod("prateek27UPI",new UPI("prateek27",123));
        //Polymorphism (One Method many form -> Run time polymorphsim)
        ps.makePayment("PrateekCreditCard");
        ps.makePayment("prateek27UPI");


    }
}
