package Lecture08_Generics;

import java.util.ArrayList;
import java.util.Iterator;

public class BrowserHistory implements Iterable {
    ArrayList<String> urls;

    BrowserHistory(){
        urls = new ArrayList<>();
    }
    void addUrl(String url){
        urls.add(url);
    }
    String getLastUrl(){
        return urls.get(urls.size()-1);
    }

    @Override
    public Iterator iterator() {
        return urls.iterator();
    }
}
