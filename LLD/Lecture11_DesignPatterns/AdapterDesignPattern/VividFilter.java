package Lecture11_DesignPatterns.AdapterDesignPattern;

public class VividFilter implements Filter{

    @Override
    public void apply(Image image) {
        System.out.println("Vivid applied on "+image);
    }
}
