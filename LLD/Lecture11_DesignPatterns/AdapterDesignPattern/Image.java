package Lecture11_DesignPatterns.AdapterDesignPattern;

public class Image {
    private String name;

    public Image(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}
