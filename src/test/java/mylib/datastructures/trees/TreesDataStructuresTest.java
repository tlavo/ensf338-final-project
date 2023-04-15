/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.1
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
        btree.printInOrder();
        // expected output: 1 3 4 5 7 10
    }
    @Test // printBF()
    public void testPrintBF() {
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
// ADD IN ONCE IMPLEMENTED AVL
}
