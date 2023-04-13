/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.3
@since   1.0
*/

package mylib.datastructures.nodes;

/**
 * Doubly Linked Node class
 */
public class DNode {
    private int data; // data stored in the node
    private DNode prev; // reference to the previous node
    private DNode next; // reference to the next node

    /**
     * Constructor 
     * @param data int data to be stored in the node
     */
    public DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    /**
     * Getter for data (gets the data stored in the node)
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
     * Getter for prev 
     * @return prev
     */
    public DNode getPrev() {
        return prev;
    }

    /**
     * Setter for prev
     * @param prev 
     */
    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    /**
     * Getter for next
     * @return next
     */
    public DNode getNext() {
        return this.next;
    }

    /**
     * Setter for next
     * @param next 
     */
    public void setNext(DNode next) {
        this.next = next;
    }
}
