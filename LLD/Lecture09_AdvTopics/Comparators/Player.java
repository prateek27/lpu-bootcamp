package Lecture09_AdvTopics.Comparators;

public class Player implements Comparable{
    String name;
    int rank;



    Player(String name,int rank){
        this.name = name;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }

    public int getRank(){
        return rank;
    }

    @Override
    public int compareTo(Object o) {
        Player p2 = (Player)o;
        return this.rank - p2.rank;
    }
}
