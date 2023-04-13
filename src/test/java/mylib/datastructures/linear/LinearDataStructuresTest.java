/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.5
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void testSLLSort() {
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
    public void testSLLClear() {
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
     * SLL Print test
     */
    @Test
    public void testSLLPrint() {
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

    
// DLL Tests---------------------------------------------------------------------------->
// ADD IN ONCE IMPLEMENTED DLL


// CSLL Tests--------------------------------------------------------------------------->
    /**
     * CSLL Constructors tests
     */
    @Test // default
    public void testCSLLDefaultConstructor() {
        CSLL list = new CSLL();
        assertEquals(0, list.getSize());
        assertNull(list.getHead());
        assertNull(list.getTail());
    }
    @Test // overloaded
    public void testCSLLOverloadedConstructor() {
        SNode node = new SNode(1);
        CSLL list = new CSLL(node);
        assertEquals(1, list.getSize());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
    }

    /**
     * CSLL Insert tests
     */
    @Test // insertHead()
    public void testCSLLInsertHead() {
        CSLL list = new CSLL();
        SNode node = new SNode(1);
        list.insertHead(node);
        assertEquals(1, list.getSize());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail().getNext());
    }
    @Test // insertTail()
    public void testCSLLInsertTail() {
        CSLL list = new CSLL();
        SNode node = new SNode(1);
        list.insertTail(node);
        assertEquals(1, list.getSize());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertEquals(node, list.getTail());
        assertEquals(node, list.getHead().getNext());
    }

    /**
     * CSLL Sort test
     */
    @Test
    public void testCSLLSort() {
        // Create an unsorted list
        CSLL list = new CSLL();
        list.insertHead(new SNode(2));
        list.insertHead(new SNode(4));
        list.insertHead(new SNode(1));
        list.insertHead(new SNode(3));
        // Sort the list
        list.sort();
        // Check that the list is sorted
        assertTrue(list.isSorted());
        // Check that the list is in ascending order
        assertEquals(4, list.getSize());
        assertEquals(1, list.getHead().getData());
        assertEquals(4, list.getTail().getData());
        assertEquals(list.getHead(), list.getTail().getNext());
    }

    /**
     * CSLL Delete tests
     */
    @Test // deleteHead()
    public void testCSLLDeleteHead() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertHead(node2);
        list.insertHead(node1);
        list.deleteHead();
        assertEquals(1, list.getSize());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertEquals(node2, list.getHead());
        assertEquals(node2, list.getTail().getNext());
    }
    @Test // deleteTail()
    public void testCSLLDeleteTail() {
        CSLL list = new CSLL();
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        list.insertHead(node2);
        list.insertHead(node1);
        list.deleteTail();
        assertEquals(1, list.getSize());
        assertNotNull(list.getHead());
        assertNotNull(list.getTail());
        assertEquals(node1, list.getHead());
        assertEquals(node1, list.getTail().getNext());
    }

    /**
     * CSLL Print test
     */
    @Test
    public void testCSLLPrint() {
        SNode node1 = new SNode(1);
        SNode node2 = new SNode(2);
        SNode node3 = new SNode(3);
        CSLL list = new CSLL(node1);
        list.insertTail(node3);
        list.insertTail(node2);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        list.print();
        String expectedOutput = "List length: 3" + System.lineSeparator() + 
                                "Sorted status: unsorted" + System.lineSeparator() +
                                "List content: 1 3 2" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }


// CDLL Tests--------------------------------------------------------------------------->
// ADD IN ONCE IMPLEMENTED CDLL


// StackLL Tests------------------------------------------------------------------------->
// ADD IN ONCE IMPLEMENTED StackLL


// QueueLL Tests------------------------------------------------------------------------->
    /**
     * QueueLL Queueing tests
     */
    @Test // enqueue
    public void testEnqueue() {
        QueueLL queue = new QueueLL();
        queue.enqueue(new SNode(1));
        queue.enqueue(new SNode(2));
        queue.enqueue(new SNode(3));
        assertEquals(3, queue.getSize());
    }
    @Test // dequeue
    public void testDequeue() {
        QueueLL queue = new QueueLL();
        queue.enqueue(new SNode(1));
        queue.enqueue(new SNode(2));
        queue.enqueue(new SNode(3));
        queue.dequeue();
        assertEquals(2, queue.getSize());
    }

    /**
     * QueueLL Peak tests
     */
    @Test // queue with data
    public void testPeek() {
        QueueLL queue = new QueueLL();
        queue.enqueue(new SNode(1));
        queue.enqueue(new SNode(2));
        queue.enqueue(new SNode(3));
        assertEquals(1, queue.peek());
    }
         // empty queue
    @Test(expected = IllegalStateException.class)
    public void testPeekOnEmptyQueue() {
        QueueLL queue = new QueueLL();
        queue.peek();
    }

    /**
     * QueueLL Print test
     */
    @Test
    public void testQueueLLPrint() {
        SNode node1 = new SNode(1);
        SNode node3 = new SNode(3);
        SNode node5 = new SNode(5);
        QueueLL queue = new QueueLL();
        queue.enqueue(node1);
        queue.enqueue(node3);
        queue.enqueue(node5);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        queue.print();
        String expectedOutput = "List length: 3" + System.lineSeparator() + 
                                "Sorted status: sorted" + System.lineSeparator() +
                                "List content: 1 3 5" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }
}
