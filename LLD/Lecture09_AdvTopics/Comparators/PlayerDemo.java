package Lecture09_AdvTopics.Comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlayerDemo {
    public static void main(String[] args) {
        Player p1 = new Player("Shubham",3);
        Player p2 = new Player("Piyush",1);
        Player p3 = new Player("Rahul",7);

        //List of Players
        List<Player> l = new ArrayList<>();
        l.addAll(List.of(p1,p2,p3));
        //List of Strings
        List<String> ls = new ArrayList<>(List.of("Appleeeee","Mangoi","Guava"));

        ////Sorting according to  compareToMethod of Player class
        Collections.sort(l);

        // Sorting according to PlayerName Comparator (External)
        Collections.sort(l,new PlayerNameComparator());
        Collections.sort(l,new PlayerRankComparator());

        // Lambda Expressions
        // ( a,b)->{body;}
        Collections.sort(l,(a,b)->a.rank - b.rank);
        Collections.sort(l,(a,b)->b.name.compareTo(a.name));
        Collections.sort(l,Comparator.comparingInt(Player::getRank));



        //Sorting according to inbuilt compareToMethod of String class
        Collections.sort(ls, new StringLenComparator());
        Collections.sort(ls,(a,b)->a.length()-b.length());
        //Sorting using
        Collections.sort(ls, Comparator.comparingInt(String::length));



        // Create a Comparator to sort string according to length, if the lenth is same, you compare the string acc to dictionary order


        System.out.println(ls);
        System.out.println(l);

    }
}
