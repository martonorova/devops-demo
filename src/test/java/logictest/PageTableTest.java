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

	//TODO if a test fails, get name of the source


	@ParameterizedTest
    @MethodSource(
            {"testFIFOProvider",
            "testLRUProvider",
            "testLRUPLProvider",
            "testFIFOOriginalInputProvider",
            "testLRUOriginalInputProvider",
            "testLRUPLOriginalInputProvider"
            }
    )
    void testPageTable(char frameName, int pageID, PageTable pageTable, int cntPageFails) {
        assertEquals(frameName, pageTable.referPage(pageID));
        assertEquals(cntPageFails, pageTable.getPageFails());
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

	static Stream<Arguments> testLRUProvider() {
		PageTable ptLRU = new PageTable(new LRU());
		return Stream.of(
				Arguments.of('A', 1, ptLRU, 1),
				Arguments.of('B', 2, ptLRU, 2),
				Arguments.of('C', 3, ptLRU, 3),
				Arguments.of('D', 4, ptLRU, 4),
				Arguments.of('-', 1, ptLRU, 4),
				Arguments.of('B', 5, ptLRU, 5)
				);
	}

    static Stream<Arguments> testLRUPLProvider() {
	    PageTable ptLRUPL = new PageTable(new LRUPL());
	    return Stream.of(
	            Arguments.of('A', 1, ptLRUPL, 1),
                Arguments.of('B', 2, ptLRUPL, 2),
                Arguments.of('C', 3, ptLRUPL, 3),
                Arguments.of('D', 4, ptLRUPL, 4),
                Arguments.of('*', 5, ptLRUPL, 5),
                Arguments.of('*', 5, ptLRUPL, 6),
                Arguments.of('A', 5, ptLRUPL, 7)
        );
    }

	static Stream<Arguments> testFIFOOriginalInputProvider() {
	    PageTable ptFIFO = new PageTable(new FIFO());
        return Stream.of(
                Arguments.of('A', 1, ptFIFO, 1),
                Arguments.of('B', 2, ptFIFO, 2),
                Arguments.of('C', 3, ptFIFO, 3),
                Arguments.of('D', 4, ptFIFO, 4),
                Arguments.of('-', 1, ptFIFO, 4),
                Arguments.of('A', 5, ptFIFO, 5),
                Arguments.of('B', 1, ptFIFO, 6)
        );
    }

	static Stream<Arguments> testLRUOriginalInputProvider() {
	    PageTable ptLRU = new PageTable(new LRU());
	    return Stream.of(
	            Arguments.of('A', 1, ptLRU, 1),
                Arguments.of('B', 2, ptLRU, 2),
                Arguments.of('C', 3, ptLRU, 3),
                Arguments.of('D', 4, ptLRU, 4),
                Arguments.of('-', 1, ptLRU, 4),
                Arguments.of('B', 5, ptLRU, 5),
                Arguments.of('-', 1, ptLRU, 5)
        );
    }

    static Stream<Arguments> testLRUPLOriginalInputProvider() {
        PageTable ptLRUPL = new PageTable(new LRUPL());
        return Stream.of(
                Arguments.of('A', 1, ptLRUPL, 1),
                Arguments.of('B', 2, ptLRUPL, 2),
                Arguments.of('C', 3, ptLRUPL, 3),
                Arguments.of('D', 4, ptLRUPL, 4),
                Arguments.of('-', 1, ptLRUPL, 4),
                Arguments.of('A', 5, ptLRUPL, 5),
                Arguments.of('*', 1, ptLRUPL, 6)
        );
    }
}
