import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import graphLibrary.Edge;
import graphLibrary.Vertex;

class EdgeTest {

	Vertex<Integer> v1;
	Vertex<Integer> v2;
	Vertex<Integer> v3;
	Vertex<Integer> v4;
	
	Edge e1;
	Edge e2;
	Edge e3;
	Edge e4;
	
	@BeforeEach
	void setUp() throws Exception {
		v1 = new Vertex<>(1);
		v2 = new Vertex<>(2);
		v3 = new Vertex<>(3);
		v4 = new Vertex<>(4);
		
		e1 = new Edge(v1, v2);
		e2 = new Edge(v2, v4);
		
		e3 = new Edge(v1, v2, (float) 1.0);
		e4 = new Edge(v2, v3, (float) 15.4);
	}

	@Test
	void testGetFirstVertice() {
		assertEquals(v1, e1.getFirstVertice());
		assertNotEquals(v2, e1.getFirstVertice());
	}

	@Test
	void testGetSecondVertice() {
		assertEquals(v2, e1.getSecondVertice());
		assertNotEquals(v3, e1.getSecondVertice());
	}

	@Test
	void testGetWeight() {
		assertEquals(new Float(1.0), e3.getWeight());
		assertEquals(new Float(15.4), e4.getWeight());
	}

	@Test
	void testSetWeight() {
		e3.setWeight(2);
		e4.setWeight(15);
		assertEquals(new Float(2.0), e3.getWeight());
		assertEquals(new Float(15.0), e4.getWeight());
		
	}

	@Test
	void testEqualsObject() {
		Edge auxEdge = new Edge(v1, v2);
		assertEquals(e1, auxEdge);
		assertNotEquals(null, e1);
		assertNotEquals(v1, e1);
	}

}
