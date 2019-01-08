package graph;

/**
 * An edge in a graph data structure.
 * Consists of a weight, together with left and right vertices.
 */
public class Edge<T> {

    /**
     * This edge's weight.
     */
    private int weight;

    /**
     * The left vertex of this edge.
     */
    private Vertex<T> leftVertex;

    /**
     * The right vertex of this edge.
     */
    private Vertex<T> rightVertex;


    /**
     * Constructor. Weight set to 0.
     * @param leftVertex The new edge's left vertex.
     * @param rightVertex The new edge's right vertex.
     * @throws IllegalArgumentException If either vertex is null.
     */
    public Edge(Vertex leftVertex, Vertex rightVertex) {
        if (leftVertex == null || rightVertex == null) {
            throw new IllegalArgumentException("Error: can't create edge when one or both vertices are null");
        }

        this.leftVertex = leftVertex;
        this.rightVertex = rightVertex;
        this.weight = 0;
    }

    /**
     * Constructor.
     * @param leftVertex The new edge's left vertex.
     * @param rightVertex The new edge's right vertex.
     * @param weight The new edge's weight.
     * @throws IllegalArgumentException If either vertex is null.
     */
    public Edge(Vertex leftVertex, Vertex rightVertex, int weight) {
        if (leftVertex == null || rightVertex == null) {
            throw new IllegalArgumentException("Error: can't create edge when one or both vertices are null");
        }

        this.leftVertex = leftVertex;
        this.rightVertex = rightVertex;
        this.weight = weight;

        leftVertex.addNeighbor(this);
        rightVertex.addNeighbor(this);
    }

    /**
     * Given one end of the edge, returns the other.
     * @param vertex One vertex endpoint of the edge.
     * @return The other end.
     * @throws IllegalArgumentException In case param vertex is not in the edge.
     */
    public Vertex<T> getOtherEnd(Vertex<T> vertex) {
        if(leftVertex != vertex && rightVertex != vertex) {
            throw new IllegalArgumentException("Error: vertex is not a part of this edge");
        }

        if (leftVertex == vertex) {
            return rightVertex;
        }
        else {
            return leftVertex;
        }
    }
}
