package ds;

/**
 * This class represents a Node data element that consists of a value,
 * and a reference to the next object linked in the chain.
 */
public class Node {

    private Node nextNode;
    private String value;

    /**
     * Creates a new Node with the specified parameters.
     * @param value The value stored in the Node.
     * @param nextNode A reference to the next Node in the list.
     */
    Node(String value, Node nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    /**
     * Returns the value of this node. May be an empty String.
     * @return
     */
    protected String getValue() {
        return value;
    }

    /**
     * Returns the next Node in the LinkedList.
     * @return The next node. May be null.
     */
    protected Node getNextNode() {
        return nextNode;
    }
}
