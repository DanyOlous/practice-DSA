package app.BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by DanyOlous on 29.08.2021.
 */
public class BinaryTree<T> implements IBinaryTree<T>, Iterable<TreeNode<T>> {
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

    public TreeNode<T> getNode() {
        return root;
    }

    @Override
    public void insert(T elt) {
        TreeNode<T> currTreeNode = root;
        if (currTreeNode == null || empty()) {
            root = new TreeNode<T>(elt);
            return;
        }
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.offer(currTreeNode);
        while (!queue.isEmpty()) {
            currTreeNode = queue.peek();
            queue.poll();
            if (currTreeNode.left == null) {
                currTreeNode.left = new TreeNode<T>(elt);
                break;
            }
            else
                queue.offer(currTreeNode.left);
            if (currTreeNode.right == null) {
                currTreeNode.right = new TreeNode<T>(elt);
                break;
            }
            else
                queue.offer(currTreeNode.right);
        }
    }
 
    @Override
    public void remove(T elt) {
        if (root == null)
            return;         
        if (root.left == null && root.right == null) {
            if (root.data == elt) {
                root=null;
                return;
            }
            else
                return;
        }
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.add(root);
        TreeNode<T> curNode = null;
        TreeNode<T> keyNode = null;
        while (!queue.isEmpty()) {
            curNode = queue.peek();
            queue.remove();         
            if (curNode.data == elt)
                keyNode = curNode; 
            if (curNode.left != null)
                queue.offer(curNode.left); 
            if (curNode.right != null)
                queue.offer(curNode.right);
        }
        if (keyNode != null) {
            T x = curNode.data;
            removeMethod(curNode);
            keyNode.data = x;
        }
    }
    public void removeMethod(TreeNode<T> node) {
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.offer(root);
        TreeNode<T> temp = null;
        while (!queue.isEmpty()) {
            temp = queue.peek();
            queue.remove();         
            if (temp == node) {
                temp = null;
                return;
            }
            if (temp.right!=null) {
                if (temp.right == node) {
                    temp.right = null;
                    return;
                }
                else
                    queue.offer(temp.right);
            }
            if (temp.left != null) {
                if (temp.left == node) {
                    temp.left = null;
                    return;
                }
                else
                    queue.offer(temp.left);
            }
        }
    }

    public boolean empty() {
        return root.data == null;
    }

    @Override
    public boolean contains(T elt) {
        TreeNode<T> currTreeNode = root;
        if (currTreeNode == null || empty())
            return false;
        Iterator<TreeNode<T>> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getData() == elt)
                return true;
        }
        return iterator.hasNext();
    }
    
    @Override
    public int height() {
        return heightMethod(root);
    }
    private int heightMethod(TreeNode<T> node) {
        if (node == null)
            return -1;
        else
            return 1 + Math.max(heightMethod(node.left), heightMethod(node.right));
    }

    @Override
    public int size() {
        return sizeMethod(root);
    }
    private int sizeMethod(TreeNode<T> node) {
        if (node == null || empty())
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

    @Override
    public String postOrder() {
        return postOrderMethod(root, new StringBuilder());
    }
    private String postOrderMethod(TreeNode<T> node, StringBuilder sb) {
        if (node == null || empty())
            return "";
        else {
            postOrderMethod(node.left, sb);
            postOrderMethod(node.right, sb);
            sb.append(node.data.toString() + " ");
            return sb.toString();
        }
    }

    @Override
    public String preOrder() {
        return preOrderMethod(root, new StringBuilder());
    }
    private String preOrderMethod(TreeNode<T> node, StringBuilder sb) {
        if (node == null ||empty())
            return "";
        else {
            sb.append(node.data.toString() + " ");
            preOrderMethod(node.left, sb);
            preOrderMethod(node.right, sb);
            return sb.toString();
        }
    }

    @Override
    public String inOrder() {
        return inOrderMethod(root, new StringBuilder());
    }
    private String inOrderMethod(TreeNode<T> node, StringBuilder sb) {
        if (node == null || empty())
            return "";
        else {
            inOrderMethod(node.left, sb);
            sb.append(node.data.toString() + " ");
            inOrderMethod(node.right, sb);
            return sb.toString();
        }
    }

    @Override
    public String levelOrder() {
        return levelOrderMethod(root);
    }
    private String levelOrderMethod(TreeNode<T> node) {
        if (empty())
            return "";
        else {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode<T>> q = new LinkedList<>();
            q.add(node);
            while (!q.isEmpty())
            {
                TreeNode<T> curTreeNode = q.poll();
                sb.append(curTreeNode.data.toString() + " ");
                if (curTreeNode.left != null)
                    q.offer(curTreeNode.left);
                if (curTreeNode.right != null)
                    q.offer(curTreeNode.right);
            }
            return sb.toString();
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
