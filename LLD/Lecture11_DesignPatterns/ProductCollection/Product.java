package Lecture11_DesignPatterns.ProductCollection;

public class Product implements Comparable{
    private int id;
    private String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String   toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Product p2 = (Product)o;
        return name.compareTo(p2.name);
    }
}