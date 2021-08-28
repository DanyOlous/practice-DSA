package BinaryTree;

public class BinaryTree<T> {
    TreeNode<T> root;

    public BinaryTree()
    {

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
         = left;
    }

    //public BinaryTree(T elt, BinaryTree right)

    public void add(T elt)
    {

    }

    public void delete(T elt)
    {

    }
}
