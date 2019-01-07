package graph;

import org.junit.Test;

public class GraphTest {

    @Test(expected = IllegalArgumentException.class)
    public void testEdgeClassException() {
        Edge badEdge = new Edge(null, null);
    }

    //TODO - bazillion more tests
}
