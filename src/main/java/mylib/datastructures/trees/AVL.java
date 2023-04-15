/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.8
@since   1.0
*/

package mylib.datastructures.trees;

import mylib.datastructures.nodes.TNode;
import java.util.Stack;

/**
 * AVL class for a self balancing binary tree
 */
public class AVL extends BST {
    /**
     * Default Constructor
     */
    public AVL() {
        super();
    }

    /**
     * Overloaded Constructor 1
     * @param val int value to be set within root TNode
     */
    public AVL(int val) {
       super(val);
        
    }

    /**
     * Overloaded Constructor 2 
        * self balancing algorithim on the tree when setting a this.root = root
     * @param root a Tnode object
     */
    public AVL(TNode root) {
        this.root = null;
        if (root.getLeft() != null || root.getRight() != null) {
            TNode temp = root;
            Stack<TNode> stack = new Stack<TNode>();

            while (temp != null || !stack.isEmpty()) {
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.getLeft();
                }

                temp = stack.pop();
                insert(temp.getData());

                temp = temp.getRight();
            }
        } else {
            this.root = root;
        }
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
        if (root.getLeft() != null || root.getRight() != null) {
            root = balanceTree(root);
        }
    }

    /**
     * Inserts a node into the tree 
        * then balances the tree
     * @param val - integer value for node
     */
    public void insert(int val) {
        this.root = insert(this.root, val);
    }

    /**
     * Inserts a node into the tree
        * then balances the tree
     * @param node to insert into the tree
     * @param val int value to insert
     * @return root node of the balanced tree
     */
    public TNode insert(TNode node, int val) {
        if (node == null) {
            return new TNode(val, 0, null, null, null);
        }

        if (node.getData() > val) {
            node.setLeft(insert(node.getLeft(), val));
        } else if (node.getData() < val) {
            node.setRight(insert(node.getRight(), val));
        } else {
            return node;
        }

        node.setBalance(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        int balance = balanceFactor(node);
        if (balance > 1) {
            if (node.getLeft().getData() > val) {
                return rotateRight(node);
            } else if (node.getLeft().getData() < val) {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }
        if (balance < -1) {
            if (node.getRight().getData() < val) {
                return rotateLeft(node);
            } else if (node.getRight().getData() > val) {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
        return node;
    }

    /**
     * Private helper method to calculate the height of a node in the AVL tree
     * @param node a TNode object whose height is to be calculated
     * @return height of the node
     */
    private int height(TNode node) {
        if (node == null) {
            return -1;
        }
        return node.getBalance();
    }

    /**
     * Protected helper method (due to testing) to calculate the balance factor of a node
     * @param node a TNode object whose balance factor is to be calculated
     * @return balance factor of the node
     */
    protected int balanceFactor(TNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    /**
     * Private helper method to perform a right rotation on a node in the AVL tree
     * @param node a TNode object to be rotated
     * @return the new root node after rotation
     */
    private TNode rotateRight(TNode node) {
        TNode newRoot = node.getLeft();
        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        node.setBalance(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        newRoot.setBalance(1 + Math.max(height(newRoot.getLeft()), height(newRoot.getRight())));
        return newRoot;
    }

    /**
     * Private helper method to perform a left rotation on a node in the AVL tree
     * @param node a TNode object to be rotated
     * @return the new root node after rotation
     */
    private TNode rotateLeft(TNode node) {
        TNode newRoot = node.getRight();
        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        node.setBalance(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        newRoot.setBalance(1 + Math.max(height(newRoot.getLeft()), height(newRoot.getRight())));
        return newRoot;
    }

    /**
     * Deletes by calling delete with root node
     * @param value - value of node to be deleted
     */
    @Override
    public void delete(int value) {
        this.root = delete(this.root, value);
    }

    /**
     * Private helper function for delete() to delete the node with val
     * @param node - root node of tree to delete
     * @param val int value to be delete
     * @return new balanced tree with deleted node
     */
    private TNode delete(TNode node, int val) {
        if (node == null) {
            return node;
        }
        if (node.getData() > val) { // node < value
            node.setLeft(delete(node.getLeft(), val));
        } else if (node.getData() < val) { // node > value
            node.setRight(delete(node.getRight(), val));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                TNode finder;
                if (node.getLeft() != null) {
                    finder = node.getLeft();
                } else {
                    finder = node.getRight();
                }

                if (finder == null) {
                    finder = node;
                    node = null;
                } else {
                    node = finder;
                }
            } else {
                int finder = minValue(node.getRight());
                node.setData(finder);
                node.setRight(delete(node.getRight(), finder));
            }
        }
        node = balanceTree(node);
        return node;
    }

    /**
     * Private helper function to find minvalue of a tree
     * @param node a TNode object to find minvalues of
     * @return the min value
     */
    private int minValue(TNode node) {
        int minValue = node.getData();
        while (node.getLeft() != null) {
            minValue = node.getLeft().getData();
            node = node.getLeft();
        }
        return minValue;
    }

    /**
     * Private helper function that balances the tree 
     * @param node a TNode object to perform the balance on
     * @return a balanced subtree for the node parameter
     */
    private TNode balanceTree(TNode node) {
        if (node == null) {
            return null;
        }

        int balance = balanceFactor(node);

        if (balance < -1) {
            if (balanceFactor(node.getRight()) <= 0) { // val > right
                return rotateLeft(node);
            } else { // val < right
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        }
        if (balance > 1) {
            if (balanceFactor(node.getLeft()) >= 0) { // val < left
                return rotateRight(node);
            } else { 
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            }
        }
        return node;
    } 
} // End of class declaration
