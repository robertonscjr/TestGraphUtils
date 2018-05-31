package graphLibrary;

import java.util.*;

public class Graph {
	
	public static final int DEFAULT_NUMBER_OF_VERTICES = 10;
	private static final float NOT_CONNECTED = -1f;

	private Set<Vertex<Integer>> vertices;
	private float[][] matrix;
	private Set<Edge> edges;
	private Map<Vertex<Integer>, Set<Vertex<Integer>>> adjVertices;
	private boolean isWeighted;

	public Graph() {
		this(Graph.DEFAULT_NUMBER_OF_VERTICES);
	}

	/** This is a Graph Structure, where each Graph has a set of vertices, a set for edges, a boolean
	 * to define if this graph is weighted or not (all edges has a default weigh), a map where the keys are all
	 * vertices of this graph, and the values are sets of adjacent vertices.
	 *
	 * @author Ronan
	 * @param numberOfVertices it`s the number of vertices that this graph will have
	 */
	public Graph(int numberOfVertices) {
		vertices = new HashSet<>(numberOfVertices);
		matrix = new float[numberOfVertices + 1][numberOfVertices + 1];

		for(int i = 1; i <= numberOfVertices; i++) {
			vertices.add(new Vertex<Integer>(i));
			
			for(int j = 1; j <= numberOfVertices; j++) {
				if(i != j) {
					matrix[i][j] = Graph.NOT_CONNECTED;
				} else {
					matrix[i][j] = 0;
				}
			}
		}
		
		edges = new HashSet<>();
		adjVertices = new HashMap<>();
		isWeighted = false;


	}

	/**
	 * Returns a vertex corresponding to the parameter passed
	 *
	 * @param data it`s the data of vertex wanted
	 * @return The vertex corresponding to the data that was passed
	 */
	public Vertex getVertex(Integer data){
		
		if(data == null) {
			return null;
		}
		
		for (Vertex v : vertices){
			if(v.getData().equals(data)){
				return v;
			}
		}
		
		return null;
	}


	/**
	 * Indicates if the graph is weighted or not
	 * @return true, if the graph is weighted of false if it`s not
	 */
	public boolean isWeighted() {
		return isWeighted;
	}

	public void setVisitedVertex (Vertex vertex, boolean status){
		for (Vertex v : vertices){
			if(v.equals(vertex)){
				v.setVisited(true);
			}
		}
	}

	/**
	 * Returns all vertices of this graph
	 * @return a set with all vertices
	 */
	public Set<Vertex<Integer>> getVertices() { return vertices; }

	/**
	 * Returns all the adjacents vertices of a vertex
	 * @param v The vertex that you want the adjacents
	 * @return A set of vertices
	 */
	public Set<Vertex<Integer>> getAdjVertices(Vertex<Integer> v) { return adjVertices.get(v); }

	/**
	 * Returns all edges of this graph
	 * @return a set of edges
	 */
	public Set<Edge> getEdges() { return edges; }

	/**
	 * Indicates how many vertices this graph has
	 * @return the number (int) of vertices in this graph
	 */
	public int getVertexNumber() {
		return getVertices().size();
	}

	/**
	 * Sets a edge between two vertices
	 * @param u the first vertex
	 * @param v the second vertex
	 * @param weight the weight of the edge
	 */
	public void setWeight(Vertex<Integer> u, Vertex<Integer> v, float weight) {
		matrix[u.getData()][v.getData()] = weight;
		matrix[v.getData()][u.getData()] = weight;
	}

	/** Indicates how many edges this graph has
	 * @return a int with the number of edges
	 */
	public int getEdgeNumber() {

		return getEdges().size();
	}


	/**
	 * Indicates the mean edge value of this graph, using the following formula: (2 * edgesNumber) / verticesNumber
	 * @return a float of the mean edge
	 */
	public float getMeanEdge() {
		return (2 * getEdgeNumber()) / getVertexNumber();
	}


	private boolean addVertex(Vertex vertex) {

		if(vertex == null) {
			return false;
		}else {
			return vertices.add(vertex);
		}
		
	}


	/**
	 * Adds a new edge to the graph
	 * @param edge the edge that is wanted to be added
	 * @return true if the edge was added successfully, or false if it's not
	 */
	public boolean addEdge(Edge edge) {
		if(edge == null) {
			return false;
		
		} else if (edges.add(edge)) {
			setWeight(edge.getFirstVertice(), edge.getSecondVertice(), edge.getWeight());
			if(edge.getWeight() != 1){
				isWeighted = true;
			}

			Vertex v1 = edge.getFirstVertice();
			Vertex v2 = edge.getSecondVertice();

			adjVertices.putIfAbsent(v1, new HashSet<>());
			adjVertices.putIfAbsent(v2, new HashSet<>());

			adjVertices.get(v1).add(v2);
			adjVertices.get(v2).add(v1);
			return true;
		}else {
			return false;
		}	

	}

