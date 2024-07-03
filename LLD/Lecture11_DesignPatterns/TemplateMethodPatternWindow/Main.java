package Lecture11_DesignPatterns.TemplateMethodPatternWindow;

public class Main {
    public static void main(String[] args) {
        GameWindow gw = new GameWindow();
        gw.close();

        AppWindow aw = new AppWindow();
        aw.close();
    }
}
