package Lecture11_DesignPatterns.ImageStore;

public class BlackWhiteFilter implements Filter{

    @Override
    public void apply(String img) {
        System.out.println("Applying BW filter on " +img);
    }
}
