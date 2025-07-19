package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

class BoundaryValueTest {

	Ranking ranking;
	
	@BeforeEach
	void setUp() throws Exception {
		ranking = new Ranking();
	}
	@ParameterizedTest(name = "[{index}] purchase={0}, freq={1}, point={2} => {3}")
    @CsvSource({
        "50000, 15, 0,Standard",
        "50000, 15, 1,Standard",
        "50000, 15, 500,Gold",
        "50000, 15, 999,Gold",
        "50000, 15, 1000,Gold",
        "50000, 1, 500,Silver",
        "50000, 2, 500,Silver",
        "50000, 30, 500,Gold",
        "50000, 31, 500,Gold",
        "0, 15, 500,Standard",
        "1, 15, 500,Standard",
        "99999, 15, 500,Gold",
        "100000, 15, 500,Gold"
    })
    @DisplayName("Normal Boundary Value Test")
    void testNormalCases(int purchaseTotal, int frequency, int pointCollected, String expectedLevel) {
		String result = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expectedLevel,result);
	}
}
