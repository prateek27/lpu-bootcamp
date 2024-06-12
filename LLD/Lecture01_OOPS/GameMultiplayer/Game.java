package Lecture01_OOPS.GameMultiplayer;

import Lecture01_OOPS.GameThreePlayer.Player;

import java.util.ArrayList;
import java.util.List;


public class Game {
    int machineGuess;
    List<Player> playerList;

    Game(List<String> names){
        playerList = new ArrayList<>();
        for(String name:names){
            playerList.add(new Player(name));
        }
    }

    private boolean checkWinner(){
       for(Player p:playerList){
           if(p.getGuess()==machineGuess){
               System.out.println(p.name + " Won");
               return true;
           }
       }
       return false;
    }

    void play(){
        while(true){
            machineGuess = (int)(Math.random()*9)+1;
            System.out.println("Machine guessed " + machineGuess);

            for(Player p:playerList){
                p.makeGuess();
            }

            if(checkWinner()){
                System.out.println("Game Over");
                break;
            }
        }
    }

}
