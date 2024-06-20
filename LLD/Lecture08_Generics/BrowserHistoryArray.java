package Lecture08_Generics;

import java.util.Iterator;

public class BrowserHistoryArray implements Iterable {
    String[] urls;
    int idx;

    BrowserHistoryArray(){
        urls = new String[10];
        idx = 0;
    }
    public void addUrl(String url){
        urls[idx] = url;
        idx++;
    }
    public String getLastUrl(){
        return urls[idx-1];
    }


    @Override
    public Iterator iterator() {
        return new ArrayIterator(urls);
    }

    // -- nested class --
    private class ArrayIterator implements Iterator{
        int i;
        String[] urls;

        ArrayIterator(String[] urls){
            this.urls = urls;
            i = 0;
        }

        @Override
        public boolean hasNext() {
           if(i<urls.length){
               return true;
           }
           return false;
        }

        @Override
        public Object next() {
            return urls[i++];
        }
    }
}
