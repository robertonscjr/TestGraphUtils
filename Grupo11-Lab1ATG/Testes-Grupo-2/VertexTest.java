import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import graphLibrary.Vertex;

class VertexTest {

	Vertex<Integer> v1;
	Vertex<Integer> v2;
	Vertex<Integer> v3;
	Vertex<Integer> v4;

	@BeforeEach
	void setUp() throws Exception {
		v1 = new Vertex<>(1);
		v2 = new Vertex<>(2);
		v3 = new Vertex<>(3);
		v4 = new Vertex<>(4);
	}

	@Test
	void testGetVisited() {
		assertFalse(v1.getVisited());
		v1.setVisited(true);
		assertTrue(v1.getVisited());
	}

	@Test
	void testSetVisited() {
		v2.setVisited(true);
		assertTrue(v2.getVisited());
		v2.setVisited(false);
		assertFalse(v2.getVisited());
	}

	@Test
	void testEqualsObject() {
		assertNotEquals(v1, v2);
		v2.setData(1);
		assertEquals(v1, v2);
		
	}

}
