package Lecture08_Generics;

import java.util.Iterator;

public class BrowserHistoryArrayDemo {
    public static void main(String[] args) {
        BrowserHistoryArray h = new BrowserHistoryArray();
        h.addUrl("google.com");
        h.addUrl("fliplkart.com");
        h.addUrl("amazon.com");

        Iterator it =  h.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for(Object url:h){
            System.out.println(url);
        }







        }
}
