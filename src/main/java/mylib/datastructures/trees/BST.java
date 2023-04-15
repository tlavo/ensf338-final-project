/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.2
@since   1.0
*/

package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BST class for a binary search tree
 */
public class BST {
    protected TNode root; // references the root of the tree

    /**
     * Default Constructor
     */
    public BST() {
        this.root = null;
    }

    /**
     * Overloaded Constructor 1
     * @param val int value to be set within root TNode
     */
    public BST(int val) {
        this.root = new TNode(val, 0, null, null, null);  
    }

    /**
     * Overloaded Constructor 2
     * @param root a TNode object
     */
    public BST(TNode root) {
        this.root = root;
    }
    
    /**
     * Getter for root
     * @return root
     */
    public TNode getRoot() {
        return this.root;
    }

    /**
     * Setter for root
     * @param root
     */
    public void setRoot(TNode root) {
        this.root = root;
    }

    /**
     * Creates a new node with data val to be inserted into the tree
     * @param val int value to be inserted into a new node
     */
    public void insert(int val) {
        TNode newNode = new TNode(val, 0, null, null, null);
        if (root == null) {
            root = newNode;
        } else {
            TNode current = root;
            TNode parent = null;
            while (true) {
                parent = current;
                if (val < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        newNode.setParent(parent);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        newNode.setParent(parent);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Inserts the node passed as argument into the tree
     * @param node a TNode object
     */
    public void insert(TNode node) {
        if (root == null) {
            root = node;
        } else {
            TNode current = root;
            TNode parent = null;
            while (true) {
                parent = current;
                if (node.getData() < current.getData()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(node);
                        node.setParent(parent);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(node);
                        node.setParent(parent);
                        return;
                    }
                }
            }
        }
    }

    /**
     * Finds the node with val as data and deletes it;
     * if not found prints a statement that the value is not in the tree
     * @param val int value of data of node to be deleted 
     */
    public void delete(int val) {
        root = deleteNode(root, val);
    }

    /**
     * Helper function to delete(int val) using recursion
     * @param node the current node being considered
     * @param val the value to be deleted
     * @return the updated tree with the specified node deleted
     */
    private TNode deleteNode(TNode node, int val) {
        if (node == null) {
            System.out.println("Value not found in the tree.");
            return null;
        }

        if (val < node.getData()) {
            node.setLeft(deleteNode(node.getLeft(), val));
        } else if (val > node.getData()) {
            node.setRight(deleteNode(node.getRight(), val));
        } else {
            // node to be deleted has no children or only one child
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // node to be deleted has two children
            TNode minRight = findMin(node.getRight());
            node.setData(minRight.getData());
            node.setRight(deleteNode(node.getRight(), minRight.getData()));
        }
        return node;
    }

    /**
     * Helper function to delete(int val) to find the minimum node in a subtree
     * @param node the root of the subtree to search
     * @return the node with the minimum value in the subtree
     */
    private TNode findMin(TNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Searches for the node with val as data:
        * returns it or
        * returns null if not found
     * @param val int value of data of node to be found
     * @return current a TNode object or null
     */
    public TNode search(int val) {
        TNode current = root;
        while (current != null && current.getData() != val) {
            if (val < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        if (current == null || current.getData() != val) {
            return null;
        } else {
            return current;
        }
    }

    /**
     * Prints the content data of the tree in ascending order
     */
    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }
    
    /**
     * Helper function to printInOrder() using recursion
     * @param node a TNode object
     */
    private void printInOrder(TNode node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + " ");
            printInOrder(node.getRight());
        }
    }

    /**
     * Prints the content of the tree in Breadth-First order;
     * each level of the tree will be printed on a separate line
     */
    public void printBF() {
        if (root == null) {
            return;
        }

        Queue<TNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TNode current = queue.remove();
                System.out.print(current.getData() + " ");

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            System.out.println(); // Print newline after each level
        }
    }
} // End of class declaration
