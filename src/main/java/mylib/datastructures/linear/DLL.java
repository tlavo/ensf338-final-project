/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.2
@since   1.5
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.DNode;

/**
 * Doubly Linked List class
 */
public class DLL {
    protected DNode head;
    protected DNode tail;
    protected int size;

    /**
     * Default constructor
     */
    public DLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Overloaded constructor
     * @param head a DNode object
     */
    public DLL(DNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    /**
     * Insert a node at the head of the list
     * @param node a DNode object
     */
    public void insertHead(DNode node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
        } else {
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }
        node.setNext(null);
    }

    /**
     * Inserts a node at the tail of the list
     * @param node a DNode object
     */
    public void insertTail(DNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        size++;
    }

    /**
     * Insert a node at a specific position in the list
     * @param node a DNode object
     * @param position
     */
    public void insert(DNode node, int position)  {
        if (position < 0 || position > size)  {
            throw new IndexOutOfBoundsException();
        }
        if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            DNode current = head;
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
            node.setPrev(current.getPrev());
            node.setNext(current);
            current.getPrev().setNext(node);
            current.setPrev(node);
            size++;
        }
    }

    /**
     * Inserts a node object in its proper position in a sorted list
     * Thus it checks for list sort validity
     * @param node a DNode object
     */
    public void sortedInsert(DNode newNode) {
        if(!isSorted()){
            sort();
        }

        // If the list is empty, insert the new node as the head
        if (head == null) {
            insertHead(newNode);
            return;
        }
    
        // If the new node is less than the head node, insert it at the head
        if (newNode.getData() < (head.getData())) {
            insertHead(newNode);
            return;
        }
    
        // If the new node is greater than the tail node, insert it at the tail
        if (newNode.getData() < (tail.getData())) {
            insertTail(newNode);
            return;
        }

        if(newNode.getData() < (tail.getData())){
            insertTail(newNode);
        }
    
        // Search for the correct position to insert the new node
        DNode currNode = head.getNext();
        while (currNode != tail.getNext() && newNode.getData() < (currNode.getData())) {
            currNode = currNode.getNext();
        }
    
        // Insert the new node before the current node
        DNode prevNode = currNode.getPrev();
        newNode.setPrev(prevNode);
        newNode.setNext(currNode);
        currNode.setPrev(newNode);
        prevNode.setNext(newNode);
    
        size++;
    }

    /**
     * Looks up a node in the list:
        * if found it returns the object
        * otherwise returns null
     * @param node a DNode object
     */
    public DNode search(DNode node) {
        DNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Deletes head node
     */
    public void deleteHead() {
        if (head == null){
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0; 
        }
        else {
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
    }

    /**
     * Deletes tail node
     */
    public void deleteTail() {
        if (tail == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        tail = tail.getPrev();
        tail.setNext(null);
        size--;
    }

    /**
     * Deletes a node from the list
     * @param node a DNode object
     */
    public void delete(DNode node) {
        if (head == null) {
            return;
        }
        if (head == node) {
            head = node.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
            size--;
            return;
        }
        if (tail == node) {
            tail = node.getPrev();
            if (tail != null) {
                tail.setNext(null);
            } else {
                head = null;
            }
            size--;
            return;
        }
        DNode prev = node.getPrev();
        DNode next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
    }

    /**
     * Sorts the list (insertion sort method)
     */
    public void sort() {
        if (head == null || head.getNext() == null) {
            // Empty list or only one element, no need to sort
            return;
        }

        DNode current = head.getNext();
        while (current != null) {
            DNode key = current;
            DNode prev = current.getPrev();

            // Compare key with previous elements and swap if necessary
            while (prev != null && prev.getData() > key.getData()) {
                swap(prev, key);
                key = prev;
                prev = prev.getPrev();
            }

            current = current.getNext();
        }
    }

    // Helper method to swap two nodes in the doubly linked list (for insertion sort)
    private void swap(DNode node1, DNode node2) {
        int temp = node1.getData();
        node1.setData(node2.getData());
        node2.setData(temp);
    }

    /**
     * Deletes the whole list
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Prints the list that includes the size, sorted status, and the list
     */
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
            while (current != null) {
                System.out.print(current.getData());
                current = current.getNext();
                if (current != null) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Helper function to check if the list is sorted in ascending order
     * @return true if sorted, false otherwise
     */
    public boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        DNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }

    /**
     * Getter for head
     * @return head
     */
    public DNode getHead() {
        return this.head;
    }

    /**
     * Getter for tail
     * @return tail
     */
    public DNode getTail() {
        return this.tail;
    }

    /**
     * Getter for size
     * @return size
     */
    public int getSize() {
        return this.size;
    }

} // End of class declaration
