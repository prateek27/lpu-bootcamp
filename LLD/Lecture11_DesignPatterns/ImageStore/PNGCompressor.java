package Lecture11_DesignPatterns.ImageStore;

public class PNGCompressor implements Compressor{
    @Override
    public void compress(String img) {
        System.out.println(img + "Compressed using PNG compression");
    }
}
