package BinaryTree;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by DanyOlous on 29.08.2021.
 */
public class BinaryTree<T> {
    TreeNode<T> root;

    public BinaryTree() {
        root = new TreeNode<T>();
    }

    public BinaryTree(T elt) {
        root = new TreeNode<T>(elt);
    }

    public BinaryTree(T elt, T left, T right) {
        root = new TreeNode<T>(elt);
        root.left = new TreeNode<T>(left);
        root.right = new TreeNode<T>(right);
    }

    public BinaryTree(T elt, TreeNode<T> left, TreeNode<T> right) {
        root = new TreeNode<T>(elt);
        root.left = left;
        root.right = right;
    }

    public void insert(T elt) {
        //TreeNode<T> tmp = root;
        // use a queue
    }

    public void remove(T elt) {
        // use iterator
    }

    public boolean empty() {
        return root == null;
    }

    public boolean contains(T elt) {
        if (empty())
            return false;
        // use iterator
        return false;
    }
    
    public int height() {
        return heightMethod(root);
    }

    private int heightMethod(TreeNode<T> node) {
        if (root == null)
            return -1;
        return 1 + Math.max(heightMethod(node.left), heightMethod(node.right));
    }

    public int size() {
        return sizeMethod(root);
    }

    private int sizeMethod(TreeNode<T> node) {
        if (empty())
            return 0;
        return (1 + sizeMethod(node.left) + sizeMethod(node.right));
    }

    /*public boolean isBinarySearchTree() {
        return isBinarySearchTreeMethod(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTreeMethod(TreeNode<T> node, int min, int max) {
        if (empty())
            return true;
        else {
            
            return true;
        }
    }*/

    // use iterators
    public void postOrder() {
        postOrderMethod(root);
    }

    private void postOrderMethod(TreeNode<T> node) {
        if (empty())
            return;
        else {
            postOrderMethod(node.left);
            postOrderMethod(node.right);
            System.out.println(node.data + " ");
        }
    }

    public void preOrder() {
        preOrderMethod(root);
    }

    private void preOrderMethod(TreeNode<T> node) {
        if (empty())
            return;
        else {
            System.out.println(node.data + " ");
            preOrderMethod(node.left);
            preOrderMethod(node.right);
        }
    }

    public void inOrder() {
        inOrderMethod(root);
    }

    private void inOrderMethod(TreeNode<T> node) {
        if (empty())
            return;
        else {
            inOrderMethod(node.left);
            System.out.println(node.data + " ");
            inOrderMethod(node.right);
        }
    }

    // use a Queue
    public void levelOrder() {

    }

    private class PostOrder implements Iterator<TreeNode<T>> {
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
        @Override
        public boolean hasNext()
        {

        }

        @Override
        public TreeNode<T> next()
        {

        }
    }

    private class PreOrder implements Iterator<TreeNode<T>> {
        @Override
        public boolean hasNext()
        {

        }

        @Override
        public TreeNode<T> next()
        {

        }
    }

    private class InOrder implements Iterator<TreeNode<T>> {
        @Override
        public boolean hasNext()
        {

        }

        @Override
        public TreeNode<T> next()
        {

        }
    }

    private class LevelOrder implements Iterator<TreeNode<T>> {
        @Override
        public boolean hasNext()
        {

        }

        @Override
        public TreeNode<T> next()
        {

        }
    }
}
