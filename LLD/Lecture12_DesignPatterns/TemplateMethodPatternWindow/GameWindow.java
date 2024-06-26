package Lecture11_DesignPatterns.TemplateMethodPatternWindow;

public class GameWindow extends Window{

    protected void beforeClose(){
        System.out.println("Destroying the players and enemy");
    }
    protected void afterClose() {
        System.out.println("Display the score in the new window");
    }
}
