package Lecture01_OOPS.GameMultiplayer;

import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {

        List<String> playerNames = new ArrayList<>();
        playerNames.add("Rahul");
        playerNames.add("Amit");
        playerNames.add("Neha");
        playerNames.add("Rohan");
        playerNames.add("Nikita");
        Game g = new Game(playerNames);
        g.play();
    }
}
