package Lecture11_DesignPatterns.ImageStore;

public class VividFilter implements Filter{

    @Override
    public void apply(String img) {
        System.out.println("Applying vivid on "+img);
    }
}
