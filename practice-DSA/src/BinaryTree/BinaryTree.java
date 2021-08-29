package BinaryTree;

public class BinaryTree<T> {
    TreeNode<T> root;

    public BinaryTree()
    {
        root = new TreeNode<T>();
    }

    public BinaryTree(T elt)
    {
        root = new TreeNode<T>(elt);
    }

    public BinaryTree(T elt, T left, T right)
    {
        root = new TreeNode<T>(elt);
        root.left = new TreeNode<T>(left);
        root.right = new TreeNode<T>(right);
    }

    public BinaryTree(T elt, TreeNode<T> left, TreeNode<T> right)
    {
        root = new TreeNode<T>(elt);
        root.left = left;
        root.right = right;
    }

    //public BinaryTree(T elt, BinaryTree right)

    public void insert(T elt)
    {

    }

    public void remove(T elt)
    {

    }

    public int height()
    {
        return 0;
    }

    public void postOrder()
    {

    }

    public void preOrder()
    {

    }

    public void inOrder()
    {

    }

    public void levelOrder()
    {

    }
}
