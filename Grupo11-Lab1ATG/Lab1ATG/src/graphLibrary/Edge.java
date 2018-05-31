package graphLibrary;

public class Edge implements Comparable<Edge>{

	public static final Float DEFAULT_WEIGHT = 1f;

	private Vertex u;
	private Vertex v;
	private Float weight;

	/**
	 * This class represents a Edge used for a graph to link two vertices
	 *
	 * @author Ronan
	 * @param u The first vertex that will be linked for this edge
	 * @param v The second vertex that will be linked for this edge
	 * @param weight The weight of this edge
	 */
	public Edge(Vertex u, Vertex v, Float weight) {
		this.u = u;
		this.v = v;

		if (weight == null) {
			this.weight = Edge.DEFAULT_WEIGHT;
		} else {
			this.weight = weight;
		}
	}

	public Edge(Vertex u, Vertex v) {
		this(u, v, null);
	}

	/** Returns one of the vertices of this edge
	 * @return a vertex object
	 */
	public Vertex getFirstVertice() {
		return u;
	}

	/** Returns one of the vertices of this edge
	 * @return a vertex object
	 */
	public Vertex getSecondVertice() {
		return v;
	}

	/**
	 * Returns the weight of this graph
	 * @return a float representing the weight
	 */
	public Float getWeight() {
		return weight;
	}


	/** Sets a new value for this edge's weight
	 * @param weight the new value of the edge's weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}


	/** Generates a unique value to represents this edge
	 * @return a int representing the hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((u == null) ? 0 : u.hashCode());
		result = prime * result + ((v == null) ? 0 : v.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}

	/**
	 * Indicates of this edge is equals to the object passed as a parameter
	 * @param obj the object to be compared
	 * @return true if both are idential and false if it's not
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if (u == null) {
			if (other.u != null)
				return false;
		} else if (!u.equals(other.u))
			return false;
		if (v == null) {
			if (other.v != null)
				return false;
		} else if (!v.equals(other.v))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	/**
	 * Compare to edges to see which one has the major weight
	 * @param o the edge to be compared to this one
	 * @return a negative integer, zero, or a positive integer as this object
	 *         is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Edge o) {
		return this.weight.compareTo(o.getWeight());
	}
	
	

}
