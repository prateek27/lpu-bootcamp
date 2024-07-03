package Lecture11_DesignPatterns.AdapterDesignPattern;

import Lecture11_DesignPatterns.AdapterDesignPattern.ThirdPartyLibrary.SpecialFilter;

public class SpecialFilterAdapter implements Filter{
    private SpecialFilter specialFilter;
    public SpecialFilterAdapter(SpecialFilter specialFilter){
        this.specialFilter = specialFilter;
    }
    @Override
    public void apply(Image image) {
        specialFilter.applySpecialFilter(image);
    }
}
