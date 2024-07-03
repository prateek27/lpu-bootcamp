package Lecture11_DesignPatterns.TemplateMethodPatternWindow;

public class AppWindow extends Window{
    @Override
    protected void beforeClose() {
        System.out.println("Destroying app data");
    }

    @Override
    protected void afterClose() {
        System.out.println("Clearing out memory resources");
    }
}
