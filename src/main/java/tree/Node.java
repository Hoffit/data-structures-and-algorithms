package tree;

/**
 * This is a node class for a binary tree data structure.
 * It consists of three parts:
 * - a value object
 * - left child node
 * - right child node
 */
public class Node<T> implements Comparable<T> {

    /**
     * The child left node.
     */
    private Node leftChildNode;

    /**
     * The child right node.
     */
    private Node rightChildNode;

    /**
     * The value of this node.
     */
    private T value;

    /**
     * Node constructor.
     * @param aValue The node value.
     * @param leftChildNode The left child node. May be null.
     * @param rightChildNode The right child node. May be null.
     */
    Node(T aValue, Node leftChildNode, Node rightChildNode) {
        this.value = aValue;
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
    }

    /**
     * Returns the left child Node.
     * @return The left node. May be null.
     */
    Node getLeftChildNode() {
        return leftChildNode;
    }

    /**
     * Set the left child node.
     * @param leftChildNode The left child node. May be null.
     */
    public void setLeftChildNode(Node leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    /**
     * Returns the right child Node.
     * @return The right node. May be null.
     */
    Node getRightChildNode() {
        return rightChildNode;
    }

    /**
     * Set the right child node.
     * @param rightChildNode The right child node. May be null.
     */
    public void setRightChildNode(Node rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    /**
     * Returns the value of this node.
     * @return Returns the value contained in this node.
     */
    public T getValue() {
        return value;
    }

    /**
     * Node implementation of compareTo
     */
    @Override
    public int compareTo(T o) {
        if (value instanceof String) {
            String oValue = (String)((Node)o).getValue();
            return ((String)value).compareTo(oValue);
        }
        if (value instanceof Integer) {
            Integer oValue = (Integer)o;
            return ((Integer)value).compareTo(oValue);
        }
        return 0;
    }
}
