package graph;

/**
 * An edge in a graph data structure.
 * Consists of a weight, together with left and right vertices.
 */
public class Edge {

    /**
     * This edge's weight.
     */
    private int weight;

    /**
     * The left vertex of this edge.
     */
    private Vertex leftVertex;

    /**
     * The right vertex of this edge.
     */
    private Vertex rightVertex;


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
    }
}
