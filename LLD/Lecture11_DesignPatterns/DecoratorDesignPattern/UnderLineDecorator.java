package Lecture11_DesignPatterns.DecoratorDesignPattern;

import org.w3c.dom.Text;

public class UnderLineDecorator extends TextDecorator {
    public UnderLineDecorator(TextComponent text){
        super(text);
    }
    @Override
    public String format() {
        return "<u>"+ super.format()+ "</u>";
    }
}
