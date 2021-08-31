package app.Trie;

import java.util.Dictionary;

public class TrieNode {
    Dictionary<Character, TrieNode> children;
    char value;
    boolean isWord;
    int frequency;

    public TrieNode(char value) {
        this.value = value;
        isWord = false;
        frequency = 1;
    }

    public char getValue() {
        return value;
    }

    public boolean getIsWord() {
        return isWord;
    }

    public void setIsWord() {
        isWord = true;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency() {
        frequency++;
    }

    public Dictionary<Character, TrieNode> getChildren() {
        return this.children;
    }
}
