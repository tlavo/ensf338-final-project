/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.1
@since   1.0
*/

package mylib.datastructures.nodes;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit tests for all nodes datastructures
    * SNode, DNode, and TNode
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
    public void testConstructor() {
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
// ADD IN ONCE IMPLEMENTED TNode
}
