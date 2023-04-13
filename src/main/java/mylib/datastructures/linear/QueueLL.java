/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.3
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

/**
 * Queue Singly Linked List class
 */
public class QueueLL extends SLL {
    /**
     * Default Constructor
     */
    public QueueLL() {
        super();
    }

    /**
     * Overloaded Constructor
     * @param head a SNode object
     */
    public QueueLL(SNode head) {
        super(head);
    }

    /**
     * Enqueue inserts at the back of the list
     * @param node a SNode object
     */
    public void enqueue(SNode node) {
        super.insertTail(node);
    }

    /**
     * Dequeue deletes from the front of the list
     */
    public void dequeue() {
        super.deleteHead();
    }    

    /**
     * Returns the data element at the front of the queue without removing it
     * @return the data element at the front of the queue
     * @throws IllegalStateException if the queue is empty
     */
    public int peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return head.getData();
    }

    /**
     * Overriding methods that aren't applicable to QueueLL
     */
    @Override
    public void insertHead(SNode node) {}

    @Override
    public void insert(SNode node, int position) {}

    @Override
    public void sortedInsert(SNode node) {}

    @Override
    public void deleteTail() {}

    @Override
    public void delete(SNode node) {}

    @Override
    public void sort() {}
} // End of class declaration
