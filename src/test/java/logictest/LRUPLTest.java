package logictest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import logic.LRUPL;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class LRUPLTest {
	//private static LRUPL lrupl;

	@BeforeAll
    static void initAll() {
	    //lrupl = new LRUPL();
    }

	@BeforeEach
	void setUp() throws Exception {
	}

	@ParameterizedTest
    @MethodSource("testAllocateProvider")
	void testAllocate(char frameName, int counter, LRUPL lrupl) {
	    assertEquals(frameName, lrupl.allocate(counter));
	}

	static Stream<Arguments> testAllocateProvider() {
	    LRUPL lrupl = new LRUPL();
	    return Stream.of(
	            Arguments.of('A', 1, lrupl),
                Arguments.of('B', 2, lrupl),
                Arguments.of('C', 3, lrupl),
                Arguments.of('D', 4, lrupl),
                Arguments.of('*', 5, lrupl)
                //Arguments.of('A', 6, lrupl),
                //Arguments.of('*', 7, lrupl)
        );
    }

}
