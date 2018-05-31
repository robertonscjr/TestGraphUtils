package graphLibrary;

import java.io.IOException;

/**
 * This class is a class with static methods to manipulate a graph, as was solicited and
 * is used follow the professor's signature of those methods
 */
public class GraphManager {

    /** This method read information from a txt file and generates a graph not weighted
     * @param path is the txt file to generate the graph
     * @return a graph resulting from the path passed as a parameter
     */
    public static Graph readGraph(String path) {
        try {
            return GraphReader.readGraph(path, false);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /** This method read information from a txt file and generates a graph weighted
     * @param path is the txt file to generate the graph
     * @return a graph resulting from the path passed as a parameter
     */
    public static Graph readGraphWeighted(String path) {
        try {
            return GraphReader.readGraph(path, true);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /** Returns the number of vertices of the graph passed
     * @param graph is the graph wanted
     * @return int representing the number of vertices
     */
    public static int getVertexNumber(Graph graph) {
        return graph.getVertexNumber();
    }

    /** Returns the number of edges of the graph passed
     * @param graph is the graph wanted
     * @return int representing the number of edges
     */
    public static int getEdgeNumber(Graph graph) {
        return graph.getEdgeNumber();
    }

    /**
     * Indicates the mean edge value of this graph, using the following formula: (2 * edgesNumber) / verticesNumber
     * @param graph is the graph wanted
     * @return a float of the mean edge
     */
    public static float getMeanEdge(Graph graph) {
        return graph.getMeanEdge();
    }

    /**
     * Returns a representation of this graph, that could be a Adjacency List or a Adjacency Matrix
     * @param graph is the graph wanted
     * @param type the type of your representation (AM or AL)
     * @return A string of the wanted representation
     */
    public static String graphRepresentation(Graph graph, String type) {
        if (type.equals("AM")) {
            return graph.graphRepresentation(Representation.AM);
        } else if (type.equals("AL")){
            return graph.graphRepresentation(Representation.AL);
        }
        return null;
    }
    /**
     * Generates a Breadth-First Search Tree
     * @param graph is the graph wanted
     * @param v is the root of the tree
     * @return String, where each line is
     * the "data - level parent" of a vertex
     */
    public static String bfs(Graph graph, Vertex v){
        return graph.bfs(v);
    }

    /**
     * Generates a Depth-First Search Tree and return as
     * @param graph is the graph wanted
     * @param v root of the DFS
     * @return String, where each line is
     * 	 * the "data - level parent" of a vertex
     */
    public static String dfs(Graph graph, Vertex v){
        return graph.dfs(v);
    }

    /**
     * Generates the shortest path between two vertices of this graph, it was used Djkistra Algorithm to find the path
     * @param g is the graph wanted
     * @param v1 the origin vertex
     * @param v2 the final vertex
     * @return A string representing the path (all vertices between them)
     */
    public static String shortestPath(Graph g, Vertex v1, Vertex v2) {
        return g.shortestPath(v1, v2);
    }

    /**
     * Generates the Minimum Spanning Tree of this graph, it was used the Kruskal algorithm to calculate it
     * @param graph is the graph wanted
     * @return A string with each edge of the tree
     */
    public static String mst(Graph graph) {
        return graph.mst();
    }

    /** Indicates if this graph is connected(you can have a path between any two vertices)
     * * @param graph is the graph wanted
     * @return true, if it's connected and false if it's not
     */
    public static boolean connected(Graph graph) { return graph.connected(); }
}
