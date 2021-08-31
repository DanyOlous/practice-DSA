package app.Trie;

import java.util.ArrayList;
import java.util.Stack;

public class Trie implements ITrie{

    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }
    public void insert(String str) {
        TrieNode tmp = root;
        if (findWord(str))
            return;
        for(int i = 0; i < str.length(); i++) {
            if (tmp.getChildren().get(str.charAt(i)) != null)
                tmp.addFrequency();
            else
                tmp.getChildren().put(str.charAt(i), new TrieNode(str.charAt(i)));
            tmp = tmp.getChildren().get(str.charAt(i));
        }
        tmp.setIsWord();
    }

    public void remove(String str) {
        if (!findWord(str))
            return;
        TrieNode tmp = root;
        for (int i = 0; i < str.length(); i++) {
            tmp.reduceFrequency();
            tmp = tmp.getChildren().get(str.charAt(i));
        }
        tmp.unsetIsWord();
    }

    public boolean findWord(String str) {
        TrieNode tmp = root;
        for (int i = 0; i < str.length(); i++) {
            if (tmp.getChildren().get(str.charAt(i)) != null)
                tmp = tmp.getChildren().get(str.charAt(i));
            else
                return false;
        }
        return tmp.getIsWord();
    }

    public boolean find(String str) {
        TrieNode tmp = root;
        for (int i = 0; i < str.length(); i++) {
            if (tmp.getChildren().get(str.charAt(i)) != null) {
                tmp.reduceFrequency();
                tmp = tmp.getChildren().get(str.charAt(i));
            }
            else
                return false;
        }
        return true;
    }

    public int countSuffix(String str) { 
        if (!find(str))
            return 0;
        TrieNode tmp = root;
        for (int i = 0; i < str.length(); i++) {
            tmp.reduceFrequency();
            tmp = tmp.getChildren().get(str.charAt(i));
        }
        return tmp.getFrequency();
    }

    public ArrayList<String> suffix(String str) {
        ArrayList<String> wordList = new ArrayList<String>();
        if (!find(str))
            return wordList;
        TrieNode tmp = root;
        for (int i = 0; i < str.length(); i++) {
            tmp.reduceFrequency();
            tmp = tmp.getChildren().get(str.charAt(i));
        }
        stack<TrieNode> s = new Stack<TrieNode>();
        return wordList;
    }
}