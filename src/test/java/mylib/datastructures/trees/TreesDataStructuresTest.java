/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.3
@since   1.0
*/

package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for all trees datastructures
    * BST, AVL
 */
public class TreesDataStructuresTest {
    BST btree;

    @Before
    public void setUp() {
        btree = new BST();
    }


// BST Tests---------------------------------------------------------------------------->
    /**
     * BST Constructors tests
     */ 
    @Test // default
    public void testBSTDefaultConstructor() {
        BST bst = new BST();
        assertNull(bst.getRoot());
    }
    @Test // overloaded 1
    public void testBSTOverloadedConstructor1() {
        int val = 5;
        BST bst = new BST(val);
        assertNotNull(bst.getRoot());
        assertEquals(val, bst.getRoot().getData());
    }
    @Test // overloaded 2
    public void testBSTOverloadedConstructor2() {
        TNode root = new TNode(5, 0, null, null, null);
        BST bst = new BST(root);
        assertNotNull(bst.getRoot());
        assertEquals(root, bst.getRoot());
    }

    /**
     * BST Insert test
     */
    @Test // insert(int val)
    public void testBSTInsertVal() {
        btree.insert(5);
        assertEquals(5, btree.getRoot().getData());
    }
    @Test // insert(TNode node)
    public void testBSTInsertNode() {
        BST bst = new BST();
        TNode node1 = new TNode(5, 0, null, null, null);
        TNode node2 = new TNode(10, 0, null, null, null);
        TNode node3 = new TNode(3, 0, null, null, null);
    
        bst.insert(node1);
        assertEquals(bst.getRoot(), node1);
    
        bst.insert(node2);
        assertEquals(bst.getRoot().getRight(), node2);
    
        bst.insert(node3);
        assertEquals(bst.getRoot().getLeft(), node3);
    }

    /**
     * BST Search test
     */
    @Test
    public void testBSTSearch() {
        btree.insert(5);
        btree.insert(10);
        btree.insert(3);
        btree.insert(7);
        TNode found = btree.search(7);
        assertNotNull(found);
        assertEquals(7, found.getData());
        TNode notFound = btree.search(15);
        assertNull(notFound);
    }

    /**
     * BST Delete test
     */
    @Test
    public void testBSTDelete() {
        btree.insert(5);
        btree.insert(10);
        btree.insert(3);
        btree.insert(7);
        btree.delete(10);
        TNode found = btree.search(10);
        assertNull(found);
        TNode root = btree.getRoot();
        assertNotNull(root);
        assertEquals(5, root.getData());
        TNode leftChild = root.getLeft();
        assertNotNull(leftChild);
        assertEquals(3, leftChild.getData());
        TNode rightChild = root.getRight();
        assertNotNull(rightChild);
        assertEquals(7, rightChild.getData());
    }

    /**
     * BST Print tests
     */
    @Test // printInOrder()
    public void testBSTPrintInOrder() {
        btree.insert(5);
        btree.insert(10);
        btree.insert(3);
        btree.insert(7);
        btree.insert(1);
        btree.insert(4);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        btree.printInOrder();
        String expectedOutput = "1 3 4 5 7 10 " + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test // printBF()
    public void testBSTPrintBF() {
        BST bst = new BST();
        bst.insert(new TNode(10, 0, null, null, null));
        bst.insert(new TNode(5, 0, null, null, null));
        bst.insert(new TNode(15, 0, null, null, null));
        bst.insert(new TNode(3, 0, null, null, null));
        bst.insert(new TNode(7, 0, null, null, null));
        bst.insert(new TNode(12, 0, null, null, null));
        bst.insert(new TNode(17, 0, null, null, null));
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        bst.printBF();
        String expectedOutput = "10 " + System.lineSeparator() +
                                "5 15 " + System.lineSeparator() +
                                "3 7 12 17 " + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }


// AVL Tests---------------------------------------------------------------------------->
    /**
     * AVL Insert & Delete tests
     */
    @Test // insert()
    public void testAVLInsert() {
        AVL avl = new AVL(); 
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);

        assertEquals(4, avl.getRoot().getData());
        assertEquals(2, avl.getRoot().getLeft().getData());
        assertEquals(6, avl.getRoot().getRight().getData());
        assertEquals(1 , avl.getRoot().getLeft().getLeft().getData());
        assertEquals(3 , avl.getRoot().getLeft().getRight().getData());
        assertEquals(5 , avl.getRoot().getRight().getLeft().getData());
        assertEquals(7 , avl.getRoot().getRight().getRight().getData());
    }
    @Test // delete()
    public void testAVLDelete() {
        AVL avl = new AVL(); 
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);

