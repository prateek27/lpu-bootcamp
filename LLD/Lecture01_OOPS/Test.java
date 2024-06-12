package Lecture01_OOPS;

import Lecture01_OOPS.GameThreePlayer.Player;

public class Test {
    public static void main(String[] args) {
        Player p1 = new Player("rahul");
        Player p2 = new Player("amit");

        p1.makeGuess();
        System.out.println(p1);

    }
}
