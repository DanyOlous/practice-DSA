package app.BinaryTree;

/**
 * Created by DanyOlous on 29.08.2021.
 */
public final class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    TreeNode<E> root;

    public BinarySearchTree() {
        super();
        root = super.root;
    }

    public BinarySearchTree(E elt) {
        super(elt);
        root = super.root;
    }

    @Override
    public void insert(E elt) {
        insertMethod(root, elt);
    }
    private TreeNode<E> insertMethod(TreeNode<E> node, E elt) {
        if (node == null || empty())
            return new TreeNode<E>(elt);
        else if (elt.compareTo(node.data) < 0)
            node.left = insertMethod(node.left, elt);
        else
            node.right = insertMethod(node.right, elt);
        return node;
    }

    @Override
    public void remove(E elt) {
        delete(root, elt);
    }
    private TreeNode<E> delete(TreeNode<E> node, E elt) {
        if (node == null || empty())
            return node;
        if (elt.compareTo(node.data) < 0)
            node.left = delete(node.left, elt);
        else if (elt.compareTo(node.data) > 0)
            node.right = delete(node.right, elt);
        else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                node = minValue();
                node.right = delete(node.right, node.data);
                node = null;
        
            }
        }
        return node;
    }
    /*Node deleteRec(Node root, int key)
    {
        if (root == null)
            return root;
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }*/
 
    private TreeNode<E> minValue()
    {
        TreeNode<E> tmp = root;
        TreeNode<E> minValue = tmp;
        while (tmp.left != null)
        {
            minValue = tmp.left;
            tmp = tmp.left;
        }
        return minValue;
    }

    @Override
    public boolean contains(E elt) {
        return containsMethod(root, elt);
    }
    private boolean containsMethod(TreeNode<E> node, E elt) {
        if (node == null || empty())
            return false;
        else if (elt.compareTo(node.data) == 0)
            return true;
        else if (elt.compareTo(node.data) < 0)
            return containsMethod(node.left, elt);
        else
            return containsMethod(node.right, elt);
    }
}