	/**
	 * Creates a unique number for this graph
	 * @return the hash code of this graph
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edges == null) ? 0 : edges.hashCode());
		result = prime * result + (isWeighted ? 1231 : 1237);
		result = prime * result + ((vertices == null) ? 0 : vertices.hashCode());
		return result;
	}


	/**
	 * Verify if this graph is equals to other object
	 * @param obj the object to be compared with this graph
	 * @return true if this graph and the obj are identicals, and false if it's not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		if (edges == null) {
			if (other.edges != null)
				return false;
		} else if (!edges.equals(other.edges))
			return false;
		if (isWeighted != other.isWeighted)
			return false;
		if (vertices == null) {
			if (other.vertices != null)
				return false;
		} else if (!vertices.equals(other.vertices))
			return false;
		return true;
	}

	/**
	 * Returns a representation of this graph, that could be a Adjacency List or a Adjacency Matrix
	 * @param type the type of your representation (AM or AL)
	 * @return A string of the wanted representation
	 */
	public String graphRepresentation(Representation type) {
		String result = null;

		if (type.equals(Representation.AL)) {
			result = generateAL();
		}else if (type.equals(Representation.AM)){
			result = generateAM();
		}

		return result;
	}

	/**
	 * Generates the Adjacency List of this graph
	 * @return
	 */
	private String generateAL() {
		String result = "";

		if (isWeighted()) {
			for (Vertex v : vertices) {
				String line = String.format("%d -", v.getData());

				for (Edge edge : edges) {
					if (edge.getFirstVertice().equals(v)) {
						line += (" " + edge.getSecondVertice().getData() + "(" + edge.getWeight() + ")");
					}
					if (edge.getSecondVertice().equals(v)) {
						line += (" " + edge.getFirstVertice().getData() + "(" + edge.getWeight() + ")");
					}

				}

				result += (line + "\n");
			}
		}else {
			for (Vertex v1 : vertices) {
				String line = String.format("%d -", v1.getData());

				for (Vertex v2 : adjVertices.get(v1)) {
					line += (" " + v2.getData());
				}

				result += (line + "\n");
			}
		}
		return result;
	}

	/**
	 * Generates the Adjacency Matrix of this graph
	 * @return String
	 */
	private String generateAM() {
		String result = "";
		String line = "  ";

		if (isWeighted()){

		}else {

			for (Vertex v : vertices) {
				line += String.format("%d ", v.getData());
			}
			result += (line + "\n");

			for (Vertex v1 : vertices) {
				line = String.format("%d ", v1.getData());

				for (Vertex v2 : vertices) {
					if (adjVertices.get(v1).contains(v2)) {
						line += "1 ";
					} else {
						line += "0 ";
					}
				}

				result += (line + "\n");
			}
		}
		return result;
	}

	/**
	 *
	 * Generates a Depth-First Search Tree and return as
	 *
	 * @param v root of the DFS
	 * @return String, where each line is
	 * 	 * the "data - level parent" of a vertex
	 */
	public String dfs(Vertex<Integer> v) {
		Integer level = 0;
		String result = "";

		setVisitedVertex(v, true);
		result += v.getData()+" - "+level+" "+"-\n";

		for(Vertex<Integer> vertex: getAdjVertices(v)){
			if (!getVertex((Integer) vertex.getData()).getVisited()){
				result += dfsUtil(vertex, level, v);
			}
		}

		for (Vertex<Integer> vertex : vertices){
			setVisitedVertex(vertex, false);
		}
		return result;
	}

	/**
	 * It's used to help the generation of the DFS, it's just called by dfs(Vertex v)
	 *
	 * @param v vertex
	 * @param l the actual level
	 * @param parent the parent of the v vertex
	 * @return Part of the complete DFS
	 */
	private String dfsUtil(Vertex<Integer> v, Integer l, Vertex<Integer> parent){
		String result = "";
		Integer level = l;

		setVisitedVertex(v, true);
		result += v.getData()+" - "+level+" "+parent.getData()+"\n";
		level++;

		for(Vertex<Integer> vertex: getAdjVertices(v)){
			if (!getVertex((Integer) vertex.getData()).getVisited()){
				result += dfsUtil(vertex, level, v);
			}
		}
		return result;
	}

