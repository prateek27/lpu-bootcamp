package Lecture11_DesignPatterns.AdapterDesignPattern;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void apply(Image image) {
        System.out.println("Applying BW on "+image);
    }
}
