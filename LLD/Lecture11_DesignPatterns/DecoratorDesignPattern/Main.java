package Lecture11_DesignPatterns.DecoratorDesignPattern;

public class Main {
    public static void main(String[] args) {
        TextComponent t = new PlainText("hello word!");
        System.out.println(t.format());

        // <b> hello word! </b>
        TextComponent boldText = new BoldDecorator(t);
        System.out.println(boldText.format());

        TextComponent text = new ItalicDecorator(new BoldDecorator(new PlainText("Lets learn something")));
        TextComponent underlinedText = new UnderLineDecorator(text);
        System.out.println(text.format());
        System.out.println(underlinedText.format());
    }
}


