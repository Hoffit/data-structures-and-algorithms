package treeintersection;

import org.junit.Test;
import tree.BinaryTree;
import tree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static junit.framework.TestCase.assertEquals;

public class TreeIntersectionTest {

    @Test
    public void testTreeIntersectionMethodOnce() {
        ArrayList<Integer> expectedResults = new ArrayList<>(Arrays.asList(100, 160, 125, 175, 200, 350, 500));
        ArrayList<Integer> intersectionResult = TreeIntersection.treeIntersection(new BinaryTree<>(createIntegerBinaryTreeOne()), new BinaryTree<>(createIntegerBinaryTreeTwo()));
        assertEquals(expectedResults, intersectionResult);
    }

    @Test
    public void testTreeIntersectionMethodTwice() {
        ArrayList<Integer> expectedResults = new ArrayList<>(Collections.singletonList(75));
        ArrayList<Integer> intersectionResult = TreeIntersection.treeIntersection(new BinaryTree<>(createIntegerBinaryTreeOne()), new BinaryTree<>(createIntegerBinaryTreeThree()));
        assertEquals(expectedResults, intersectionResult);
    }

    @Test
    public void testTreeIntersectionMethodThreeTimes() {
        ArrayList<Integer> expectedResults = new ArrayList<>(Collections.singletonList(4));
        ArrayList<Integer> intersectionResult = TreeIntersection.treeIntersection(new BinaryTree<>(createIntegerBinaryTreeTwo()), new BinaryTree<>(createIntegerBinaryTreeThree()));
        assertEquals(expectedResults, intersectionResult);
    }

    private Node createIntegerBinaryTreeOne() {
        Node leftNode = new Node(100, new Node(75,null, null), new Node(160, new Node(125, null, null), new Node(175, null, null)));
        Node rightNode = new Node(250, new Node(200, null, null), new Node(350, new Node(300, null, null), new Node(500, null, null)));
        return new Node(150, leftNode, rightNode);
    }

    private Node createIntegerBinaryTreeTwo() {
        Node leftNode = new Node(100, new Node(15,null, null), new Node(160, new Node(125, null, null), new Node(175, null, null)));
        Node rightNode = new Node(600, new Node(200, null, null), new Node(350, new Node(4, null, null), new Node(500, null, null)));
        return new Node(42, leftNode, rightNode);
    }

    private Node createIntegerBinaryTreeThree() {
        Node leftNode = new Node(7, new Node(75, null, null), new Node(6, new Node(5, null, null), new Node(11, null, null)));
        Node rightNode = new Node(75, null, new Node(9, new Node(4, null, null), null));
        return new Node(2, leftNode, rightNode);
    }
}
