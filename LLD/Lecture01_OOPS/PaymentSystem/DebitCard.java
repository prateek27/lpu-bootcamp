package Lecture01_OOPS.PaymentSystem;

public class DebitCard extends Card implements PaymentMethod {
    int accountNo;
    public DebitCard(String no,String name,int accountNo){
        super(no,name);
        this.accountNo = accountNo;
    }

    @Override
    public void pay() {
        System.out.println("Paying via debit card from "+this.accountNo);
    }
}
