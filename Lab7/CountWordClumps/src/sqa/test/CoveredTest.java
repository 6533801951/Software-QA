//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import sqa.main.CountWordClumps;

class CoveredTest {
	
	@ParameterizedTest(name = "[{index}] numsArray{0} => {1}")
	@MethodSource("provideTestCases")
	void testWithMethodSource(int[] input, int expected) {
	    assertEquals(expected, CountWordClumps.countClumps(input));
	}

	static Stream<Arguments> provideTestCases() {
	    return Stream.of(
	        Arguments.of(null, 0),
	        Arguments.of(new int[] {}, 0),
	        Arguments.of(new int[] {1}, 0),
	        Arguments.of(new int[] {1, 2}, 0),
	        Arguments.of(new int[] {1, 1, 2}, 1),
	        Arguments.of(new int[] {1, 1, 2, 3, 3, 4}, 2)
	    );
	}
}
