import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import graphLibrary.Edge;
import graphLibrary.Graph;
import graphLibrary.Vertex;

public class GraphTest {

	Graph emptyGraph;
	Graph g1;
	Graph g2;
	Graph g3;
	Graph g4;
	
	@Before
	public void setUp() throws Exception {
		emptyGraph = new Graph();
		g1 = new Graph();
		g2 = new Graph();
	}

	@Test
	public void testGraph() {
		g3 = new Graph(10);
		g4 = new Graph(0);
	}

	@Test
	public void testGraphInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVertex() {
		Vertex<Integer> v1 = new Vertex<>(1);
		Vertex<Integer> v2 = new Vertex<>(2);
		Edge e = new Edge(v1, v2);
		g1.addEdge(e);
		
		assertEquals(null, g1.getVertex(null));
		assertEquals(v1, g1.getVertex(1));
		assertEquals(null, g1.getVertex(3));
		
	}

	@Test
	public void testIsWeighted() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetVisitedVertex() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVertices() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAdjVertices() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEdges() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVertexNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEdgeNumber() {
		assertEquals(0, emptyGraph.getEdgeNumber());
	}

	@Test
	public void testGetMeanEdge() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEdge() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGraphRepresentation() {
		fail("Not yet implemented");
	}

	@Test
	public void testDfs() {
		fail("Not yet implemented");
	}

	@Test
	public void testBfs() {
		fail("Not yet implemented");
	}

	@Test
	public void testShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	public void testConnected() {
		fail("Not yet implemented");
	}

	@Test
	public void testMst() {
		fail("Not yet implemented");
	}

}
