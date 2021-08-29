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
        //TreeNode<T> tmp = root;
        // use a queue

    }

    public void remove(T elt)
    {

    }

    // Call method with root
    public int height(TreeNode<T> node)
    {
        if (root == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
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
