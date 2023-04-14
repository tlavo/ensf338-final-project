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
     * pop();
     * @return node at the head of the stack and deletes it from stack
     */
    public SNode pop() {
        SNode node = this.head;
        super.deleteHead();
        return node;
    }

    /**
     * peek();
     * @return head of stack without popping
     */
    public SNode peek() {
        return this.head;
    }

    /**
     * @return whether stack is empty or not.
     */
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void insertTail(SNode node) {
    }

    @Override
    public void insert(SNode node, int position) {
    }

    @Override
    public void sortedInsert(SNode node) {
    }

    @Override
    public void deleteTail() {
    }

    @Override
    public void delete(SNode node) {
    }

    @Override
    public void sort() {
    }

} // End of class declaration
