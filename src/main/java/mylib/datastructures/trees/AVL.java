package mylib.datastructures.trees;

import java.util.Stack;

import mylib.datastructures.nodes.TNode;

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
     * Overloaded Constructor
     * @param val - value of node
     */
    public AVL(int val) {
       super(val);
        
    }

    /**
     * Overloaded Constructor - constructor performs a self balancing algorithim on the tree when setting a node = root
     * @param node - node to set equal to root
     */
    public AVL(TNode node) {
        this.root = null;
        if (node.getLeft() != null || node.getRight() != null) {
            TNode temp = node;
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
            this.root = node;
        }
    }

    /**
     * getRoot() - getter method for root
     * @return - root
     */
    public TNode getRoot() {
        return this.root;
    }

    /**
     * setRoot() - setter method for root
     * @param node - node to set root
     */
    public void setRoot(TNode node) {
        this.root = node;
        if (node.getLeft() != null || node.getRight() != null) {
            root = balanceTree(node);
        }
    }

    /**
     * insert() - inserts a node into the tree then balances the tree
     * @param val - integer value for node
     */
    public void insert(int val) {
        this.root = insert(this.root, val);
    }

/**
 * insert() - inserts a node into the tree then balances the tree
 * @param node - node to insert into the tree
 * @param val - value to insert
 * @return - root node of the balanced tree
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
 * Helper method to calculate the height of a node in the AVL tree
 * @param node - the node whose height is to be calculated
 * @return - height of the node
 */
private int height(TNode node) {
    if (node == null) {
        return -1;
    }
    return node.getBalance();
}

/**
 * Helper method to calculate the balance factor of a node in the AVL tree
 * @param node - the node whose balance factor is to be calculated
 * @return - balance factor of the node
 */
protected int balanceFactor(TNode node) {
    if (node == null) {
        return 0;
    }
    return height(node.getLeft()) - height(node.getRight());
}

/**
 * Helper method to perform a right rotation on a node in the AVL tree
 * @param node - the node to be rotated
 * @return - the new root node after rotation
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
 * Helper method to perform a left rotation on a node in the AVL tree
 * @param node - the node to be rotated
 * @return - the new root node after rotation
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
     * delete() - call delete with root node
     * @param value - value of node to be deleted
     */
    @Override
    public void delete(int value) {
        this.root = delete(this.root, value);
    }

    /**
 * delete() - delete the node with the matching value
 * @param node - root node of tree to delete
 * @param value - value to delete
 * @return - new balanced tree with deleted node
 */
public TNode delete(TNode node, int value) {
    if (node == null) {
        return node;
    }

    if (node.getData() > value) { // node < value
        node.setLeft(delete(node.getLeft(), value));
    } else if (node.getData() < value) { // node > value
        node.setRight(delete(node.getRight(), value));
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
     * calls parent class search method
     * 
     * @return - node with value in the tree.
     */
    public TNode search(int val) {
        return super.search(val);
    }

    /**
     * printInOrder() - calls parent method
     */
    public void printInOrder() {
        super.printInOrder();
    }

    /**
     * printBF() - calls parent method
     */
    public void printBF() {
        super.printBF();
    }

    /**
     * minValue() - private helper function to find minvalue of a tree
     * @param node - node to find minvalues of
     * @return - returns the min value
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
     * balanceTree() - private helper function that balances the tree 
     * @param node - node to perform the balance on
     * @return - returns a balanced subtree for the given node
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
}// End of class declaration
