package tests;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import graphLibrary.Graph;
import graphLibrary.GraphReader;

public class GraphReaderTest {

	Graph normalGraph;
	Graph weightedGraph;
	
	@Before
	public void setUp() throws Exception {
		normalGraph = new Graph();
		weightedGraph = new Graph();
	}

	@Test
	public void testReadGraph() {
		try {
			normalGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/simpleGraph.txt", false);
			weightedGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/weightedGraph.txt", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testReadGraphInvalidFile() {
		
		try {
			normalGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/invalideSimpleGraph.txt", false);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Expected two vertices per edge");
		}
		
	}
	

}
