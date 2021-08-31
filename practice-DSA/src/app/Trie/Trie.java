package app.Trie;

public class Trie implements ITrie{

    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }
    public void insert(String str) {
        TrieNode tmp = root;
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
        TrieNode tmp = root;
        for (int i = 0; i < str.length(); i++) {
            if (tmp.getChildren().get(str.charAt(i)) != null)
                tmp.reduceFrequency();
            else
                tmp.getChildren().put(str.charAt(i), new TrieNode(str.charAt(i)));
            tmp = tmp.getChildren().get(str.charAt(i));
        }
        tmp.unsetIsWord();
    }

    public boolean find(String string) {
        return false;
    }
}
