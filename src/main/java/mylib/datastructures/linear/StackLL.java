/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.3
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

/**
 * Stack Singly Linked List class
 */
public class StackLL extends SLL {
    /**
     * Default Constructor
    */
    public StackLL() {
        super();
    }

    /**
     * Overloaded Constructor
     * @param head a SNode object
     */
    public StackLL(SNode head) {
        super(head);
    }

    /**
     * Push adds elements to the top of the stack
     * @param node a SNode object
     */
    public void push(SNode node) {
        super.insertHead(node);
    }

    /**
     * Pops a node off the stack
     * @return node at the head of the stack and deletes it from stack
     */
    public SNode pop() {
        SNode node = this.head;
        super.deleteHead();
        return node;
    }

    /**
     * Returns the data element at the head of the stack without removing it
     * @return the data element at the head of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public int peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return head.getData();
    }

    /**
     * Overriding methods that aren't applicable to StackLL
     * (insertTail())
     */
    @Override
    public void insertTail(SNode node) {}
    /**
     * Overriding methods that aren't applicable to StackLL
     * (insert())
     */
    @Override
    public void insert(SNode node, int position) {}
    /**
     * Overriding methods that aren't applicable to StackLL
     * (sortedInsert())
     */
    @Override
    public void sortedInsert(SNode node) {}
    /**
     * Overriding methods that aren't applicable to StackLL
     * (deleteTail())
     */
    @Override
    public void deleteTail() {}
    /**
     * Overriding methods that aren't applicable to StackLL
     * (delete())
     */
    @Override
    public void delete(SNode node) {}
    /**
     * Overriding methods that aren't applicable to StackLL
     * (sort())
     */
    @Override
    public void sort() {}
} // End of class declaration
