package graph;

import java.util.LinkedList;

/**
 *
 */
public class Node<T> implements Comparable<T> {

    /**
     * The ordered list of neighbors.
     */
    private final LinkedList<Node> linkedList = new LinkedList();

    /**
     * The value of this node.
     */
    private T value;

    /**
     * Node constructor.
     * @param aValue The node value.
     */
    public Node(T aValue) {
        this.value = aValue;
    }

    /**
     * Returns the value of this node.
     * @return Returns the value contained in this node.
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value of this node.
     * @param value The new value.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Node implementation of compareTo.
     * TODO
     */
    @Override
    public int compareTo(T o) {
        return 0;
    }
}
