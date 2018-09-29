import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LRUTest {
	LRU lru = new LRU();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		assertEquals('A', lru.allocate(1));
		assertEquals('B', lru.allocate(2));
		assertEquals('C', lru.allocate(3));
		assertEquals('D', lru.allocate(4));
		
		lru.useFrame('A', 5);
		
		assertEquals('B', lru.allocate(6));
		assertEquals('C', lru.allocate(7));
		assertEquals('D', lru.allocate(8));
		assertEquals('A', lru.allocate(9));
	}

}