        avl.delete(2);
        // AVL should be balanced
        assertNotNull(avl.search(4));
        assertNotNull(avl.search(6));
        assertNotNull(avl.search(1));
        assertNotNull(avl.search(3));
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(7));
        assertNull(avl.search(2));
    }

    /**
     * AVL Search test
     */
    @Test
    public void testAVLSearch() {
        AVL avl = new AVL(); 
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);
        TNode result = avl.search(3);
        assertEquals(3, result.getData());
    }

    /**
     * AVL Balance test
     */
    @Test
    public void testAVLBalance() {
        AVL avl = new AVL();
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);
        TNode root = avl.getRoot();
        assertEquals(0, avl.balanceFactor(root));
        assertEquals(0, avl.balanceFactor(root.getLeft()));
        assertEquals(0, avl.balanceFactor(root.getRight()));
    }

    /**
    * 4 cases of insertion tests (Left, Right, Rightleft, Leftright)
    */
    @Test // Left
    public void testLeftRotation() {
        AVL avl = new AVL();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);

        assertEquals(2, avl.getRoot().getData());
        assertEquals(1, avl.getRoot().getLeft().getData());
        assertEquals(3, avl.getRoot().getRight().getData());
    }
    @Test // Right
    public void testRightRotation() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(2);

        assertEquals(3, avl.getRoot().getData());
        assertEquals(2, avl.getRoot().getLeft().getData());
        assertEquals(5, avl.getRoot().getRight().getData());
    }
    @Test // RightLeft
    public void testRightLeftRotation() {
        AVL avl = new AVL();
        avl.insert(3);
        avl.insert(1);
        avl.insert(2);

        assertEquals(2, avl.getRoot().getData());
        assertEquals(1, avl.getRoot().getLeft().getData());
        assertEquals(3, avl.getRoot().getRight().getData());
    }
    @Test // LeftRight
    public void testLeftRightRotation() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(2);

        assertEquals(3, avl.getRoot().getData());
        assertEquals(2, avl.getRoot().getLeft().getData());
        assertEquals(5, avl.getRoot().getRight().getData());
    }

    /**
     * AVL Specific Delete tests
     */
    @Test // Deleting a node with one child
    public void testDeleteNodeWithOneChild() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(6);
        avl.delete(7);
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(3));
        assertNotNull(avl.search(6));
        assertNull(avl.search(7));
    }
    @Test // Deleting a node with two children
    public void testDeleteNodeWithTwoChildren() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.delete(7); 
    
        assertNotNull(avl.search(2));
        assertNotNull(avl.search(3));
        assertNotNull(avl.search(4));
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(6));
        assertNotNull(avl.search(8));
    }

    /**
     * AVL Duplicate Insert Test
     */
    @Test
    public void testDuplicateInsertion() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(5);

        assertNull(avl.search(4));
        assertEquals(5, avl.getRoot().getData());
        assertEquals(3, avl.getRoot().getLeft().getData());
        assertEquals(7, avl.getRoot().getRight().getData());
    }

    /**
     * AVL Print tests
     */
    @Test // printInOrder()
    public void testAVLPrintInOrder() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(10);
        avl.insert(3);
        avl.insert(7);
        avl.insert(1);
        avl.insert(4);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        avl.printInOrder();
        String expectedOutput = "1 3 4 5 7 10 " + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test // printBF()
    public void testAVLPrintBF() {
        AVL avl = new AVL(); 
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);
        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        avl.printBF();
        String expectedOutput = "4 " + System.lineSeparator() +
                                "2 6 " + System.lineSeparator() +
                                "1 3 5 7 " + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
} // End of class declaration
