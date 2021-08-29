package test.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import app.BinaryTree.TreeNode;
import app.BinaryTree.BinarySearchTree;
import app.BinaryTree.BinaryTree;

/**
 * Created by DanyOlous on 29.08.2021.
 */
public class BinarySearchTreeTest {

    @Test
    public void BstTest1() {
        BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
        assertEquals(true, BST.empty());

        BST.getNode().setData(13);
        assertEquals(13, BST.getNode().getData());
        assertEquals(true, BST.contains(13));
        assertEquals(1, BST.size());
        assertEquals(0, BST.height());

        BST.insert(1);
        assertEquals(1, BST.height());
        assertEquals(2, BST.size());

        BST.insert(16);
        BST.insert(77);
        assertEquals(true, BST.contains(13));
        assertEquals(true, BST.contains(1));
        assertEquals(true, BST.contains(16));
        assertEquals(true, BST.contains(77));
        assertEquals(false, BST.contains(123));
        assertEquals("1 77 16 13 ", BST.postOrder());
        assertEquals("13 1 16 77 ", BST.preOrder());
        assertEquals("13 1 16 77 ", BST.levelOrder());
        assertEquals("1 13 16 77 ", BST.inOrder());
        assertEquals(4, BST.size());
        assertEquals(2, BST.height());

        assertEquals(4, BST.size());
        BST.remove(76);
        assertEquals("13 1 16 77 ", BST.levelOrder());
        assertEquals(4, BST.size());
        BST.remove(77);
        assertEquals("13 1 16 ", BST.levelOrder());
        assertEquals(3, BST.size());
        assertEquals(false, BST.contains(77));
        assertEquals("13 1 16 ", BST.levelOrder());

        BST.insert(100);
        assertEquals(4, BST.size());
        assertEquals(true, BST.contains(100));
        BST.remove(1);
        assertEquals(3, BST.size());
        assertEquals(false, BST.contains(1));
        assertEquals("13 16 100 ", BST.levelOrder());
    }
    
}
