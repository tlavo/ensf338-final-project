/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.3
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

public class CSLL extends SLL {
    /**
     * Default Constructor
     */
    public CSLL() {
        super();
    }

    /**
     * Overloaded Constructor
     * @param head a SNode object
     */
    public CSLL(SNode head) {
        super(head);
        head.setNext(tail);
    }

    /**
     * Inserts node object at head of the list
     * @param node a SNode object
     */
    @Override
    public void insertHead(SNode node) {
        super.insertHead(node);
        if (tail != null) {
            tail.setNext(head);
        }
    }

    /**
     * Inserts node object at tail of the list
     * @param node a SNode object
     */
    @Override
    public void insertTail(SNode node) {
        super.insertTail(node);
        if (tail != null) {
            tail.setNext(head);
        }
    }

    /**
     * Calls super.sort() and sets tail.next as the head
     */
    @Override
    public void sort(){
        super.sort();
        if (tail != null) {
            tail.setNext(head);
        }
    }

    /**
     * Delete head node
     */
    @Override
    public void deleteHead() {
        super.deleteHead();
        if (tail != null) {
            tail.setNext(head);
        }
    }

    /**
     * Delete tail node
     */
    @Override
    public void deleteTail() {
        super.deleteTail();
        if (tail != null) {
            tail.setNext(head);
        }
    }
} // End of class declaration
