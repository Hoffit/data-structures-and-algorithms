package tree;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BinaryTreeTest {

    //A testable binary tree.
    BinaryTree tree = new BinaryTree(createBinaryTree());
    BinarySearchTree searchTreeJ = new BinarySearchTree(createBinaryTree());
    BinarySearchTree searchTreeH = new BinarySearchTree(createAnotherBinaryTree());
    BinarySearchTree searchTreeC = new BinarySearchTree(createAnotherAnotherBinaryTree());

    @Test
    public void testBinaryTreePreOrderMethod() {
        Node[] expected = new Node[] {
                new Node("F", null, null),
                new Node("B", null, null),
                new Node("A", null, null),
                new Node("D", null, null),
                new Node("C", null, null),
                new Node("E", null, null),
                new Node("G", null, null),
                new Node("I", null, null),
                new Node("H", null, null)
        };
        Node[] nodes = tree.preOrder();
        for (int i = 0; i < expected.length; i++) {
            assertTrue(nodes[i].getValue().equals(expected[i].getValue()));
        }
    }

    @Test
    public void testBinaryTreeInOrderMethod() {
        Node[] expected = new Node[] {
                new Node("A", null, null),
                new Node("B", null, null),
                new Node("C", null, null),
                new Node("D", null, null),
                new Node("E", null, null),
                new Node("F", null, null),
                new Node("G", null, null),
                new Node("H", null, null),
                new Node("I", null, null)
        };
        Node[] nodes = tree.inOrder();
        for (int i = 0; i < expected.length; i++) {
            assertTrue(nodes[i].getValue().equals(expected[i].getValue()));
        }
    }

    @Test
    public void testBinaryTreePostOrderMethod() {
        Node[] expected = new Node[] {
                new Node("A", null, null),
                new Node("C", null, null),
                new Node("E", null, null),
                new Node("D", null, null),
                new Node("B", null, null),
                new Node("H", null, null),
                new Node("I", null, null),
                new Node("G", null, null),
                new Node("F", null, null)
        };
        Node[] nodes = tree.postOrder();
        for (int i = 0; i < expected.length; i++) {
            assertTrue(nodes[i].getValue().equals(expected[i].getValue()));
        }
    }

    @Test
    public void testBinarySearchTreeAddMethod_J() {
        searchTreeJ.addNode(new Node("J", null, null));
        Node[] nodes = (new BinaryTree(searchTreeJ.getRoot())).preOrder();
        assertTrue(nodes[9].compareTo(new Node("J", null, null))==0);
    }

    @Test
    public void testBinarySearchTreeAddMethod_H() {
        searchTreeH.addNode(new Node("H", null, null));
        Node[] nodes = (new BinaryTree(searchTreeH.getRoot())).preOrder();
        assertTrue(nodes[8].compareTo(new Node("H", null, null))==0);
    }

    @Test
    public void testBinarySearchTreeAddMethod_C() {
        searchTreeC.addNode(new Node("C", null, null));
        Node[] nodes = (new BinaryTree(searchTreeC.getRoot())).preOrder();
        assertTrue(nodes[4].compareTo(new Node("C", null, null))==0);
    }

    @Test
    public void testBinarySearchTreeSearchMethod() {
        //Check a not found scenario
        assertNull(searchTreeJ.search(new Node("J", null, null)));

        // Check 3 different search scenarios...each should find a result.
        searchTreeJ.addNode(new Node("J", null, null));
        Node jNode = searchTreeJ.search(new Node("J", null, null));
        assertTrue(jNode.compareTo(new Node("J", null, null)) == 0);
        searchTreeH.addNode(new Node("H", null, null));
        Node hNode = searchTreeH.search(new Node("H", null, null));
        assertTrue(hNode.compareTo(new Node("H", null, null)) == 0);
        searchTreeC.addNode(new Node("C", null, null));
        Node cNode = searchTreeC.search(new Node("C", null, null));
        assertTrue(cNode.compareTo(new Node("C", null, null)) == 0);
    }

    @Test
    public void testBreadthFirstTraversalMethod() {
        //Test a null tree scenario
        BinaryTree tree = new BinaryTree(null);
        Node[] nodes = tree.breadthFirst();
        assertNotNull(nodes);
        assertTrue(nodes.length == 0);

        //Test a single node tree edge case
        BinaryTree tree2 = new BinaryTree(new Node("X", null, null));
        Node[] moreNodes = tree2.breadthFirst();
        assertNotNull(nodes);
        assertTrue(moreNodes.length == 1);
        assertTrue(moreNodes[0].getValue().equals("X"));

        //Test on our wiki based binary tree example
        nodes = null;//whack prior instance to prevent accidental side effects
        tree = new BinaryTree(createBinaryTree());
        Node[] expected = new Node[] {
                new Node("F", null, null),
                new Node("B", null, null),
                new Node("G", null, null),
                new Node("A", null, null),
                new Node("D", null, null),
                new Node("I", null, null),
                new Node("C", null, null),
                new Node("E", null, null),
                new Node("H", null, null)
        };
        nodes = tree.breadthFirst();
        for (int i = 0; i < expected.length; i++) {
            assertTrue(nodes[i].getValue().equals(expected[i].getValue()));
        }
    }

    /**
     * Using wiki example to test some stuff:
     * https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_(NLR)
     * @return The root binary tree node.
     */
    private Node createBinaryTree() {
        Node leftNode = new Node("B", new Node("A", null, null), new Node("D", new Node("C", null, null), new Node("E", null, null)));
        Node rightNode = new Node("G", null, new Node("I", new Node("H", null, null), null));
        return new Node("F", leftNode, rightNode);
    }

    /**
     * Using wiki example to test some stuff:
     * https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_(NLR)
     * @return The root binary tree node.
     */
    private Node createAnotherBinaryTree() {
        Node leftNode = new Node("B", new Node("A", null, null), new Node("D", new Node("C", null, null), new Node("E", null, null)));
        Node rightNode = new Node("G", null, new Node("I", null, new Node("J", null, null)));
        return new Node("F", leftNode, rightNode);
    }

    /**
     * Using wiki example to test some stuff:
     * https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_(NLR)
     * @return The root binary tree node.
     */
    private Node createAnotherAnotherBinaryTree() {
        Node leftNode = new Node("B", new Node("A", null, null), new Node("D", null, new Node("E", null, null)));
        Node rightNode = new Node("G", null, new Node("I", null, new Node("J", null, null)));
        return new Node("F", leftNode, rightNode);
    }
}
