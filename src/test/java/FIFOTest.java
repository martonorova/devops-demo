import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FIFOTest {
	private FIFO fifo = new FIFO();

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		try {
			assertEquals('A', fifo.allocate(1));
			assertEquals('B', fifo.allocate(2));
			assertEquals('C', fifo.allocate(3));
			assertEquals('D', fifo.allocate(4));
			
			assertEquals('A', fifo.allocate(5));
			assertEquals('B', fifo.allocate(6));
			assertEquals('C', fifo.allocate(7));
			assertEquals('D', fifo.allocate(8));
			
			assertEquals('A', fifo.allocate(9));
			assertEquals('B', fifo.allocate(10));
			assertEquals('C', fifo.allocate(11));
			assertEquals('D', fifo.allocate(12));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
    void testFramesWithMaxAllocTime() {

	    fifo.pageFrameData.forEach(frame -> {
            frame.setAllocTime(Integer.MAX_VALUE);
        });

	    assertThrows(IllegalArgumentException.class, () -> {
	        fifo.allocate(1);
        });

    }
}
