package Lecture11_DesignPatterns.TemplateMethodPattern;

public class TransferMoneyTask extends Task{

    @Override
    protected void perform(){
        //business logic
        System.out.println("Transfering money");
    }
}
