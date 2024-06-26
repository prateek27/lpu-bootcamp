package Lecture11_DesignPatterns.CommandPattern.framework;

public class Button {
    private String label;

    public void onClick(Command c){
        c.execute();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
