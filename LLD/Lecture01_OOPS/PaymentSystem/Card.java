package Lecture01_OOPS.PaymentSystem;

public class Card {
    protected String cardNo;
    protected String userName;

    public Card(String no,String name){
        cardNo = no;
        userName = name;
    }
    public String getCardNo(){
        return cardNo;
    }
    public String getUserName(){
        return userName;
    }
}
