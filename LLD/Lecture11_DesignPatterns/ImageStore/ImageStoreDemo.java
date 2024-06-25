package Lecture11_DesignPatterns.ImageStore;

public class ImageStoreDemo {
    public static void main(String[] args) {
        ImageStore store = new ImageStore();
        store.store(new JPEGCompressor(),new BlackWhiteFilter(),"dogimg");
        store.store(new PNGCompressor(),new VividFilter(),"catimg");

    }
}
