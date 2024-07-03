package Lecture11_DesignPatterns.DecoratorDesignPattern;

public class PlainText implements TextComponent{
    private String text;

    PlainText(String text){
        this.text = text;
    }

    @Override
    public String format() {
        return text;
    }
}
