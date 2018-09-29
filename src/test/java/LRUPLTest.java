import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LRUPLTest {
	LRUPL lpl = new LRUPL();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		assertEquals('A', lpl.allocate(1));
		assertEquals('B', lpl.allocate(2));
		assertEquals('C', lpl.allocate(3));
		assertEquals('D', lpl.allocate(4));
		
		assertEquals('*', lpl.allocate(5));
//		assertEquals('A', lpl.allocate(6));
//		assertEquals('*', lpl.allocate(7));
		
	}

}