	/**
	 * Generates a Breadth-First Search Tree
	 * @param vertex is the root of the tree
	 * @return String, where each line is
	 * the "data - level parent" of a vertex
	 */
	public String bfs(Vertex<Integer> vertex){
		Map<Vertex<Integer>, Integer> visited = new HashMap<>();
		Queue<Vertex<Integer>> queue = new LinkedList<>();
		Set<Vertex<Integer>> completed = new HashSet<>();
		String result = "";

		((LinkedList<Vertex<Integer>>) queue).addFirst(vertex);

		Integer level = 0;

		while (! queue.isEmpty()){
			Vertex<Integer> head = ((LinkedList<Vertex<Integer>>) queue).removeFirst();
			if (! visited.containsKey(head)){
				result += head.getData()+" - "+ level+" -\n";
			}
			visited.putIfAbsent(head, level);

			for (Vertex<Integer> adj : getAdjVertices(head)){
				if (!visited.containsKey(adj)){
					result += adj.getData()+" - "+(visited.get(head)+1)+" "+head.getData()+"\n";
				}
				visited.putIfAbsent(adj, visited.get(head) + 1);
				if (!completed.contains(adj)) {
					((LinkedList<Vertex<Integer>>) queue).addFirst(adj);
				}
			}
			completed.add(head);
		}

		return result;
	}

	/**
	 * Generates the shortest path between two vertices of this graph, it was used Djkistra Algorithm to find the path
	 * @param origin the origin vertex
	 * @param destiny the final vertex
	 * @return A string representing the path (all vertices between them)
	 */
	public String shortestPath(Vertex<Integer> origin, Vertex<Integer> destiny) {

		float[] dist = new float[vertices.size() + 1];
		int[] parent = new int[vertices.size() + 1];
		Queue<Vertex<Integer>> fifo = new LinkedList<Vertex<Integer>>();
		
		fifo.add(origin);

		for(int i = 0; i < dist.length; i++) {
			dist[i] = Float.MAX_VALUE;
			parent[i] = i;
		}
		
		dist[origin.getData()] = 0f;
		
		while(!fifo.isEmpty()) {
			Vertex<Integer> u = fifo.poll();

			for (Vertex<Integer> v : getAdjVertices(u)) {
				if (dist[v.getData()] == Float.MAX_VALUE
						|| dist[u.getData()] + matrix[u.getData()][v.getData()] < dist[v.getData()]) {
			
					dist[v.getData()] = dist[u.getData()] + matrix[u.getData()][v.getData()];
					parent[v.getData()] = u.getData();
					fifo.add(v);
				}
			}
		}
		

		String result = "";
		
		Stack<Integer> s = new Stack<Integer>();
		int curNode = destiny.getData();
		while(parent[curNode] != curNode) {
			s.add(curNode);
			curNode = parent[curNode];
		}
		s.add(curNode);
		while(!s.isEmpty()) {
			result += s.pop().toString() + " ";
		}
		
		return result;
	}


	/** Indicates if this graph is connected(you can have a path between any two vertices)
	 * @return true, if it's connected and false if it's not
	 */
	public boolean connected(){
		String str = bfs(vertices.iterator().next());
		List<String> bfs = Arrays.asList(str.split("\\s*\n\\s*"));
		return  (bfs.size() == getVertexNumber());
	}


	/**
	 * Generates the Minimum Spanning Tree of this graph, it was used the Kruskal algorithm to calculate it
	 * @return A string with each edge of the tree
	 */
	public String mst(){

		String result = "Nao conectado!";
		if (connected()) {
			Queue<Edge> ordEdges = new LinkedList<>();
			List<Vertex> addedVertex = new LinkedList<>();
			((LinkedList<Edge>) ordEdges).addAll(edges);
			((LinkedList<Edge>) ordEdges).sort(Edge::compareTo);
			Edge actual;
			result = "";

			while (!ordEdges.isEmpty()) {
				actual = ((LinkedList<Edge>) ordEdges).pop();
				if(!addedVertex.contains(actual.getFirstVertice()) && !addedVertex.contains(actual.getSecondVertice())){
					addedVertex.add(actual.getFirstVertice());
					addedVertex.add(actual.getSecondVertice());
					result += "Edge: "+actual.getFirstVertice().getData()+" to "+actual.getSecondVertice().getData()+", weigh: "+actual.getWeight()+"\n";
				}else if (!addedVertex.contains(actual.getFirstVertice())){
					addedVertex.add(actual.getFirstVertice());
					result += "Edge: "+actual.getFirstVertice().getData()+" to "+actual.getSecondVertice().getData()+", weigh: "+actual.getWeight()+"\n";
				}else if (!addedVertex.contains(actual.getSecondVertice())){
					addedVertex.add(actual.getSecondVertice());
					result += "Edge: "+actual.getFirstVertice().getData()+" to "+actual.getSecondVertice().getData()+", weigh: "+actual.getWeight()+"\n";
				}

			}
		}

		return result;
	}

}
