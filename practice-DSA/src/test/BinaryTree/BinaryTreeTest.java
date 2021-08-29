package test.BinaryTree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import app.BinaryTree.TreeNode;
import app.BinaryTree.BinaryTree;

/**
 * Created by DanyOlous on 29.08.2021.
 */
public class BinaryTreeTest {
    static BinaryTree<String> B2 = new BinaryTree<>();
    static BinaryTree<Character> B3 = new BinaryTree<>();
    static BinaryTree<Integer> B4 = new BinaryTree<>();
    static BinaryTree<Integer> B5 = new BinaryTree<>();

    @Test
    public void B1Test() {
        BinaryTree<Integer> B1 = new BinaryTree<>();
        assertEquals(true, B1.empty());

        B1.getNode().setData(13);
        assertEquals(13, B1.getNode().getData());
        assertEquals(true, B1.contains(13));
        assertEquals(1, B1.size());
        assertEquals(0, B1.height());

        B1.insert(1);
        assertEquals(1, B1.height());
        assertEquals(2, B1.size());

        B1.insert(16);
        B1.insert(77);
        assertEquals(true, B1.contains(13));
        assertEquals(true, B1.contains(1));
        assertEquals(true, B1.contains(16));
        assertEquals(true, B1.contains(77));
        assertEquals("77 1 16 13 ", B1.postOrder());
        assertEquals("13 1 77 16 ", B1.preOrder());
        assertEquals("13 1 16 77 ", B1.levelOrder());
        assertEquals("77 1 13 16 ", B1.inOrder());
        assertEquals(4, B1.size());
        assertEquals(2, B1.height());

        assertEquals(4, B1.size());
        B1.remove(76);
        assertEquals("13 1 16 77 ", B1.levelOrder());
        assertEquals(4, B1.size());
        B1.remove(77);
        assertEquals("13 1 16 ", B1.levelOrder());
        assertEquals(3, B1.size());
        assertEquals(false, B1.contains(77));
        assertEquals("13 1 16 ", B1.levelOrder());

        B1.insert(100);
        assertEquals(4, B1.size());
        assertEquals(true, B1.contains(100));
        B1.remove(1);
        assertEquals(3, B1.size());
        assertEquals(false, B1.contains(1));
        assertEquals("13 100 16 ", B1.levelOrder());
    }

    /*@Test
    public void createBinaryTree2() {
        B2 = new BinaryTree<String>("voiture");
        assertEquals(expected, actual);
    }

    @Test
    public void createBinaryTree3() {
        B3 = new BinaryTree<Character>('a', 'B', 'd');
        assertEquals(expected, actual);
    }

    @Test
    public void createBinaryTree4() {
        B4 = new BinaryTree<Integer>(100, new TreeNode<Integer>(35), new TreeNode<>(83));
        assertEquals(expected, actual);
    }

    @Test
    public void createBinaryTree5() {
        B5 = new BinaryTree<Integer>(100, 
        new TreeNode<Integer>(44, new TreeNode<>(53, 2, 90), new TreeNode<>(88)),
        new TreeNode<>(50));
        assertEquals(expected, actual);
    }*/
}
