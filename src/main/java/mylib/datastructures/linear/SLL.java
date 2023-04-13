/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.2
@since   1.0
*/

package mylib.datastructures.linear;

import mylib.datastructures.nodes.SNode;

/**
 * Singly Linked List class
 */
public class SLL {
    private SNode head;
    private SNode tail;
    private int size;

    /**
     * Default Constructor
     */
    public SLL() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Overloaded Constructor
     * @param head a SNode object
     */
    public SLL(SNode head) {
        this.head = head;
        this.tail = head;
        this.size = 1;
    }

    /**
     * Inserts node object at head of the list
     * @param node a SNode object
     */
    public void insertHead(SNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    /**
     * Inserts node object at tail of the list
     * @param node a SNode object
     */
    public void insertTail(SNode node) {
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Inserts a node object at a specified position in the list
     * @param node a SNode object
     * @param position the specified position
     */
    public void insert(SNode node, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException();
        } else if (position == 0) {
            insertHead(node);
        } else if (position == size) {
            insertTail(node);
        } else {
            SNode current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.getNext();
            }
            node.setNext(current.getNext());
            current.setNext(node);
            size++;
        }
    }

    /**
     * Inserts a node object in its proper position in a sorted list
     * Thus it checks for list sort validity
     * @param node a SNode object
     */
    public void sortedInsert(SNode node) {
        if (head == null || node.getData() < head.getData()) {
            // if the node is smaller than the head, insert the node as the new head
            insertHead(node);
            return;
        }
        if (isSorted() == false) {
            sort();
        }
        SNode current = head;
        while (current.getNext() != null && node.getData() > current.getNext().getData()) {
            current = current.getNext();
        }
        node.setNext(current.getNext());
        current.setNext(node);
        size++;
    }

    /**
     * Looks up a node in the list:
        * if found it returns the object
        * otherwise returns null
     * @param node a SNode object
     */
    public SNode search(SNode node) {
        SNode current = head;
        while (current != null) {
            if (current.getData() == node.getData()) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    /**
     * Delete head node
     */
    public void deleteHead() {
        if (head != null) {
            head = head.getNext();
            size--;
            if (head == null) {
                tail = null;
            }
        }
    }

    /**
     * Delete tail node
     */
    public void deleteTail() {
        if (size == 0) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        if (size == 1) {
            // the list contains only one element, delete it
            head = tail = null;
            size = 0;
            return;
        }
        // traverse the list to find the second last node
        SNode prev = null;
        SNode curr = head;
        while (curr != tail) {
            prev = curr;
            curr = curr.getNext();
        }
        // remove the last node and update tail
        prev.setNext(null);
        tail = prev;
        size--;
    }

    /**
     * Deletes the node if found in the list
     * @param node a SNode object
     */
    public void delete(SNode node) {
        if (size == 0) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        if (head == node) {
            // the node to delete is the head node
            deleteHead();
            return;
        }
        if (tail == node) {
            // the node to delete is the tail node
            deleteTail();
            return;
        }
        // traverse the list to find the node to delete
        SNode prev = null;
        SNode curr = head;
        while (curr != null && curr != node) {
            prev = curr;
            curr = curr.getNext();
        }
        if (curr == null) {
            System.out.println("The node was not found in the list.");
            return;
        }
        // remove the node and update the pointers
        prev.setNext(curr.getNext());
        curr.setNext(null);
        size--;
    }

    /**
     * Applies insertion sort to the list
     * The insertion part will start from the head unlike the usual insertion sort algorithm:
        * Instead of tracking back the list
     */
    public void sort() {
        if (this.size == 0) {
            System.out.println("The list is empty. Nothing to sort.");
            return;
        }
        if (size == 1 || isSorted()) {
            System.out.println("The list is already sorted.");
            return;
        }
        // create a new list with the first element
        SLL sortedList = new SLL(head);
        SNode curr = head.getNext();
        // traverse the remaining elements in the original list
        while (curr != null) {
            // remove the current node from the original list
            SNode temp = curr;
            curr = curr.getNext();
            temp.setNext(null);
            // insert the current node in its proper position in the sorted list
            sortedList.sortedInsert(temp);
        }
        // update the pointers of the original list to point to the sorted list
        head = sortedList.head;
        tail = sortedList.tail;
    }

    /**
     * Deletes the whole list
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /** Prints the list information on the screen, this includes:
        * List length
        * Sorted status
        * List content
        * Makes sure to show with relevant print statements-readable by the user
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
            SNode current = head;
            while (current != null) {
                System.out.print(current.getData() + " ");
                current = current.getNext();
            }
            System.out.println();
        }
    }

    /**
     * Helper function to check if the list is sorted in ascending order
     * @return true if sorted, false otherwise
     */
    private boolean isSorted() {
        if (head == null || head.getNext() == null) {
            return true;
        }
        SNode current = head;
        while (current.getNext() != null) {
            if (current.getData() > current.getNext().getData()) {
                return false;
            }
            current = current.getNext();
        }
        return true;
    }
}