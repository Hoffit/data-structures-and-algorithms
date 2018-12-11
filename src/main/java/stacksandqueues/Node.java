package stacksandqueues;

/**
 * This is a node class for data structures, like linked lists, stacks, and queues.
 * It consists of two parts:
 * - a value
 * - next node
 */
public class Node {

    /**
     * The next node.
     */
    private Node nextNode;

    /**
     * The value of this node.
     */
    private String value;

    /**
     * Creates a new Node with the specified parameters.
     * @param aValue The value stored in the Node. Must be non-null.
     * @param nextNode A reference to the next Node. Null is ok.
     */
    Node(String aValue, Node nextNode) {
        if (aValue == null) {
            System.out.print("Error: invalid input. aValue must be a non-null value.");
        }
        this.value = aValue;
        this.nextNode = nextNode;
    }

    /**
     * Returns the next Node.
     * @return The next node. May be null.
     */
    protected Node getNextNode() {
        return nextNode;
    }

    /**
     * Set the next node.
     * @param nextNode The node that follows this node in the chain. May be null.
     */
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Returns the value of this node. May be an empty String.
     * @return Returns the value contained in this node.
     */
    public String getValue() {
        return value;
    }
}
