package Lecture11_DesignPatterns.TextEditor;

public class Editor {
    private String content;
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    EditorState getState(){
        EditorState editorState = new EditorState(content,title);
        return editorState;
    }

    void restore(EditorState state){
        this.content = state.content;
        this.title = state.title;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
