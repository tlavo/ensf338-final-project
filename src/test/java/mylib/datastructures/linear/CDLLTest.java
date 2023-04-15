package mylib.datastructures.linear;

import org.junit.Before;
import org.junit.Test;

import mylib.datastructures.nodes.DNode;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CDLLTest {
    private CDLL cdll;

    @Before
    public void setUp() {
        cdll = new CDLL();
    }


    @Test
    public void testDefaultConstructor() {
        CDLL cdll = new CDLL();
        assertNotNull(cdll);
        assertNull(cdll.getHead());
        assertNull(cdll.getTail());
    }

    @Test
    public void testOverloadedConstructor() {
        DNode node = new DNode(1); // Create a new DNode with data value 1
        CDLL cdll = new CDLL(node);

        assertNotNull(cdll);
        assertEquals(node, cdll.getHead());
        assertEquals(node, cdll.getTail());
        assertEquals(node.getNext(), cdll.getTail());
        assertEquals(node.getPrev(), cdll.getTail());
    }

    @Test
    public void testCDLLInsertHead() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        cdll.insertHead(node1);
        cdll.insertHead(node2);
        assertEquals("Insert head should update head correctly", node2, cdll.getHead());
        assertEquals("Insert head should update tail correctly", node1, cdll.getTail());
    }

    @Test
    public void testCDLLInsertTail() {
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        cdll.insertTail(node1);
        cdll.insertTail(node2);
        assertEquals("Insert tail should update head correctly", node1, cdll.getHead());
        assertEquals("Insert tail should update tail correctly", node2, cdll.getTail());
        assertEquals("Insert tail should update size correctly", 2, cdll.getSize());
    }

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

    @Test
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

    @Test
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
}
