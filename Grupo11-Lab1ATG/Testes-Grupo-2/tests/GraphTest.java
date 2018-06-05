package tests;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import graphLibrary.Edge;
import graphLibrary.Graph;
import graphLibrary.GraphManager;
import graphLibrary.GraphReader;
import graphLibrary.Representation;
import graphLibrary.Vertex;

public class GraphTest {

	Graph emptyGraph;
	
	Graph weightedGraph;
	Graph normalGraph;
	Graph negativeGraph;
	Graph negativeWeightedGraph;
	
	Set<Vertex<Integer>> verticesOfWeightedGraph;
	Set<Vertex<Integer>> verticesOfNormalGraph;
	
	Set<Edge> edgesOfWeightedGraph;
	Set<Edge> edgesOfNormalGraph;

	
	@Before
	public void setUp() throws Exception {
		emptyGraph = new Graph();
		
		weightedGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/weightedGraph.txt", true);
		normalGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/simpleGraph.txt", false);

		negativeWeightedGraph = new Graph();
		negativeGraph = new Graph();
		
		verticesOfNormalGraph = (HashSet<Vertex<Integer>>) normalGraph.getVertices();
		verticesOfWeightedGraph = (HashSet<Vertex<Integer>>) weightedGraph.getVertices();
		
	}

	@Test
	public void testGraph() {
		assertEquals(5, normalGraph.getVertexNumber());
		assertEquals(5, weightedGraph.getVertexNumber());
		
		assertEquals(5, normalGraph.getEdgeNumber());
		assertEquals(6, weightedGraph.getEdgeNumber());

		//negativeWeightedGraph = reader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/negativeWeightedGraph.txt", true);
		//negativeGraph = reader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/negativeSimpleGraph.txt", false);
		
	}

	@Test
	public void testGraphInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVertex() {
	
	}

	@Test
	public void testIsWeighted() {
		assertTrue(weightedGraph.isWeighted());
		assertFalse(normalGraph.isWeighted());
	}

	@Test
	public void testSetVisitedVertex() {
		weightedGraph.getVertex(2).setVisited(true);
		assertEquals(true, weightedGraph.getVertex(2).getVisited());
	}

	@Test
	public void testGetVertices() {
		assertEquals(verticesOfNormalGraph, normalGraph.getVertices());
		assertEquals(verticesOfWeightedGraph, weightedGraph.getVertices());
		assertNull(emptyGraph.getVertices());
	}

	@Test
	public void testGetAdjVertices() {
		HashSet<Vertex<Integer>> adj = new HashSet<>();
		adj.add(normalGraph.getVertex(2));
		adj.add(normalGraph.getVertex(5));
		
		assertEquals(adj,  normalGraph.getAdjVertices(new Vertex(1)));
		assertEquals(adj,  weightedGraph.getAdjVertices(new Vertex(1)));
	}

	@Test
	public void testGetEdges() {
		assertNotNull(normalGraph.getEdges());
		assertNotNull(weightedGraph.getEdges());
		assertNull(emptyGraph.getEdges());
	}

	@Test
	public void testGetVertexNumber() {
		assertEquals(0, emptyGraph.getVertexNumber());
		assertEquals(5, normalGraph.getVertexNumber());
		assertEquals(5, weightedGraph.getVertexNumber());
	}

	@Test
	public void testSetWeight() {
		normalGraph.setWeight(new Vertex<>(1), new Vertex<>(2), (float) 5.0);
		normalGraph.setWeight(new Vertex<>(), new Vertex<>(), (float) 5.0);
	}

	@Test
	public void testGetEdgeNumber() {
		assertEquals(0, emptyGraph.getEdgeNumber());
	}

	@Test
	public void testGetMeanEdge() {
		assertEquals(2.0, normalGraph.getMeanEdge());
		assertEquals(2.0, weightedGraph.getMeanEdge());
	}

	@Test
	public void testAddEdge() {
		Vertex aux1 = new Vertex<>(1);
		Vertex aux2 = new Vertex<>(2);
		Edge edge = new Edge(aux1, aux2);
		emptyGraph.addEdge(edge);
		assertTrue(emptyGraph.getEdges().contains(edge));
	}

