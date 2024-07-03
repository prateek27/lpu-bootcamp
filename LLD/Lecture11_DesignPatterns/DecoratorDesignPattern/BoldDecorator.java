package Lecture11_DesignPatterns.DecoratorDesignPattern;

import org.w3c.dom.Text;

public class BoldDecorator extends TextDecorator{
    public BoldDecorator(TextComponent text){
        super(text);
    }
    @Override
    public String format() {
        return "<b>"+ super.format()+ "</b>";
    }
}
