package BinaryTree;

public class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode()
    {
        data = null;
        left = null;
        right = null;
    }

    public TreeNode(T elt)
    {
        data = elt;
        left = null;
        right = null;
    }

    public TreeNode(T elt, TreeNode<T> left, TreeNode<T> right)
    {
        data = elt;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString()
    {
        return "";
    }
}
