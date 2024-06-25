package Lecture11_DesignPatterns.Photoshop;

public class Canvas {
    Tool tool;

    void setTool(Tool t){
        this.tool = t;
    }

    void onClick(){
        tool.onMouseClick();
    }
    void onClickAndHold(){
        tool.onMouseClickHold();
    }
}
