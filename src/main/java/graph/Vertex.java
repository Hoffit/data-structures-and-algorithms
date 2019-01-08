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
        if (aValue == null) {
            throw new IllegalArgumentException("Error: vertex value must be non-null!");
        }
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

    /**
     * Returns the neighbors of this vertex.
     * @return The list of neighbors.
     */
    public ArrayList<Edge> getNeighbors() {
        return neighbors;
    }

    /**
     * Add's the neighbor tEdge to this vertices' list.
     * @param tEdge The edge to add to the neighbords list.
     * @param <T> The Type.
     */
    public <T> void addNeighbor(Edge<T> tEdge) {
        neighbors.add(tEdge);
    }
}
