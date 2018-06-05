package tests;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import graphLibrary.Edge;
import graphLibrary.Graph;
import graphLibrary.GraphManager;
import graphLibrary.GraphReader;
import graphLibrary.Vertex;

public class Main {

	public static void main(String[] args) throws IOException {
		Graph emptyGraph;
		Graph weightedGraph;
		Graph normalGraph;
		Graph negativeGraph;
		Graph negativeWeightedGraph;
		
		
		emptyGraph = new Graph();
		/*
		 * 5
		 * 1 2 0.1
		 * 2 5 0.2
		 * 5 3 5
		 * 3 4 -9.5
		 * 4 5 2.3
		 * 1 5 1
		 */
		weightedGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/weightedGraph.txt", true);
		/*
		 * 5
		 * 1 2
		 * 2 5
		 * 5 3
		 * 4 5
		 * 1 5
		 */
		normalGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/simpleGraph.txt", false);
		/*
		 * 5
		 * -1 2 0.1
		 * 2 -5 0.2
		 * -5 3 5
		 * 3 4 -9.5
		 * 4 -5 2.3
		 * -1 5 1
		 */
		negativeWeightedGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/negativeWeightedGraph.txt", true);
		/*
		 * 5
		 * -1 -2
		 * -2 5
		 * 5 -3
		 * -4 5
		 * -1 5
		 */
		negativeGraph = GraphReader.readGraph("../Grupo11-Lab1ATG/Testes-Grupo-2/negativeSimpleGraph.txt", false);
		System.out.println();
	}
	
}
