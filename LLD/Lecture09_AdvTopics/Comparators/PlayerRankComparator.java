package Lecture09_AdvTopics.Comparators;

import java.util.Comparator;

public class PlayerRankComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Player p1 = (Player)o1;
        Player p2 = (Player)o2;
        return p1.rank - p2.rank;
    }
}
