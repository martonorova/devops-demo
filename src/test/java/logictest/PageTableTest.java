package logictest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import logic.FIFO;
import logic.LRU;
import logic.LRUPL;
import logic.PageTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	@Test
	void testFIFO() {
		assertEquals('A', ptFIFO.referPage(1));
		assertEquals('-', ptFIFO.referPage(1));
		
		assertEquals('B', ptFIFO.referPage(2));
		assertEquals('C', ptFIFO.referPage(3));
		assertEquals('D', ptFIFO.referPage(4));
		
		assertEquals('-', ptFIFO.referPage(4));
		
		assertEquals('A', ptFIFO.referPage(5));
		assertEquals('B', ptFIFO.referPage(80));
		assertEquals(6, ptFIFO.getPageFails());
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
