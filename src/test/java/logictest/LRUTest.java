package logictest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import logic.LRU;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LRUTest {

	@ParameterizedTest(name = "[{index}] ==> frameName= ''{0}'', pageID= {1}, pageTable= {2}")
	@MethodSource("testAllocateSimpleProvider")
	void testAllocateSimple(char frameName, int counter, LRU lru) {
		assertEquals(frameName, lru.allocate(counter));
	}

	@ParameterizedTest(name = "[{index}] ==> frameName= ''{0}'', pageID= {1}, pageTable= {2}")
	@MethodSource("testAllocateWithUseProvider")
	void testAllocateWithUse(char frameName, int counter, LRU lru) {
		for (int i = 0; i < 4; i++) {
			lru.allocate(i+1);
		}

		lru.useFrame('A', 5);

		assertEquals(frameName, lru.allocate(counter));
	}

	static Stream<Arguments> testAllocateSimpleProvider() {
		LRU lru = new LRU();
		return Stream.of(
				Arguments.of('A', 1, lru),
				Arguments.of('B', 2, lru),
				Arguments.of('C', 3, lru),
				Arguments.of('D', 4, lru)
		);
	}

	static Stream<Arguments> testAllocateWithUseProvider() {
		LRU lru = new LRU();
		return Stream.of(
				Arguments.of('B', 6, lru),
				Arguments.of('C', 7, lru),
				Arguments.of('D', 8, lru),
				Arguments.of('A', 9, lru)
		);
	}

	@Test
	void testFramesWithMaxReferTime() {
		LRU lru = new LRU();

		lru.getPageFrameData().forEach(frame -> {
			frame.setReferTime(Integer.MAX_VALUE);
		});

		assertEquals('*', lru.allocate(1));
	}

}
