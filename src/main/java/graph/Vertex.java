package graph;

import java.util.ArrayList;

/**
 * A Vertex in a graph data structure.
 * Consists of a list of edges, together with a value T.
 */
public class Vertex<T> implements Comparable<T> {

    /**
     * The list of neighbors.
     */
    private final ArrayList<Edge> neighbors = new ArrayList<>();

    /**
     * The value of this vertex.
     */
    private T value;

    /**
     * Vertex constructor.
     * @param aValue The vertex value.
     */
    public Vertex(T aValue) {
        this.value = aValue;
    }

    /**
     * Returns the value of this vertex.
     * @return Returns the value contained in this vertex.
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value of this vertex.
     * @param value The new value.
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Vertex implementation of compareTo.
     * TODO
     */
    @Override
    public int compareTo(T o) {
        return 0;
    }

    public ArrayList<Edge> getNeighbors() {
        return neighbors;
    }
}
