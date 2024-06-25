package Lecture11_DesignPatterns.TextEditor;

import java.util.Stack;

public class History {
    Stack<EditorState> stack;

    History(){
        stack = new Stack<>();
    }
    void save(EditorState state){
        stack.push(state);
    }
    EditorState undo(){
        stack.pop();
        return stack.peek();
    }

}
