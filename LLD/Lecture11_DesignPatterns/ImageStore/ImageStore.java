package Lecture11_DesignPatterns.ImageStore;

public class ImageStore {
    public void store(Compressor compressor,Filter filter,String img){
        compressor.compress(img);
        filter.apply(img);
        System.out.println("Storing the image");
    }
}
