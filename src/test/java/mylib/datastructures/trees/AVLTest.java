/**
@author  Batool Hussaini Syeda & Teresa Lavoie
@version 1.9
@since   1.0
*/
package mylib.datastructures.trees;

import org.junit.Test;
import mylib.datastructures.nodes.TNode;
import static org.junit.Assert.*;


public class AVLTest {

    @Test
    public void testAVLInsert() {
        AVL avl = new AVL(); 
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);

        assertEquals(4, avl.getRoot().getData());
        assertEquals(2, avl.getRoot().getLeft().getData());
        assertEquals(6, avl.getRoot().getRight().getData());
        assertEquals(1 , avl.getRoot().getLeft().getLeft().getData());
        assertEquals(3 , avl.getRoot().getLeft().getRight().getData());
        assertEquals(5 , avl.getRoot().getRight().getLeft().getData());
        assertEquals(7 , avl.getRoot().getRight().getRight().getData());
    }
    @Test
    public void testAVLDelete() {
        AVL avl = new AVL(); 
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);

        avl.delete(2);
        // AVL should be balanced
        assertNotNull(avl.search(4));
        assertNotNull(avl.search(6));
        assertNotNull(avl.search(1));
        assertNotNull(avl.search(3));
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(7));
        assertNull(avl.search(2));
    }

    @Test
    public void testAVLSearch() {
        AVL avl = new AVL(); 
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);
        TNode result = avl.search(3);
        assertEquals(3, result.getData());
    }

    @Test
    public void testAVLBalance() {
        AVL avl = new AVL();
        avl.insert(4);
        avl.insert(2);
        avl.insert(6);
        avl.insert(1);
        avl.insert(3);
        avl.insert(5);
        avl.insert(7);
        TNode root = avl.getRoot();
        assertEquals(0, avl.balanceFactor(root));
        assertEquals(0, avl.balanceFactor(root.getLeft()));
        assertEquals(0, avl.balanceFactor(root.getRight()));
    }

/**
 * 4 cases of insertion tests (Left, Right, Rightleft, Leftright)
 */
    @Test
    public void testLeftRotation() {
        AVL avl = new AVL();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);

        assertEquals(2, avl.getRoot().getData());
        assertEquals(1, avl.getRoot().getLeft().getData());
        assertEquals(3, avl.getRoot().getRight().getData());
    }

    @Test
    public void testRightRotation() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(2);

        assertEquals(3, avl.getRoot().getData());
        assertEquals(2, avl.getRoot().getLeft().getData());
        assertEquals(5, avl.getRoot().getRight().getData());
    }
    
    @Test
    public void testRightLeftRotation() {
        AVL avl = new AVL();
        avl.insert(3);
        avl.insert(1);
        avl.insert(2);

        assertEquals(2, avl.getRoot().getData());
        assertEquals(1, avl.getRoot().getLeft().getData());
        assertEquals(3, avl.getRoot().getRight().getData());
    }

    @Test
    public void testLeftRightRotation() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(2);

        assertEquals(3, avl.getRoot().getData());
        assertEquals(2, avl.getRoot().getLeft().getData());
        assertEquals(5, avl.getRoot().getRight().getData());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(6);
        avl.delete(7); // Deleting a node with one child
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(3));
        assertNotNull(avl.search(6));
        assertNull(avl.search(7));
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        avl.insert(8);
        avl.delete(7); // Deleting a node with two children
       
        assertNotNull(avl.search(2));
        assertNotNull(avl.search(3));
        assertNotNull(avl.search(4));
        assertNotNull(avl.search(5));
        assertNotNull(avl.search(6));
        assertNotNull(avl.search(8));
    }
    
    @Test
    public void testDuplicateInsertion() {
        AVL avl = new AVL();
        avl.insert(5);
        avl.insert(3);
        avl.insert(7);
        avl.insert(5);

        assertNull(avl.search(4));
        assertEquals(5, avl.getRoot().getData());
        assertEquals(3, avl.getRoot().getLeft().getData());
        assertEquals(7, avl.getRoot().getRight().getData());
    }
   
} // End of class declaration
