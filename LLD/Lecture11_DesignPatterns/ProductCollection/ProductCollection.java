package Lecture11_DesignPatterns.ProductCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ProductCollection implements Iterable{
    private TreeSet<Product> products = new TreeSet<>();

    public void add(Product product) {
        products.add(product);
    }
    public TreeSet<Product> getProducts(){
        return products;
    }

    @Override
    public Iterator iterator() {
        return products.iterator();
    }

}