package Lecture11_DesignPatterns.ProductCollection;

import java.util.Iterator;

public class ProductCollectionDemo {
    public static void main(String[] args) {
        ProductCollection ps = new ProductCollection();
        ps.add(new Product(1,"Apple"));
        ps.add(new Product(2,"Mango"));
        ps.add(new Product(3,"Guava"));

        //wants to iterate over the products
        Iterator it = ps.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        //you can support for each loop
        for(Object p:ps){
            System.out.println(p);
        }

    }
}
