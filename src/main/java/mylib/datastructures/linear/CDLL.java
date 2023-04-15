/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.3
@since   1.0
*/package

mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

/**
 * Circular Doubly Linked List class
 */
public class CDLL extends DLL{
     /**
     * Default Constructor
     */
    public CDLL(){
        super();
    }

    /**
     * Overloaded Constructor
     * @param head a DNode object
     */
    public CDLL(DNode head){
        super(head);
        head.setNext(tail);
        head.setPrev(tail);
    }
    
    /**
     * Inserts node object at head of the list
     * @param node a DNode object
     */
    @Override
    public void insertHead(DNode node){
        super.insertHead(node);
        tail.setNext(head);
        head.setPrev(tail);
    }
    
   /**
     * Inserts node object at tail of the list
     * @param node a DNode object
     */
    public void insertTail(DNode node){
        super.insertTail(node);
        tail.setNext(head);
        head.setPrev(tail);
    }

   /**
     * Calls super.sort() 
     */
    @Override
    public void sort(){
        super.sort();
        head.setPrev(tail);
        tail.setNext(head);
        }
    
    /**
     * Delete head node
     */
    @Override
    public void deleteHead(){
        super.deleteHead();
        head.setPrev(tail);
        tail.setNext(head);
    }
    
    /**
     * Delete tail node
     */
    public void deleteTail(){
        super.deleteTail();
        head.setPrev(tail);
        tail.setNext(head);
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

            DNode current = head;
            do {
                System.out.print(current.getData());
                current = current.getNext();
                if (current != head) {
                    System.out.print(" ");
                }
            } while (current != head);
            System.out.println();
        }
    }
} // End of class declaration
