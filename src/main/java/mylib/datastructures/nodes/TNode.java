/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.1
@since   1.0
*/

package mylib.datastructures.nodes;

/**
 * Tree Node class
 */
public class TNode {
    private int data;       // data stored in the node
    private TNode left;     // TNode object to the left
    private TNode right;    // TNode object to the right
    private TNode parent;   // TNode object as the parent
    private int balance;    // balance field pertaining to tree nodes

    /**
     * Default Constructor
     */
    public TNode() {
        this.data = 0;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.balance = 0;
    }

    /**
     * Overloaded Constructor
     * @param data int data to be stored in the node
     * @param balance int balance parameter
     * @param P parent node
     * @param L left node
     * @param R right node
     */
    public TNode(int data, int balance, TNode P, TNode L, TNode R) {
        this.data = data;
        this.left = L;
        this.right = R;
        this.parent = P;
        this.balance = balance;
    }

    // GETTERS
    /**
     * Getter for data
     * @return data
     */
    public int getData()     { return this.data; }

    /**
     * Getter for left
     * @return left
     */
    public TNode getLeft()   { return this.left; }

    /**
     * Getter for right
     * @return right
     */
    public TNode getRight()  { return this.right; }

    /**
     * Getter for parent
     * @return parent
     */
    public TNode getParent() { return this.parent; }

    /**
     * Getter for balance
     * @return balance
     */
    public int getBalance()  { return this.balance; }

    // SETTERS
    /**
     * Setter for data
     * @param data
     */
    public void setData(int data)       { this.data = data; }

    /**
     * Setter for left
     * @param left
     */
    public void setLeft(TNode L)        { this.left = L; }

    /**
     * Setter for right
     * @param right
     */
    public void setRight(TNode R)       { this.right = R; }

    /**
     * Setter for parent
     * @param parent
     */
    public void setParent(TNode P)      { this.parent = P; }

    /**
     * Setter for balance
     * @param balance
     */
    public void setBalance(int balance) { this.balance = balance; }

    /**
     * Prints the node information to console in a user-friendly format
     */
    public void print() {
        System.out.println("Node data: " + data);
        if (left != null) {
            System.out.println("Left child: " + left.getData());
        } else {
            System.out.println("No left child");
        }
        if (right != null) {
            System.out.println("Right child: " + right.getData());
        } else {
            System.out.println("No right child");
        }
        if (parent != null) {
            System.out.println("Parent: " + parent.getData());
        } else {
            System.out.println("No parent");
        }
        System.out.println("Balance: " + balance);
    }

    /**
     * toString() converts the int data to a string
     * @return this.data converted to a string
     */
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
} // End of class declaration
