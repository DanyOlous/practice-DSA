package BinaryTree;

/**
 * Created by DanyOlous on 29.08.2021.
 */
public final class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    TreeNode<E> root;

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(E elt) {
        super(elt);
    }

    @Override
    public void insert(E elt) {
        insertMethod(root, elt);
    }

    private void insertMethod(TreeNode<E> node, E elt) {
        if (empty())
            node = new TreeNode<E>(elt);
        else if (elt.compareTo(node.data) < 0)
            insertMethod(node.left, elt);
        else
            insertMethod(node.right, elt);
    }

    @Override
    public boolean contains(E elt) {
        return containsMethod(root, elt);
    }

    private boolean containsMethod(TreeNode<E> node, E elt) {
        if (empty())
            return false;
        else if (elt.compareTo(node.data) < 0)
            return true;
        else if (elt.compareTo(node.data) < 0)
            return containsMethod(node.left, elt);
        else
            return containsMethod(node.right, elt);
    }
}
