package Lecture11_DesignPatterns.TextEditor;

public class EditorDemo {
    public static void main(String[] args) {
        Editor textEditor = new Editor();
        History history = new History();

        textEditor.setTitle("My Document 1");
        textEditor.setContent("Hello");
        history.save(textEditor.getState());

        textEditor.setTitle("My Document New");
        textEditor.setContent("Hello World");
        history.save(textEditor.getState());

        textEditor.restore(history.undo());

        System.out.println(textEditor);
    }
}
