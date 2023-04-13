/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.4
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

/**
 * Circular Singly Linked List class
 */
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

    /** Prints the list information on the screen, this includes:
        * List length
        * Sorted status
        * List content
        * Makes sure to show with relevant print statements-readable by the user
    */
    @Override
    public void print() {
        // Print the length of the list
        System.out.println("List length: " + size);
    
        // Check if the list is sorted and print the status
        boolean isSorted = isSorted();
        System.out.println("Sorted status: " + (isSorted ? "sorted" : "unsorted"));
    
        // Print the content of the list
        if (head == null) {
            System.out.println("List is empty.");
        } else {
            System.out.print("List content: ");
            SNode current = head;
            do {
                System.out.print(current.getData());
                current = current.getNext();
                if (current != null && current != head) {
                    System.out.print(" ");
                }
            } while (current != null && current != head);
            System.out.println();
        }
    }
} // End of class declaration
