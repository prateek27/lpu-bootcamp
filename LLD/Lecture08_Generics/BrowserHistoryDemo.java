package Lecture08_Generics;

public class BrowserHistoryDemo {
    public static void main(String[] args) {
        BrowserHistory h = new BrowserHistory();
        h.addUrl("google.com");
        h.addUrl("fliplkart.com");
        h.addUrl("amazon.com");

        for(Object url:h){
            System.out.println(url);
        }
    }
}
