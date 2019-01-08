package graph;

import java.util.ArrayList;

/**
 * This is a graph data structure, consisting of a list of Vertex objects.
 * This was helpful in creating this data structure:
 * https://en.wikipedia.org/wiki/Adjacency_list
 */
public class Graph<T> {

    /**
     * The list of vertices belonging to this graph.
     */
    private ArrayList<Vertex> vertices = new ArrayList<>();

    /**
     * Returns an array copy of this graphs vertices.
     * @return The array of Vertex objects.
     */
    public Vertex[] getVertices() {
        Vertex[] returnVertices = new Vertex[vertices.size()];
        return vertices.toArray(returnVertices);
    }

    /**
     * Creates a new Vertex with passed in value, and adds it to this graph's list of vertices.
     * @param value The value of the new Vertex.
     * @return The newly created vertex.
     */
    public Vertex addVertex(T value) {
        Vertex<T> vertex = new Vertex<>(value);
        vertices.add(vertex);
        return vertex;
    }

    /**
     * Creates a new edge in this graph between lefvertex and righvertex.
     * The edge is created with weight equal to 0.
     * @param lefvertex The left vertex for the new edge.
     * @param righvertex The right vertex for the new edge.
     * @throws IllegalArgumentException If either one of the edges does not exist in this graph.
     * @return The newly created edge.
     */
    public Edge addEdge(Vertex lefvertex, Vertex righvertex) {
        if (!vertices.contains(lefvertex) || !vertices.contains(righvertex)) {
            throw new IllegalArgumentException("Error: specified vertex not in this graph!");
        }

        return new Edge(lefvertex, righvertex, 0);
    }

    /**
     * Creates a new edge in this graph between lefvertex and righvertex.
     * The edge is created with weight equal to passed in value of weight.
     * If either one of the edges does not exist in this graph, no edge is
     * created, and null is returned.
     * @param lefvertex The left vertex for the new edge.
     * @param righvertex The right vertex for the new edge.
     * @param weight The weight to assign to the new edge.
     * @throws IllegalArgumentException If either one of the edges does not exist in this graph.
     * @return The newly created edge.
     */
    public Edge addEdge(Vertex lefvertex, Vertex righvertex, int weight) {
        if (!vertices.contains(lefvertex) || !vertices.contains(righvertex)) {
            throw new IllegalArgumentException("Error: specified vertex not in this graph!");
        }

        return new Edge(lefvertex, righvertex, weight);
    }

    /**
     * Returns the total number of vertices in this graph.
     * @return The number of vertices in this graph.
     */
    public int size() {
        return vertices.size();
    }

    /**
     * Returns the list of edge neighbors belonging to passed in vertex.
     * @param vertex The vertex for which to find neighbors.
     * @return The list of edge neighbors for the passed in vertex.
     */
    public ArrayList<Edge> getNeighbors(Vertex<T> vertex) {
        if (vertices.indexOf(vertex) == -1) {
            throw new IllegalArgumentException("Error: specified vertex not in this graph!");
        }

        return vertex.getNeighbors();
    }

    /**
     * Returns an array of Vertex objects visited in a breadth first traversal, starting from vertex.
     * @param vertex
     * @return
     */
    public static Vertex[] breadthFirstTraversal(Vertex vertex) {
        return null;
    }
}
