/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.5
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit tests for Stack/Queue linear datastructures:
    * StackLL, QueueLL
 */
public class SQDataStructuresTest {
// StackLL Tests------------------------------------------------------------------------>
// ADD IN ONCE IMPLEMENTED StackLL
private StackLL stack;

@Before
public void setUpStackLL() {
    stack = new StackLL();
}

@Test
public void testStackLLPush() {
    SNode node1 = new SNode(1);
    SNode node2 = new SNode(2);

    stack.push(node1);
    stack.push(node2);

    assertEquals(node2, stack.peek());
    assertEquals(2, stack.getSize());
}

@Test
public void testStackLLPop() {
    SNode node1 = new SNode(1);
    SNode node2 = new SNode(2);

    stack.push(node1);
    stack.push(node2);

    SNode poppedNode = stack.pop();

    assertEquals(node2, poppedNode);
    assertEquals(1, stack.getSize());
}

@Test
public void testStackLLPeek() {
    SNode node1 = new SNode(1);
    SNode node2 = new SNode(2);

    stack.push(node1);
    stack.push(node2);

    SNode peekedNode = stack.peek();

    assertEquals(node2, peekedNode);
    assertEquals(2, stack.getSize());
}

@Test
public void testStackLLEmpty() {
    assertTrue(stack.empty());

    SNode node1 = new SNode(1);
    stack.push(node1);

    assertFalse(stack.empty());
}

/**
 * StackLL Print test
 */
@Test
public void testStackLLPrint() {
    SNode node1 = new SNode(1);
    SNode node2 = new SNode(2);
    
    StackLL stack = new StackLL();
    stack.push(node1);
    stack.push(node2);

    // Redirect stdout to capture printed output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    stack.print();

    String expectedOutput = "List length: 2" + System.lineSeparator() + 
                            "Sorted status: unsorted" + System.lineSeparator() +
                            "List content: 2 1" + System.lineSeparator();
    assertEquals(expectedOutput, outContent.toString());
}

// QueueLL Tests------------------------------------------------------------------------>
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
} // End of class declaration

