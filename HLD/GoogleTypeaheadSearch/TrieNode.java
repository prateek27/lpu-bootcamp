package Lecture12_HLD.GoogleTypeaheadSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TrieNode {
    char data;
    int frequency;
    List<String> topWords;
    Map<Character,TrieNode> children;
    boolean isTerminal;

    TrieNode(char data){
        this.data = data;
        this.frequency = 0;
        topWords = new LinkedList<>();
        children = new HashMap<>();
        isTerminal = false;
    }
}
