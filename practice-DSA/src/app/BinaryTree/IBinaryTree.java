package app.BinaryTree;

public interface IBinaryTree<T> {
    
    public void insert(T elt);
    public void remove(T elt);
    public boolean contains(T elt);
    public int height();
    public int size();
    public String postOrder();
    public String preOrder();
    public String inOrder();
    public String levelOrder();   
}
