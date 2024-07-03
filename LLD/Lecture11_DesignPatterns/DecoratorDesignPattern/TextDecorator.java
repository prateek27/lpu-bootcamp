package Lecture11_DesignPatterns.DecoratorDesignPattern;

public abstract class TextDecorator implements TextComponent{

    protected TextComponent text;

    public TextDecorator(TextComponent text){
        this.text = text;
    }

    @Override
    public String format() {
        return text.format();
    }
}
