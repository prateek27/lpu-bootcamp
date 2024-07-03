package Lecture11_DesignPatterns.AdapterDesignPattern.ThirdPartyLibrary;

import Lecture11_DesignPatterns.AdapterDesignPattern.Image;

public class SpecialFilter {
    public void applySpecialFilter(Image img){
        System.out.println("Applying Special Filter on "+img);
    }
}
