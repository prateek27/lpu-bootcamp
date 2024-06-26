package Lecture11_DesignPatterns.TemplateMethodPatternWindow;

abstract public class Window {
    public void close() {
        beforeClose();
        System.out.println("Removing the window from the screen");
        afterClose();
    }

    abstract protected void beforeClose();
    abstract protected void afterClose();

}