package logictest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import logic.FIFO;
import logic.LRU;
import logic.LRUPL;
import logic.PageTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PageTableTest {
	
	private PageTable ptFIFO;
	private PageTable ptLRU;
	private PageTable ptLRUPL;

	@BeforeEach
	void setUp() throws Exception {
		ptFIFO = new PageTable(new FIFO());
		ptLRU = new PageTable(new LRU());
		ptLRUPL = new PageTable(new LRUPL());
	}

	@ParameterizedTest
    @MethodSource("testFIFOProvider")
    void testFIFO(char frameName, int pageID, PageTable ptFIFO, int cntPageFails) {
	    assertEquals(frameName, ptFIFO.referPage(pageID));
	    assertEquals(cntPageFails, ptFIFO.getPageFails());
    }

    static Stream<Arguments> testFIFOProvider() {
	    PageTable ptFIFO = new PageTable(new FIFO());
	    return Stream.of(
	            Arguments.of('A', 1, ptFIFO, 1),
                Arguments.of('-', 1, ptFIFO, 1),
                Arguments.of('B', 2, ptFIFO, 2),
                Arguments.of('C', 3, ptFIFO, 3),
                Arguments.of('D', 4, ptFIFO, 4),
                Arguments.of('-', 4, ptFIFO, 4),
                Arguments.of('A', 5, ptFIFO, 5),
                Arguments.of('B', 80, ptFIFO, 6)
        );
    }
	
	@Test
	void testLRU() {
		assertEquals('A', ptLRU.referPage(1));
		
		
		assertEquals('B', ptLRU.referPage(2));
		assertEquals('C', ptLRU.referPage(3));
		assertEquals('D', ptLRU.referPage(4));
		
		assertEquals('-', ptLRU.referPage(1));
		
		assertEquals('B', ptLRU.referPage(5));
	}

	
	
	@Test
	void testLRUPL() {
		assertEquals('A', ptLRUPL.referPage(1));
		assertEquals('B', ptLRUPL.referPage(2));
		assertEquals('C', ptLRUPL.referPage(3));
		assertEquals('D', ptLRUPL.referPage(4));
		
		assertEquals('*', ptLRUPL.referPage(5));
		assertEquals('*', ptLRUPL.referPage(5));
		assertEquals('A', ptLRUPL.referPage(5));
	}
	
	@Test
	void originalInputTestFIFO() {
		assertEquals('A', ptFIFO.referPage(1));
		assertEquals('B', ptFIFO.referPage(2));
		assertEquals('C', ptFIFO.referPage(3));
		assertEquals('D', ptFIFO.referPage(4));
		assertEquals('-', ptFIFO.referPage(1));
		assertEquals('A', ptFIFO.referPage(5));
		assertEquals('B', ptFIFO.referPage(1));
	}
	
	@Test
	void originalInputTestLRU() {
		assertEquals('A', ptLRU.referPage(1));
		assertEquals('B', ptLRU.referPage(2));
		assertEquals('C', ptLRU.referPage(3));
		assertEquals('D', ptLRU.referPage(4));
		assertEquals('-', ptLRU.referPage(1));
		assertEquals('B', ptLRU.referPage(5));
		assertEquals('-', ptLRU.referPage(1));
	}
	
	@Test
	void originalInputTestLRUPL() {
		assertEquals('A', ptLRUPL.referPage(1));
		assertEquals('B', ptLRUPL.referPage(2));
		assertEquals('C', ptLRUPL.referPage(3));
		assertEquals('D', ptLRUPL.referPage(4));
		assertEquals('-', ptLRUPL.referPage(1));
		assertEquals('A', ptLRUPL.referPage(5));
		assertEquals('*', ptLRUPL.referPage(1));
		
	}

}
