package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is a binary tree data structure.
 */
public class BinaryTree {

    /**
     * The root node in the binary tree.
     */
    private Node root;

    /**
     * Constructor.
     * @param root The root node of the tree.
     */
    public BinaryTree(Node root) {
        this.root = root;
    }

    /**
     * Returns an array of nodes as a list using depth first pre-order search.
     * @return The array of nodes.
     */
    public Node[] preOrder() {
        ArrayList<Node> list = preOrder(root);
        return list.toArray(new Node[0]);//Java 6 or later recommends new Node[0] over new Node[list.size()] (more thread safe and more efficient
    }

    /**
     * Returns an array of nodes as a list using depth first in-order search.
     * @return The array of nodes.
     */
    Node[] inOrder() {
        ArrayList<Node> list = inOrder(root);
        return list.toArray(new Node[0]);//Java 6 or later recommends new Node[0] over new Node[list.size()] (more thread safe and more efficient
    }

    /**
     * Returns an array of nodes as a list using depth first post-order search.
     * @return The array of nodes.
     */
    Node[] postOrder() {
        ArrayList<Node> list = postOrder(root);
        return list.toArray(new Node[0]);//Java 6 or later recommends new Node[0] over new Node[list.size()] (more thread safe and more efficient
    }

    /**
     * Paraphrasing/interpreting wiki pages: https://en.wikipedia.org/wiki/Tree_traversal
     * Returns an ArrayList of Node instances ordered according to a depth first search.
     * 'Pre-Order': list of nodes in order of when they were first visited.
     * @param node The root node in which to perform the search.
     * @return The pre-ordered list of Nodes.
     */
    private static ArrayList<Node> preOrder(Node node) {
        ArrayList<Node> returnList = new ArrayList<>();
        if (node == null) {
            return returnList;
        }
        returnList.add(node);
        returnList.addAll(preOrder(node.getLeftChildNode()));
        returnList.addAll(preOrder(node.getRightChildNode()));
        return returnList;
    }

    /**
     * Paraphrasing/interpreting wiki pages: https://en.wikipedia.org/wiki/Tree_traversal
     * Returns an ArrayList of Node instances ordered according to a depth first search.
     * 'In-Order': list of nodes in order of when they were first visited.
     * @param node The root node in which to perform the search.
     * @return The in-ordered list of Nodes.
     */
    private static ArrayList<Node> inOrder(Node node) {
        ArrayList<Node> returnList = new ArrayList<>();
        if (node == null) {
            return returnList;
        }
        returnList.addAll(inOrder(node.getLeftChildNode()));
        returnList.add(node);
        returnList.addAll(inOrder(node.getRightChildNode()));
        return returnList;
    }

    /**
     * Paraphrasing/interpreting wiki pages: https://en.wikipedia.org/wiki/Tree_traversal
     * Returns an ArrayList of Node instances ordered according to a depth first search.
     * 'Post-Order': list of nodes in order of when they were last visited.
     * @param node The root node in which to perform the search.
     * @return The post-ordered list of Nodes.
     */
    private static ArrayList<Node> postOrder(Node node) {
        ArrayList<Node> returnList = new ArrayList<>();
        if (node == null) {
            return returnList;
        }
        returnList.addAll(postOrder(node.getLeftChildNode()));
        returnList.addAll(postOrder(node.getRightChildNode()));
        returnList.add(node);
        return returnList;
    }

    /**
     * Returns the maximum value in the tree.
     */
    public Node findMaximumValue() {
        //TODO
        return null;
    }

    /**
     * Performs a bredth-first traversal, and returns the nodes in order.
     * @return The array of nodes found according to breadth first tree traversal.
     */
    public Node[] breadthFirst() {
        ArrayList<Node> list = breadthFirst(root);
        return list.toArray(new Node[0]);
    }

    /**
     * Returns the array list of nodes from breadth first traversal.
     * @param node The input root node.
     * @return The array list of nodes.
     */
    private ArrayList<Node> breadthFirst(Node node) {
        // This was very helpful:
        // https://www.cs.bu.edu/teaching/c/tree/breadth-first/
        ArrayList<Node> returnList = new ArrayList<>();
        if (node == null) {
            return returnList;
        }

        LinkedList<Node> helperQueue = new LinkedList<Node>();
        helperQueue.add(node);
        while (helperQueue.size() > 0) {
            Node traverseNode = helperQueue.poll();
            returnList.add(traverseNode);

            if (traverseNode.getLeftChildNode() != null) {
                helperQueue.add(traverseNode.getLeftChildNode());
            }
            if (traverseNode.getRightChildNode() != null) {
                helperQueue.add(traverseNode.getRightChildNode());
            }
        }
        return returnList;
    }

    /**
     * Getter.
     * @return The root of the tree.
     */
    public Node getRoot() {
        return root;
    }
}
