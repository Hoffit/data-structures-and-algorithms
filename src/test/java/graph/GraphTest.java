package graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphTest {

    //Graph constructor tests
    @Test
    public void testGraphConstructor() {
        Graph graph = new Graph();
        assertNotNull(graph);
    }

    // Add Vertex tests
    @Test(expected = IllegalArgumentException.class)
    public void testVertexClassException() {
        Vertex vertex = new Vertex(null);
    }

    @Test
    public void testAddVertexMethod() {
        Graph<Integer> g = new Graph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(2);
        Vertex[] vertices = g.getVertices();
        assertTrue(vertices.length == 3);
        int countOnes = 0;
        int countTwos = 0;
        int countOther = 0;
        for (Vertex vertex : vertices) {
            if (vertex.getValue().equals(1)) {
                countOnes++;
            }
            else if (vertex.getValue().equals(2)) {
                countTwos++;
            }
            else {
                countOther++;
            }
        }
        assertTrue(countOnes==1);
        assertTrue(countTwos==2);
        assertTrue(countOther==0);
    }

    // Add Edge tests
    @Test(expected = IllegalArgumentException.class)
    public void testEdgeClassExceptionWithoutWeight() {
        Edge badEdge = new Edge(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeMethod_NoWeightWithException() {
        Graph<Integer> g = new Graph<>();
        Vertex<Integer> v1 = new Vertex(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        g.addEdge(v1, v2);
    }

    @Test
    public void testAddEdgeMethod_NoWeight() {
        Graph<Integer> g = new Graph<>();
        Vertex<Integer> v1 = g.addVertex(1);
        Vertex<Integer> v2 = g.addVertex(2);
        g.addEdge(v1, v2);
        assertEquals(g.getNeighbors(v1).iterator().next().getOtherEnd(v1), v2);
        assertEquals(g.getNeighbors(v2).iterator().next().getOtherEnd(v2), v1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEdgeClassExceptionWithWeight() {
        Edge badEdge = new Edge(null, null, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeMethod_WithWeightWithException() {
        Graph<Integer> g = new Graph<>();
        Vertex<Integer> v1 = new Vertex(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        g.addEdge(v1, v2, 7);
    }

    @Test
    public void testingAddEdgeMethod_WithWeight() {
        Graph<Integer> g = new Graph<>();
        Vertex<Integer> v1 = g.addVertex(1);
        Vertex<Integer> v2 = g.addVertex(2);
        g.addEdge(v1, v2, 22);
        assertEquals(g.getNeighbors(v1).iterator().next().getOtherEnd(v1), v2);
        assertEquals(g.getNeighbors(v2).iterator().next().getOtherEnd(v2), v1);
    }

    // Get vertices tests
    @Test
    public void testGetVertices_Empty() {
        Graph<Integer> g = new Graph<>();
        Vertex[] vertices = new Vertex[0];
        assertEquals(vertices, g.getVertices());

        g.addVertex(88);
        assertTrue(g.getVertices().length == 1);
        assertTrue(g.getVertices()[0].getValue() == Integer.valueOf(88));
    }

    // Get neighbors tests
    @Test(expected = IllegalArgumentException.class)
    public void getNeighbors_No_Vertices_Test() {
        Graph<Integer> g = new Graph<>();
        g.getNeighbors(new Vertex<>(99));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getNeighbors_No_Matching_Vertices_Test() {
        Graph<Integer> g = new Graph<>();
        g.addVertex(44);
        g.getNeighbors(new Vertex<>(99));
    }

    @Test
    public void getNeighborsHappyTest() {
        Graph<Integer> g = new Graph<>();
        Vertex<Integer> v1 = g.addVertex(1);
        Vertex<Integer> v2 = g.addVertex(2);
        g.addEdge(v1, v2, 22);
        assertEquals(g.getNeighbors(v1).iterator().next().getOtherEnd(v1), v2);
        assertEquals(g.getNeighbors(v2).iterator().next().getOtherEnd(v2), v1);
    }

    // Get size tests
    @Test
    public void getSizeTest() {
        Graph<Integer> g = new Graph<>();
        assertTrue(g.size() == 0);

        g.addVertex(77);
        assertTrue(g.size() == 1);

        g.addVertex(66);
        assertTrue(g.size() == 2);
    }

    //TODO
    @Test
    public void testBreadthFirstTraversalMethod() {
        assertTrue(true);
    }
}
