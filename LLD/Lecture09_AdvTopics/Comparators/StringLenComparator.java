package Lecture09_AdvTopics.Comparators;

import java.util.Comparator;

public class StringLenComparator implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String)o1;
        String s2 = (String)o2;
        if(s1.length()==s2.length()){
            return s1.compareTo(s2);
        }
        return s1.length() - s2.length();
    }
}