	@Test
	public void testEqualsObject() {
		try {
			Graph one = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/simpleGraph.txt", false);
			Graph two = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/simpleGraph.txt", false);
			Graph three = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/weightedGraph.txt", false);
			assertEquals(one, two);
			assertNotEquals(two, three);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGraphRepresentation() {
		String normalAL = "1 - 2 5\n2 - 1 5\n3 - 5\n4 - 5\n5 - 1 2 3 4\n";
		String normalAM = "  1 2 3 4 5 \n1 0 1 0 0 1 \n2 1 0 0 0 1 \n3 0 0 0 0 1 \n4 0 0 0 0 1 \n5 1 1 1 1 0 \n";
		String weightedAL = "1 - 2(0.1) 5(1.0)\n2 - 5(0.2) 1(0.1)\n3 - 5(5.0) 4(-9.5)\n4 - 5(2.3) 3(-9.5)\n5 - 3(5.0) 4(2.3) 2(0.2) 1(1.0)\n";
		String weightedAM = "not words for weightedgraph";// not works for weightedgraph
		assertEquals(normalAL, normalGraph.graphRepresentation(Representation.AL));
		assertEquals(normalAM, normalGraph.graphRepresentation(Representation.AM));
		assertEquals(weightedAL, weightedGraph.graphRepresentation(Representation.AL));
		assertEquals(weightedAM, weightedGraph.graphRepresentation(Representation.AM));
	}

	@Test
	public void testDfs() {
		String dfsPath = "1 - 0 -\n2 - 0 1\n5 - 1 2\n3 - 2 5\n4 - 2 5\n";
		String weightedDfsPath = "1 - 0 -\n2 - 0 1\n5 - 1 2\n3 - 2 5\n4 - 3 3\n";
		assertEquals(dfsPath, normalGraph.dfs(normalGraph.getVertex(1)));
		assertEquals(weightedDfsPath, weightedGraph.dfs(weightedGraph.getVertex(1)));
		assertEquals("", emptyGraph.bfs(null));
	}

	@Test
	public void testBfs() {
		String bfsPath = "1 - 0 -\n2 - 1 1\n5 - 1 1\n3 - 2 5\n4 - 2 5\n";
		String weightedBfsPath = "";
		assertEquals(bfsPath, normalGraph.bfs(normalGraph.getVertex(1)));
	}

	@Test
	public void testShortestPath() throws IOException {
		
		// Normal graph
		
		//Default shortest path call
		String result = normalGraph.shortestPath(normalGraph.getVertex(1),normalGraph.getVertex(3));
		assertEquals("1 5 3 ", result);
		
		//Shortest path to same vertex
		result = normalGraph.shortestPath(normalGraph.getVertex(1),normalGraph.getVertex(1));
		assertEquals("1 ", result);
		
		//Shortest path to unregistered vertex
		//result = normalGraph.shortestPath(normalGraph.getVertex(1),normalGraph.getVertex(15));
		//assertEquals("", result); // Exception
		
		// Nao funciona para arestas positivas(Loop)
		//Graph otherWeightedGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/weightedGraph2.txt", true);
		//result = weightedGraph.shortestPath( weightedGraph.getVertex(1), weightedGraph.getVertex(4) );
		
		// Weighted Graph ( Não funciona para arestas negativas(Loop) )
		//result = weightedGraph.shortestPath( weightedGraph.getVertex(1), weightedGraph.getVertex(4) );
	}

	@Test
	public void testConnected() throws IOException {
		assertEquals(true,normalGraph.connected());
		assertEquals(true,weightedGraph.connected());
		
		Graph otherWeightedGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/weightedGraph2.txt", true);
		assertEquals(false,otherWeightedGraph.connected());
	}

	@Test
	public void testMst() {
		String[] expResult = {"Edge: 5 to 3, weigh: 1.0",
								   "Edge: 1 to 5, weigh: 1.0",
								   "Edge: 2 to 5, weigh: 1.0",
								   "Edge: 4 to 5, weigh: 1.0"};
		
		Set<String> expectedResults = new HashSet<String>(Arrays.asList(expResult));
		String[] result = normalGraph.mst().split("\n");
		assertEquals(result.length, expectedResults.size());
		for(String s : result) {
			if(!expectedResults.contains(s)) {
				fail();
			}
		}
		
		String[] weightedExpectedResults = { "Edge: 3 to 4, weigh: -9.5",
											 "Edge: 1 to 2, weigh: 0.1",
											 "Egde: 5 to 3, weigh: 5",
											 "Edge: 2 to 5, weigh: 0.2" };
		expectedResults = new HashSet<String>(Arrays.asList(weightedExpectedResults));
		String[] weightedGraphResult = weightedGraph.mst().split("\n");
		for(String s : weightedGraphResult) {
			if(!expectedResults.contains(s)) {
				fail();
			}
		}
		assertEquals(weightedGraphResult.length, expectedResults.size());
	}
}
