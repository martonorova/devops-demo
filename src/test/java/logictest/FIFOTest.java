package logictest;

import static org.junit.jupiter.api.Assertions.*;

import logic.FIFO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class FIFOTest {

	@ParameterizedTest(name = "[{index}] ==> frameName= ''{0}'', pageID= {1}, pageTable= {2}, cntPageFails= {3}")
    @MethodSource("testAllocateProvider")
    void testAllocate(char frameName, int counter, FIFO fifo) {
	    assertEquals(frameName, fifo.allocate(counter));
    }

    static Stream<Arguments> testAllocateProvider() {
	    FIFO fifo = new FIFO();
	    return Stream.of(
	            Arguments.of('A', 1, fifo),
                Arguments.of('B', 2, fifo),
                Arguments.of('C', 3, fifo),
                Arguments.of('D', 4, fifo),
                Arguments.of('A', 5, fifo),
                Arguments.of('B', 6, fifo),
                Arguments.of('C', 7, fifo),
                Arguments.of('D', 8, fifo)
        );
    }

	@Test
    void testFramesWithMaxAllocTime() {

	    FIFO fifo = new FIFO();

	    fifo.getPageFrameData().forEach(frame -> {
            frame.setAllocTime(Integer.MAX_VALUE);
        });

	    assertThrows(IllegalArgumentException.class, () -> {
	        fifo.allocate(1);
        });
    }
}
