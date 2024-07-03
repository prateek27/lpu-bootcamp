package Lecture11_DesignPatterns.DecoratorDesignPattern;

public class ItalicDecorator extends TextDecorator{
        public ItalicDecorator(TextComponent text){
            super(text);
        }
        @Override
        public String format() {
            return "<I>"+ super.format()+ "</I>";
        }
}
