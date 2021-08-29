package BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by DanyOlous on 29.08.2021.
 */
public class BinaryTree<T> implements Iterable<TreeNode<T>> {
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
        levelOrderMethod(root);
    }

    private void levelOrderMethod(TreeNode<T> node) {
        Queue<TreeNode<T>> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty())
        {
            TreeNode<T> curTreeNode = q.poll();
            if (curTreeNode.left != null)
                q.offer(curTreeNode.left);
            if (curTreeNode.right != null)
                q.offer(curTreeNode.right);
        }
    }

    @Override
    public Iterator<TreeNode<T>> iterator() {
        return new depthOrderIterator(root);
    }

    /*@Override
    public Iterator<TreeNode<T>> iterator() {
        return new breadthOrderIterator(root);
    }*/

    private class depthOrderIterator implements Iterator<TreeNode<T>> {
        Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();

        public depthOrderIterator(TreeNode<T> node) {
            stack.push(node);
        }

        @Override
        public boolean hasNext() {
            return !stack.empty();
        }

        @Override
        public TreeNode<T> next()
        {
            TreeNode<T> curTreeNode = stack.pop();
            if (curTreeNode.left != null)
                stack.push(curTreeNode.left);
            if (curTreeNode.right != null)
                stack.push(curTreeNode.right);
            return curTreeNode;
        }
    }

    private class breadthOrderIterator implements Iterator<TreeNode<T>> {
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();

        public breadthOrderIterator(TreeNode<T> node) {
            queue.offer(node);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public TreeNode<T> next() {
            TreeNode<T> curTreeNode = queue.poll();
            if (curTreeNode.left != null)
                queue.offer(curTreeNode);
            if (curTreeNode.right != null)
                queue.offer(curTreeNode);
            return curTreeNode;
        }
    }
}
