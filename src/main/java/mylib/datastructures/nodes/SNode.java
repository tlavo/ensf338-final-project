/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.2
@since   1.0
*/

package mylib.datastructures.nodes;

/**
 * Singly Linked Node class
 */
public class SNode {
    private int data;   // data stored in the node
    private SNode next; // reference to the next node
    
    /**
     * Constructor
     * @param data int data to be stored in the node
     */
    public SNode(int data) {
        this.data = data;
        this.next = null;
    }
    
    /**
     * Getter for data
     * @return data
     */
    public int getData() {
        return this.data;
    }
    
    /**
     * Setter for data
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }
    
    /**
     * Getter for next
     * @return next
     */
    public SNode getNext() {
        return this.next;
    }
    
    /**
     * Setter for next
     * @param next
     */
    public void setNext(SNode next) {
        this.next = next;
    } 
} // End of class declaration
