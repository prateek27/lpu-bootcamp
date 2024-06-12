package Lecture01_OOPS.GameThreePlayer;

public class Game {
    int machineGuess;
    Player p1, p2, p3;

    Game(String n1,String n2,String n3){
        p1 = new Player(n1);
        p2 = new Player(n2);
        p3 = new Player(n3);
    }

    private boolean checkWinner(){
        if(p1.getGuess()==machineGuess){
            System.out.println(p1.name + "won!");
            return true;
        }
        else if(p2.getGuess()==machineGuess){
            System.out.println(p2.name + "won!");
            return true;
        }
        else if(p3.getGuess()==machineGuess){
            System.out.println(p3.name + "won!");
            return true;
        }
        return false;
    }

    void play(){
        while(true){
            machineGuess = (int)(Math.random()*9)+1;
            System.out.println("Machine guessed " + machineGuess);

            p1.makeGuess();
            p2.makeGuess();
            p3.makeGuess();
            if(checkWinner()){
                System.out.println("Game Over");
                break;
            }
        }
    }

}
