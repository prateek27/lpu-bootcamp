package Lecture12_HLD.GoogleTypeaheadSearch;

import java.util.List;

public class Trie {
    private TrieNode root;

    //insert the word if not present
    // inc the freq if already present
    Trie(){
        root = new TrieNode('-');
    }
    private void updateTopWords(TrieNode root,String word){
        //todo
        //  t a i lo r
        TrieNode temp = root;
        for(char ch: word.toCharArray()){
            temp = temp.children.get(ch);
            //contains the word or doesnt contains
            if(!temp.topWords.contains(word)){
                temp.topWords.add(word);
            }
            //Sort
            temp.topWords.sort((w1,w2)->getFreq(w2) - getFreq(w1));;
            if(temp.topWords.size()>3){
                temp.topWords.remove(temp.topWords.size()-1);
            }
        }
    }
    private int getFreq(String word){
        TrieNode temp = root;
        for(char ch:word.toCharArray()){
            temp = temp.children.get(ch);
            if(temp==null){
                return 0;
            }
        }
        return temp.frequency;
    }


    public void insert(String word){
        TrieNode temp = root;
        for(char ch:word.toCharArray()){
            temp.children.putIfAbsent(ch,new TrieNode(ch));
            temp = temp.children.get(ch);
        }
        temp.isTerminal = true;
        temp.frequency++;
        updateTopWords(root,word);
    }
    List<String> suggest(String prefix){
        TrieNode temp = root;
        for(char ch:prefix.toCharArray()){
            temp = temp.children.get(ch);
        }
        return temp.topWords;
    }
}
