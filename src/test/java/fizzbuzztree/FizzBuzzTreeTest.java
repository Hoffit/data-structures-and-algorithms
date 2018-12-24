package fizzbuzztree;

import org.junit.Test;
import tree.BinaryTree;
import tree.Node;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertTrue;

public class FizzBuzzTreeTest {

        //A testable binary tree.
        BinaryTree tree = new BinaryTree(createBinaryTree());

        // F/4 B/3 A/5 D/15 C/30 E/2 G/8 I/13 H/101

        @Test
        public void testBinaryTreeFizzBuzzMethod() {
            Node[] expected = new Node[] {
                new Node(4, null, null),
                new Node("Fizz", null, null),
                new Node("Buzz", null, null),
                new Node("FizzBuzz", null, null),
                new Node("FizzBuzz", null, null),
                new Node(2, null, null),
                new Node(8, null, null),
                new Node(13, null, null),
                new Node(101, null, null)
            };
            FizzBuzzTree.fizzBizzTree(tree);
            Node[] nodes = tree.preOrder();
            for (int i = 0; i < expected.length; i++) {
                assertTrue(nodes[i].getValue().equals(expected[i].getValue()));
            }
        }

    @Test
    public void testBinaryTreeFizzBuzzMethod_edges() {
        Node[] expected = new Node[] {
                new Node(4, null, null),
                new Node("Fizz", null, null),
                new Node("Buzz", null, null),
                new Node("FizzBuzz", null, null),
                new Node("FizzBuzz", null, null),
                new Node(2, null, null),
                new Node(8, null, null),
                new Node(13, null, null),
                new Node(101, null, null)
        };
        tree = null;
        FizzBuzzTree.fizzBizzTree(tree);
        assertNull(tree);

        tree = new BinaryTree(null);
        FizzBuzzTree.fizzBizzTree(tree);
        assertNull(tree.getRoot());

        tree = new BinaryTree(new Node(null, null, null));
        FizzBuzzTree.fizzBizzTree(tree);
        assertNull(tree.getRoot().getValue());
    }

    /**
     * Using wiki example to test some stuff:
     * https://en.wikipedia.org/wiki/Tree_traversal#Pre-order_(NLR)
     * @return The root binary tree node.
     */
    private Node createBinaryTree() {
        Node leftNode = new Node(3, new Node(5, null, null), new Node(15, new Node(30, null, null), new Node(2, null, null)));
        Node rightNode = new Node(8, null, new Node(13, new Node(101, null, null), null));
        return new Node(4, leftNode, rightNode);
    }
}
