/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.2
@since   1.0
*/

package mylib.datastructures.nodes;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for all node datastructures
    * SNode, DNode, TNode
 */
public class NodesDataStructuresTest {
    private SNode snode1;
    private SNode snode2;
    private DNode dnode1;
    private DNode dnode2;

    @Before
    public void setUp() throws Exception {
        this.snode1 = new SNode(1);
        this.snode2 = new SNode(2);
        this.dnode1 = new DNode(1);
        this.dnode2 = new DNode(2);
    }

// SNode Tests-------------------------------------------------------------------------->
    /**
     * SNode Constructor test
     */
    @Test
        public void testSNodeConstructor() {
        // Create a new node with data 5
        SNode node = new SNode(5);
        // Check that the node data was set correctly
        assertEquals(5, node.getData());
        // Check that the next node reference is null
        assertNull(node.getNext());
    }

    /**
     * SNode getData() test
     */
    @Test
    public void testSNodeGetData() {
        assertEquals(1, snode1.getData());
        assertEquals(2, snode2.getData());
    }

    /**
     * SNode setData() test
     */    
    @Test
    public void testSNodeSetData() {
        snode1.setData(3);
        snode2.setData(4);
        assertEquals(3, snode1.getData());
        assertEquals(4, snode2.getData());
    }

    /**
     * SNode getNext() test
     */
    @Test
    public void testSNodeGetNext() {
        assertNull(snode1.getNext());
        assertNull(snode2.getNext());
    }

    /**
     * SNode setData() test
     */    
    @Test
    public void testSNodeSetNext() {
        snode1.setNext(snode2);
        assertEquals(snode2, snode1.getNext());
        assertNull(snode2.getNext());
    }


// DNode Tests-------------------------------------------------------------------------->
    /**
     * DNode Constructor test
     */
    @Test
    public void testDNodeConstructor() {
        // Create a new node with data 5
        DNode node = new DNode(5);
        // Check that the node data was set correctly
        assertEquals(5, node.getData());
        // Check that the prev node reference is null
        assertNull(node.getPrev());
        // Check that the next node reference is null
        assertNull(node.getNext());
    }

    /**
     * DNode getData() test
     */
    @Test
    public void testDNodeGetData() {
        assertEquals(1, dnode1.getData());
        assertEquals(2, dnode2.getData());
    }

    /**
     * DNode setData() test
     */    
    @Test
    public void testDNodeSetData() {
        dnode1.setData(3);
        dnode2.setData(4);
        assertEquals(3, dnode1.getData());
        assertEquals(4, dnode2.getData());
    }

    /**
     * DNode getPrev() test
     */
    @Test
    public void testDNodeGetPrev() {
        assertNull(dnode1.getNext());
        assertNull(dnode2.getNext());
    }

    /**
     * DNode setPrev() test
     */
    @Test
    public void testDNodeSetPrev() {
        dnode1.setPrev(dnode2);
        assertEquals(dnode2, dnode1.getPrev());
    }

    /**
     * DNode getNext() test
     */
    @Test
    public void testDNodeGetNext() {
        assertNull(dnode1.getNext());
        assertNull(dnode2.getNext());
    }

    /**
     * DNode setData() test
     */    
    @Test
    public void testDNodeSetNext() {
        dnode1.setNext(dnode2);
        assertEquals(dnode2, dnode1.getNext());
        assertNull(dnode2.getNext());
    }


// TNode Tests-------------------------------------------------------------------------->
    /**
     * TNode Constructor tests
     */
    @Test // default
    public void testTNodeDefaultConstructor() {
        TNode node = new TNode();
        assertEquals(0, node.getData());
        assertNull(node.getLeft());
        assertNull(node.getRight());
        assertNull(node.getParent());
        assertEquals(0, node.getBalance());
    }
    @Test // overloaded
    public void testTNodeOverloadedConstructor() {
        TNode parent = new TNode();
        TNode left = new TNode();
        TNode right = new TNode();
        TNode node = new TNode(5, 1, parent, left, right);
        assertEquals(5, node.getData());
        assertEquals(1, node.getBalance());
        assertEquals(parent, node.getParent());
        assertEquals(left, node.getLeft());
        assertEquals(right, node.getRight());
    }

