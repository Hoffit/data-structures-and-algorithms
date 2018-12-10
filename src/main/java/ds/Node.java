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
     * @param aValue The value stored in the Node. Must be non-null.
     * @param nextNode A reference to the next Node in the list. Null is ok.
     */
    Node(String aValue, Node nextNode) throws IllegalArgumentException {

        if (aValue == null) {
            throw new IllegalArgumentException("");
        }
        this.value = aValue;
        this.nextNode = nextNode;
    }

    /**
     * Returns the value of this node. May be an empty String.
     * @return Returns the value contained in this node.
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

    /**
     * Set the next node.
     * @param nextNode The node that follows this node in the chain.
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
