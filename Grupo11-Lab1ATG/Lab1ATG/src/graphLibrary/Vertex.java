package graphLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * This class is a representation of a vertex in a graph.
 *
 * @author klynger and Ronan
 *
 * @param <T> Type of data that the vertex will hold
 */
public class Vertex<T> {
	private T data;
	private boolean visited; // Variable used for generate DFS

	public Vertex(T data) {
		this.data = data;
		this.visited = false;
	}

	public Vertex() {
		this(null);
	}

	/** Returns the data of this vertex
	 * @return the data of this vertex
	 */
	public T getData() {
		return data;
	}

	/** Sets a new data to this vertex
	 * @param data the new value to be setted
	 */
	public void setData(T data) {
		this.data = data;
	}


	/** Returns if this vertex was already visited in the DFS
	 * @return true if the vertex was already visited and false if it's not
	 */
	public boolean getVisited() { return visited; }

	/** Set a new value to the visited attribute
	 * @param status the new status of the visited attribute
	 */
	public void  setVisited(boolean status) { this.visited = status;	}

	/** Generates a unique number to differentiate this vertex
	 * @return int with the hash code
	 */
	@Override
	public int hashCode() {
		return (Integer) data;
	}

	/** Verify if this vertex and the obj passed as a parameter are equals
	 * @param obj object to be compared with this vertex
	 * @return true if both are equals and false if it's not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		Vertex<T> vertex = (Vertex<T>) obj;

		return (vertex.getData() != null && this.data == vertex.getData());


	}
}