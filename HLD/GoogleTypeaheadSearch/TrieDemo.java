package Lecture12_HLD.GoogleTypeaheadSearch;

public class TrieDemo {
    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        t.insert("appy");
        t.insert("apple");
        t.insert("apple");
        t.insert("app");
        t.insert("app");
        t.insert("app");
        t.insert("apples");
        t.insert("apples");
        t.insert("apples");
        t.insert("apples");
        t.insert("apps");
        t.insert("bat");
        t.insert("batman");

        System.out.println(t.suggest("b"));

    }
}
