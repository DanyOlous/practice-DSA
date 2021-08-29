package test.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;
import app.BinaryTree.TreeNode;

public class TreeNodeTest {

    @Test
    public void createNode() {
        TreeNode<Integer> treeNode = new TreeNode<>();
        assertEquals(null, treeNode.getData());
        assertEquals(null, treeNode.getLeft());
        assertEquals(null, treeNode.getRight());
    }
    @Test
    public void createNode1() {
        TreeNode<Integer> treeNode = new TreeNode<>(7);
        assertEquals(7, treeNode.getData());
        assertEquals(null, treeNode.getLeft());
        assertEquals(null, treeNode.getRight());
    }
    @Test
    public void createNode2() {
        TreeNode<String> treeNode = new TreeNode<>("TreeNode");
        assertEquals("TreeNode", treeNode.getData());
        assertEquals(null, treeNode.getLeft());
        assertEquals(null, treeNode.getRight());
    }
    @Test
    public void createNode3() {
        TreeNode<Character> treeNode = new TreeNode<>('D');
        assertEquals('D', treeNode.getData());
        assertEquals(null, treeNode.getLeft());
        assertEquals(null, treeNode.getRight());
    }
    @Test
    public void createNode4() {
        TreeNode<Integer> leftLeft = new TreeNode<>(11);
        TreeNode<Integer> leftRight = new TreeNode<>(22);
        TreeNode<Integer> rightLeft = new TreeNode<>(88);
        TreeNode<Integer> rightRight = new TreeNode<>(99);

        TreeNode<Integer> left = new TreeNode<>(1, leftLeft, leftRight);
        TreeNode<Integer> right = new TreeNode<>(9, rightLeft, rightRight);
        TreeNode<Integer> root = new TreeNode<>(9809, left, right);

        assertEquals(9809, root.getData());
        assertEquals(1, root.getLeft().getData());
        assertEquals(9, root.getRight().getData());

        assertEquals(11, root.getLeft().getLeft().getData());
        assertEquals(22, root.getLeft().getRight().getData());
        assertEquals(88, root.getRight().getLeft().getData());
        assertEquals(99, root.getRight().getRight().getData());
    }
    @Test
    public void createNode5() {
        TreeNode<Integer> treeNode = new TreeNode<>(77, 87, 89);
        assertEquals(77, treeNode.getData());
        assertEquals(87, treeNode.getLeft().getData());
        assertEquals(89, treeNode.getRight().getData());
    }

    @Test
    public void print() {
        TreeNode<Integer> treeNode = new TreeNode<>(77, 87, 89);
        assertEquals("TreeNode{ data= 77 }", treeNode.toString());
    }

    @Test
    public void updateNode() {
        TreeNode<Integer> treeNode = new TreeNode<>();
        assertEquals(null, treeNode.getData());

        treeNode.setData(57);
        assertEquals(57, treeNode.getData());
    }
}
