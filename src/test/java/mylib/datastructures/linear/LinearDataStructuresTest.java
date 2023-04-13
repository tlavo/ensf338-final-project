/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.1
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.Before;

/**
 * Unit tests for all linear datastructures:
    * SLL, DLL, CSLL, CDLL, StackLL, and QueueLL
 */
public class LinearDataStructuresTest {
    private SLL slist;
    private SNode s1, s2, s3, s4;

    @Before
    public void setUp() {
        this.slist = new SLL();
        this.s1 = new SNode(1);
        this.s2 = new SNode(2);
        this.s3 = new SNode(3);
        this.s4 = new SNode(4);
    }


// SLL Tests---------------------------------------------------------------------------->
    /**
     * SLL Constructors tests
     */
    @Test // default
    public void testSLLDefaultConstructor() {
        SLL list = new SLL();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
    }
    @Test // overloaded
    public void testSLLOverloadedConstructor() {
        SNode node = new SNode(10);
        SLL list = new SLL(node);
        assertSame(node, list.getHead());
        assertSame(node, list.getTail());
        assertEquals(1, list.getSize());
    }

    /**
     * SLL Insert tests
     */
    @Test // insertHead()
    public void testSLLInsertHead() {
        slist.insertHead(s1);
        slist.insertHead(s2);
        assertEquals(s2, slist.head);
    }
    @Test // insertTail()
    public void testSLLInsertTail() {
        slist.insertTail(s1);
        slist.insertTail(s2);
        assertEquals(s2, slist.tail);
    }
    @Test // insert()
    public void testSLLInsert() {
        slist.insert(s1, 0);
        slist.insert(s2, 1);
        slist.insert(s3, 1);
        assertEquals(s3, slist.head.getNext());
        assertEquals(s1, slist.head);
    }
    @Test // sortedInsert()
    public void testSLLSortedInsert() {
        slist.insertHead(s2);
        slist.insertHead(s1);
        slist.insertTail(s4);
        slist.sortedInsert(s3);
        assertEquals(s3, slist.head.getNext().getNext());
    }

    /**
     * SLL Search test
     */ 
    @Test
    public void testSLLSearch() {
        slist.insertHead(s2);
        slist.insertHead(s1);
        slist.insertTail(s4);
        slist.insertTail(s3);
        assertEquals(s4, slist.search(s4));
        assertNull(slist.search(new SNode(5)));
    }

    /**
     * SLL Delete tests
     */
    @Test // deleteHead()
    public void testSLLDeleteHead() {
        slist.insertHead(s2);
        slist.insertHead(s1);
        slist.deleteHead();
        assertEquals(s2, slist.head);
    }
    @Test // deleteTail()
    public void testSLLDeleteTail() {
        slist.insertHead(s2);
        slist.insertHead(s1);
        slist.insertTail(s3);
        slist.deleteTail();
        assertEquals(s2, slist.tail);
    }
    @Test // delete()
    public void testSLLDelete() {
        slist.insertHead(s2);
        slist.insertHead(s1);
        slist.insertTail(s4);
        slist.insertTail(s3);
        slist.delete(s2);
        assertEquals(s1, slist.head);
        slist.delete(s4);
        assertEquals(s3, slist.tail);
        SNode s5 = new SNode(5);
        slist.delete(s5);
        assertNull(slist.search(s5));
    }

    /**
     * SLL Sort test
     */
    @Test
    public void testSort() {
        // Create an unsorted list
        SLL list = new SLL();
        list.insertTail(new SNode(4));
        list.insertTail(new SNode(2));
        list.insertTail(new SNode(1));
        list.insertTail(new SNode(3));
    
        // Sort the list
        list.sort();
    
        // Check that the list is sorted
        assertTrue(list.isSorted());
    
        // Check that the list is in ascending order
        SNode current = list.getHead();
        int prevData = current.getData();
        while (current != null) {
            int currentData = current.getData();
            assertTrue(currentData >= prevData);
            prevData = currentData;
            current = current.getNext();
        }
    }    

    /**
     * SLL Clear tests
     */
    @Test
    public void testClear() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SLL list = new SLL(node1);
        list.insertTail(node2);
        list.clear();
        assertEquals(list.getSize(), 0);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }
    
    /**
     * SLL Print tests
     */
    @Test
    public void testPrint() {
        SLL list = new SLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertTail(node1);
        list.insertTail(node2);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        String expectedOutput = "List length: 2" + System.lineSeparator() +
                                "Sorted status: sorted" + System.lineSeparator() +
                                "List content: 1 2" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    
// SLL Tests---------------------------------------------------------------------------->
}
