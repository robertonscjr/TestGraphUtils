package graphLibrary.test.graphLibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.HashSet;
import java.util.Set;

import graphLibrary.Edge;
import graphLibrary.Graph;
import graphLibrary.Vertex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    Vertex<Integer> v1;
    Vertex<Integer> v2;
    Vertex<Integer> v3;
    Vertex<Integer> v4;
    Vertex<Integer> v5;
    Vertex<Integer> v6;
    Vertex<Integer> v7;
    Vertex<Integer> v8;
    Vertex<Integer> v9;
    Vertex<Integer> v10;

    Edge edge12;

    Edge edge15;

    Edge edge25;

    Edge edge34;

    Edge edge35;

    Edge edge54;

    //Grafo 2
    Edge gedge12;

    Edge gedge19;

    Edge gedge93;

    Edge gedge97;

    Edge gedge34;

    Edge gedge35;

    Edge gedge36;

    Edge gedge76;

    Edge gedge78;

    Edge gedge58;

    Object obj;
    Graph testGraph;
    Graph graph2;

    Set<Vertex<Integer>> testSetVertex;

    @Before
    public void createGraphNotWeight (){

        v1 = new Vertex<Integer>(1);
        v2 = new Vertex<Integer>(2);
        v3 = new Vertex<Integer>(3);
        v4 = new Vertex<Integer>(4);
        v5 = new Vertex<Integer>(5);
        v6 = new Vertex<Integer>(6);
        v7 = new Vertex<Integer>(7);
        v8 = new Vertex<Integer>(8);
        v9 = new Vertex<Integer>(9);
        v10 = new Vertex<Integer>(10);

        obj = new Object();

        edge12 = new Edge(v1, v2);

        edge15 = new Edge(v1, v5);

        edge25 = new Edge(v2, v5);

        edge34 = new Edge(v3, v4);

        edge35 = new Edge(v3, v5);

        edge54 = new Edge(v5, v4);

        //Grafo 2

        gedge12 = new Edge(v1, v2);

        gedge19 = new Edge(v1, v9);

        gedge93 = new Edge(v9, v3);

        gedge97 = new Edge(v9, v7);

        gedge34 = new Edge(v3, v4);

        gedge35 = new Edge(v3, v5);

        gedge36 = new Edge(v3, v6);

        gedge76 = new Edge(v7, v6);

        gedge78 = new Edge(v7, v8);

        gedge58 = new Edge(v5, v8);

        testGraph = new Graph(5);
        graph2 = new Graph(9);

        testGraph.addEdge(edge12);

        testGraph.addEdge(edge15);

        testGraph.addEdge(edge25);

        testGraph.addEdge(edge35);

        testGraph.addEdge(edge54);

        //Grafo 2

        graph2.addEdge(gedge12);

        graph2.addEdge(gedge19);

        graph2.addEdge(gedge93);

        graph2.addEdge(gedge97);

        graph2.addEdge(gedge34);

        graph2.addEdge(gedge35);

        graph2.addEdge(gedge36);

        graph2.addEdge(gedge76);

        graph2.addEdge(gedge78);

        graph2.addEdge(gedge58);

    }


    @Test
    public void TestVertex() {
        assertNotEquals(v1, v2);
        assertNotEquals(obj, v1);
        assertNotEquals(v2, new Vertex<>(null));
        assertNotEquals(v3, new Vertex<>());
        assertNotEquals(v1, obj);
        assertEquals(v1, new Vertex<>(1));


    }

    @Test
    public void TestEdge() {
        assertNotEquals(edge12, null);
        assertNotEquals(edge12, new Edge(null, null));
        assertNotEquals(edge12, obj);
        assertEquals(edge12, new Edge(v1, v2));
    }


    @Test
    public void TestEqualMembersVertex() {

        Set<Vertex> testSetVertex = new HashSet<Vertex>(10);

        testSetVertex.add(v1);
        testSetVertex.add(v2);
        testSetVertex.add(v3);
        testSetVertex.add(v4);
        testSetVertex.add(v5);



        assertEquals(new Graph(0).getVertices(), new HashSet<>());

        assertEquals(new Graph(0).getVertexNumber(), 0);

    }

    @Test
    public void testEqualMembersEdge(){

        Set<Edge> testSetEdges = new HashSet<Edge>();

        testSetEdges.add(edge12);

        testSetEdges.add(edge15);

        testSetEdges.add(edge25);

        testSetEdges.add(edge35);

        testSetEdges.add(edge54);

        testGraph.addEdge(null);
        testGraph.addEdge(edge54);

        assertEquals(testGraph.getEdges(), testSetEdges);
        assertEquals(new Graph().getEdges(), new HashSet<>());
        assertEquals(testGraph.getEdgeNumber(), 5);

        assertEquals(false, testGraph.isWeighted());


    }
    @Test
    public void testGetVertex() {
        Integer notInTestGraph = new Integer(20);

        assertEquals(testGraph.getVertex(1), v1);
        assertEquals(testGraph.getVertex(null), null);
        assertEquals(testGraph.getVertex(notInTestGraph), null);

    }

    @Test
    public void testBFS() {

        String outputtestGraph = "1 - 0 -\n" +
                "2 - 1 1\n" +
                "5 - 1 1\n" +
                "3 - 2 5\n" +
                "4 - 2 5\n";

        String outputgraph2 = "1 - 0 -\n" +
                "2 - 1 1\n" +
                "9 - 1 1\n" +
                "3 - 2 9\n" +
                "7 - 2 9\n" +
                "4 - 3 3\n" +
                "5 - 3 3\n" +
                "6 - 3 3\n" +
                "8 - 4 5\n";
        assertEquals(testGraph.bfs(v1), outputtestGraph);


    }

    @Test
    public void testDFS() {
        String outputtestGraph = "1 - 0 -\n" +
                "2 - 0 1\n" +
                "5 - 1 2\n" +
                "3 - 2 5\n" +
                "4 - 2 5\n";

        String outputgraph2 = "1 - 0 -\n" +
                "2 - 0 1\n" +
                "9 - 0 1\n" +
                "3 - 1 9\n" +
                "4 - 2 3\n" +
                "5 - 2 3\n" +
                "8 - 3 5\n" +
                "7 - 4 8\n" +
                "6 - 5 7\n";

        assertEquals(testGraph.dfs(v1), outputtestGraph);
        assertEquals(graph2.dfs(v1), outputgraph2);
    }

    @Test
    public void testConnected() {
        assertEquals(testGraph.connected(), true);
        assertEquals(graph2.connected(), true);
    }

    @Test
    public void testMST(){
        String mstOutput = "Edge: 2 to 4, weigh: 1.5\n" +
                "Edge: 1 to 2, weigh: 2.0\n" +
                "Edge: 1 to 3, weigh: 4.0\n";
        graph2 = new Graph(4);
        graph2.addEdge(new Edge(v1, v2, 2f));
        graph2.addEdge(new Edge(v1, v3, 4f));
        graph2.addEdge(new Edge(v2, v4, 1.5f));
        Assert.assertEquals(graph2.mst(), mstOutput);
    }
}