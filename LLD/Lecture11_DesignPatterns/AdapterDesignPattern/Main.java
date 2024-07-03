package Lecture11_DesignPatterns.AdapterDesignPattern;

import Lecture11_DesignPatterns.AdapterDesignPattern.ThirdPartyLibrary.SpecialFilter;

public class Main {
    public static void main(String[] args) {
        Image img = new Image("dog.jpg");

        //Create Filters
        Filter bwFilter = new BlackAndWhiteFilter();
        bwFilter.apply(img);

        Filter vividFilter = new VividFilter();
        vividFilter.apply(img);

        Filter specialFilterAdapter = new SpecialFilterAdapter(new SpecialFilter());
        specialFilterAdapter.apply(img);
       // SpecialFilter specialFilter = new SpecialFilter();
       // specialFilter.applySpecialFilter(img);




    }
}