    /**
     * TNode getData() test
     */  
    @Test
    public void testTNodeGetData() {
        TNode node = new TNode(10, 0, null, null, null);
        assertEquals(10, node.getData());
    }

    /**
     * TNode setData() test
     */  
    @Test
    public void testTNodeSetData() {
        TNode node = new TNode(10, 0, null, null, null);
        node.setData(20);
        assertEquals(20, node.getData());
    }

    /**
     * TNode getLeft() test
     */  
    @Test
    public void testTNodeGetLeft() {
        TNode left = new TNode(5, 0, null, null, null);
        TNode node = new TNode(10, 0, null, left, null);
        assertEquals(left, node.getLeft());
    }

    /**
     * TNode setLeft() test
     */  
    @Test
    public void testTNodeSetLeft() {
        TNode left = new TNode(5, 0, null, null, null);
        TNode node = new TNode(10, 0, null, null, null);
        node.setLeft(left);
        assertEquals(left, node.getLeft());
    }

    /**
     * TNode getRight() test
     */  
    @Test
    public void testTNodeGetRight() {
        TNode right = new TNode(15, 0, null, null, null);
        TNode node = new TNode(10, 0, null, null, right);
        assertEquals(right, node.getRight());
    }

    /**
     * TNode setRight() test
     */ 
    @Test
    public void testTNodeSetRight() {
        TNode right = new TNode(15, 0, null, null, null);
        TNode node = new TNode(10, 0, null, null, null);
        node.setRight(right);
        assertEquals(right, node.getRight());
    }

    /**
     * TNode getParent() test
     */ 
    @Test
    public void testTNodeGetParent() {
        TNode parent = new TNode(5, 0, null, null, null);
        TNode node = new TNode(10, 0, parent, null, null);
        assertEquals(parent, node.getParent());
    }

    /**
     * TNode setParent() test
     */ 
    @Test
    public void testTNodeSetParent() {
        TNode parent = new TNode(5, 0, null, null, null);
        TNode node = new TNode(10, 0, null, null, null);
        node.setParent(parent);
        assertEquals(parent, node.getParent());
    }

    /**
     * TNode getBalance() test
     */ 
    @Test
    public void testTNodeGetBalance() {
        TNode node = new TNode(10, 1, null, null, null);
        assertEquals(1, node.getBalance());
    }

    /**
     * TNode setBalance() test
     */ 
    @Test
    public void testTNodeSetBalance() {
        TNode node = new TNode(10, 0, null, null, null);
        node.setBalance(1);
        assertEquals(1, node.getBalance());
    }

    /**
     * TNode Print test
     */ 
    @Test
    public void testTNodePrint() {
        TNode node1 = new TNode(5, 0, null, null, null);
        TNode node2 = new TNode(10, 0, node1, null, null);
        TNode node3 = new TNode(3, 0, node1, null, null);
        node1.setLeft(node3);
        node1.setRight(node2);

        // Expected output when calling node1.print()
        String expectedOutput = "Node data: 5" + System.lineSeparator() +
                                "Left child: 3" + System.lineSeparator() +
                                "Right child: 10" + System.lineSeparator() +
                                "No parent" + System.lineSeparator() +
                                "Balance: 0" + System.lineSeparator();
        
        // Redirect System.out to a string buffer
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call node1.print() and get the printed output
        node1.print();
        String printedOutput = outputStream.toString();

        // Reset System.out
        System.setOut(System.out);

        // Compare the expected output with the printed output
        assertEquals(expectedOutput, printedOutput);
    }

    /**
     * TNode toString() test
     */ 
    @Test
    public void testToString() {
        TNode node = new TNode(42, 0, null, null, null);
        assertEquals("42", node.toString());
    }
} // End of class declaration