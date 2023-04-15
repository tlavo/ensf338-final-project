/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.5
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for DLL linear datastructures:
    * DLL, CDLL
 */
public class DLLDataStructuresTest {
    private CDLL cdll;

    @Before
    public void setUp() {
        cdll = new CDLL();
    }


// DLL Tests---------------------------------------------------------------------------->
    /**
     * DLL Constructors tests
     */
    @Test // default
    public void testDLLDefaultConstructor() {
        DLL list = new DLL();
        assertNull(list.getHead());
        assertNull(list.getTail());
        assertEquals(0, list.getSize());
    }
    @Test // overloaded
    public void testDLLOverloadedConstructor() {
        DNode node = new DNode(42);
        DLL list = new DLL(node);
        assertEquals(node, list.getHead());
        assertEquals(node, list.getTail());
        assertEquals(1, list.getSize());
    }

    /**
     * DLL Insert tests
     */
    @Test // insertHead()
    public void testDLLInsertHead() {
        DLL list = new DLL();
        DNode node = new DNode(1);

        list.insertHead(node);
        assertEquals(node, list.search(node));
    }
    @Test // insertTail()
    public void testDLLInsertTail() {
        DLL list = new DLL();
        DNode node = new DNode(1);

        list.insertTail(node);
        assertEquals(node, list.search(node));
    }
    @Test // insert()
    public void testDLLInsert() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        list.insert(node1, 0);
        list.insert(node2, 1);

        assertEquals(node1, list.search(node1));
        assertEquals(node2, list.search(node2));
    }
    @Test // sortedInsert()
    public void testDLLSortedInsert() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        list.sortedInsert(node3);
        list.sortedInsert(node1);
        list.sortedInsert(node2);

        assertTrue(list.isSorted());
    }

    /**
     * DLL Search test
     */
    @Test
    public void testDLLSearch() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        

        assertNull(list.search(node2));

        list.insertHead(node1);
        list.insertTail(node2);
        assertEquals(node2, list.search(node2));
    }

    /**
     * DLL Delete tests
     */
    @Test //deleteHead()
    public void testDLLDeleteHead() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.insertHead(node1);
        list.insertTail(node2);
        list.deleteHead();
        assertEquals(1, list.getSize());
        assertEquals(node2, list.getHead());
        assertNull(node2.getPrev());
        assertNull(node2.getNext());
    }
    @Test // deleteTail()
    public void testDLLDeleteTail() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        list.insertHead(node1);
        list.insertHead(node2);
        list.deleteTail();
        assertNull(list.search(node1));
        assertEquals(node2, list.search(node2));
    }
    @Test // delete()
    public void testDelete() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        list.insertHead(node1);
        list.insertHead(node2);

        list.delete(node1);

        assertNull(list.search(node1));
        assertEquals(node2, list.search(node2));
    }

    /**
     * DLL Sort test
     */
    @Test
    public void testDLLSort() { 
        DLL list = new DLL();
        DNode node1 = new DNode(5);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(8);
        DNode node4 = new DNode(1);
        DNode node5 = new DNode(7);

        // Insert elements in random order
        list.insertTail(node1); //5
        list.insertTail(node2); //2
        list.insertTail(node3); //8
        list.insertTail(node4); //1
        list.insertTail(node5); //7

        // Sort the list
        list.sort();

        // Expected sorted list: 1 -> 2 -> 5 -> 7 -> 8
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getHead().getNext().getData());
        assertEquals(5, list.getHead().getNext().getNext().getData());
        assertEquals(7, list.getHead().getNext().getNext().getNext().getData());
        assertEquals(8, list.getTail().getData());
    }
    

    /**
     * DLL Clear tests
     */
    @Test
    public void testDLLClear() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DLL list = new DLL(node1);
        list.insertTail(node2);
        list.clear();
        assertEquals(list.getSize(), 0);
        assertNull(list.getHead());
        assertNull(list.getTail());
    }

    /**
     * DLL Print test
     */
    @Test
    public void testDLLPrint() {
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
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


// CDLL Tests--------------------------------------------------------------------------->
    /**
     * CDLL Constructors tests
     */
    @Test // default
    public void testCDLLDefaultConstructor() {
        CDLL cdll = new CDLL();
        assertNotNull(cdll);
        assertNull(cdll.getHead());
        assertNull(cdll.getTail());
    }
    @Test // overloaded
    public void testCDLLOverloadedConstructor() {
        DNode node = new DNode(1); 
        CDLL cdll = new CDLL(node);

        assertNotNull(cdll);
        assertEquals(node, cdll.getHead());
        assertEquals(node, cdll.getTail());
        assertEquals(node.getNext(), cdll.getTail());
        assertEquals(node.getPrev(), cdll.getTail());
    }

    /**
     * CDLL Insert tests
     */
    @Test // insertHead()
    public void testCDLLInsertHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        cdll.insertHead(node1);
        cdll.insertHead(node2);
        assertEquals("Insert head should update head correctly", node2, cdll.getHead());
        assertEquals("Insert head should update tail correctly", node1, cdll.getTail());
    }
    @Test // insertTail()
    public void testCDLLInsertTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        cdll.insertTail(node1);
        cdll.insertTail(node2);
        assertEquals("Insert tail should update head correctly", node1, cdll.getHead());
        assertEquals("Insert tail should update tail correctly", node2, cdll.getTail());
        assertEquals("Insert tail should update size correctly", 2, cdll.getSize());
    }

    /**
     * CDLL Sort test
     */
    @Test
    public void testCDLLSort() {
        DNode node1 = new DNode(3);
        DNode node2 = new DNode(1);
        DNode node3 = new DNode(2);
        cdll.insertHead(node1);
        cdll.insertHead(node2);
        cdll.insertHead(node3);
        cdll.sort();
        assertTrue("Sort should sort the list", cdll.isSorted());
    }

    /**
     * CDLL Delete tests
     */
    @Test // deleteHead()
    public void testCDLLDeleteHead() {
        CDLL cdll = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        cdll.insertTail(node1);
        cdll.insertTail(node2);
        cdll.insertTail(node3);

        cdll.deleteHead();
        // Assert that the head is updated to the next node and tail's next is updated to the new head
        assert cdll.getHead() == node2;
        assert cdll.getTail().getNext() == cdll.getHead();
    }
    @Test // deleteTail()
    public void testCDLLDeleteTail() {
        CDLL cdll = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        
        cdll.insertTail(node1);
        cdll.insertTail(node2);
        cdll.insertTail(node3);
        
        cdll.deleteTail();
        
        // Assert that the tail is updated to the previous node and head's prev is updated to the new tail
        assert cdll.getTail() == node2;
        assert cdll.getHead().getPrev() == cdll.getTail();
    }

    /**
     * CDLL Print test
     */
    @Test
    public void testCDLLPrint() {
        CDLL cdll = new CDLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);
        cdll.insertHead(node1);
        cdll.insertTail(node2);
        cdll.insertTail(node3);
        // Redirect stdout to capture printed output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream originalOut = System.out;
        System.setOut(ps);
        // Call the print() method
        cdll.print();
        // Restore stdout
        System.out.flush();
        System.setOut(originalOut);
        // Get the captured printed output
        String printedOutput = baos.toString();
        // Assert expected output
        String expectedOutput = "List length: 3" + System.lineSeparator() + 
        "Sorted status: unsorted" + System.lineSeparator() +
        "List content: 1 2 3" + System.lineSeparator();
        assertEquals(expectedOutput, printedOutput);
    }
} // End of class declaration

