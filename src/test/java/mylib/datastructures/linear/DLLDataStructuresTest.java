/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.5
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for DLL linear datastructures:
    * DLL, CDLL
 */
public class DLLDataStructuresTest {
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
        DNode node = new DNode(1);

        assertNull(list.search(node));

        list.insertHead(node);
        assertEquals(node, list.search(node));
    }

    /**
     * DLL Delete tests
     */
    @Test // deleteHead()
    public void testDLLDeleteHead() { // FIXXXXXXXXXXXXXXXXXXXXX
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);

        list.insertHead(node1);
        list.insertHead(node2);

        list.deleteHead();

        assertNull(list.search(node2));
        assertEquals(node1, list.search(node1));
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
    public void testDLLSort() { // FIXXXXXXXXXXXXXXXXXXXXX
        DLL list = new DLL();
        DNode node1 = new DNode(1);
        DNode node2 = new DNode(2);
        DNode node3 = new DNode(3);

        list.insertHead(node1);
        list.insertHead(node2);
        list.insertHead(node3);

        list.sort();

        assertEquals(node1, list.search(node1));
        assertEquals(node2, list.search(node2));
        assertEquals(node3, list.search(node3));
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
// ADD IN ONCE IMPLEMENTED CDLL


} // End of class declaration
