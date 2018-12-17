package tree;

import org.junit.Test;

import java.util.ArrayList;

public class BinaryTreeTest {

    @Test
    public void testBinaryTreePreOrderMethod() {
        ArrayList<Node> nodes = BinaryTree.preOrder(createBinaryTree());
        System.out.println();
    }

    /**
     * Using wiki example to test some stuff:
     * https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_(NLR)
     * @return
     */
    private Node createBinaryTree() {
        Node leftNode = new Node("B", new Node("A", null, null), new Node("D", new Node("C", null, null), new Node("E", null, null)));
        Node rightNode = new Node("G", null, new Node("I", new Node("H", null, null), null));
        Node rootNode = new Node("F", leftNode, rightNode);
        return rootNode;
    }
}
