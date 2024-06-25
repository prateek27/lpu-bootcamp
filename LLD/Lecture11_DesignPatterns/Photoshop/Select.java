package Lecture11_DesignPatterns.Photoshop;

public class Select implements Tool{
    @Override
    public void onMouseClick() {
        System.out.println("Select Tool Selected");
    }

    @Override
    public void onMouseClickHold() {
        System.out.println("Selecting the canvas area");
    }
}
