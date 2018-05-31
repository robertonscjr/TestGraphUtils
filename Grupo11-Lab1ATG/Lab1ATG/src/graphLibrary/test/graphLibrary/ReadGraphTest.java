package graphLibrary.test.graphLibrary;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import graphLibrary.Edge;
import graphLibrary.Graph;
import graphLibrary.GraphReader;
import graphLibrary.Vertex;
import org.junit.Before;
import org.junit.Test;

public class ReadGraphTest {
    String basePath = new File("src/graphLibrary/data.txt").getAbsolutePath();
    //String basePathWeighted = new File("src/graphLibrary/dataWeighted.txt").getAbsolutePath();
    Graph graphRead;
    Graph graphTest;
    Graph graphReadWeight;

    @Before
    public void createGraphs(){
        try {
            graphRead = GraphReader.readGraph(basePath, false);
            //graphReadWeight = GraphReader.readGraph(basePathWeighted, true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        graphTest =  new Graph(5);

        Vertex<Integer> v1 = new Vertex<Integer>(1);
        Vertex<Integer> v2 = new Vertex<Integer>(2);
        Vertex<Integer> v3 = new Vertex<Integer>(3);
        Vertex<Integer> v4 = new Vertex<Integer>(4);
        Vertex<Integer> v5 = new Vertex<Integer>(5);

        Edge edge12 = new Edge(v1, v2);

        Edge edge15 = new Edge(v1, v5);

        Edge edge25 = new Edge(v2, v5);

        Edge edge35 = new Edge(v3, v5);

        Edge edge54 = new Edge(v5, v4);

        graphTest.addEdge(edge12);

        graphTest.addEdge(edge15);

        graphTest.addEdge(edge25);

        graphTest.addEdge(edge35);

        graphTest.addEdge(edge54);

    }

    @Test
    public void TestEqualityGraph() {
        assertNotEquals(graphRead, null);
        assertNotEquals(graphRead, new Graph());

    }


}