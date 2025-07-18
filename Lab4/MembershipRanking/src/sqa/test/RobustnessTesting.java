package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Ranking;

class RobustnessTesting {
	
Ranking ranking;
	
	@BeforeEach
	void setUp() throws Exception {
		ranking = new Ranking();
	}
	
	@ParameterizedTest(name = "[{index}] purchase={0}, freq={1}, point={2} => {3}")
    @CsvSource({
    	 "50000, 16, -1, Standard",
         "50000, 16, 0, Standard",
         "50000, 16, 1, Standard",
         "50000, 16, 500, Gold",
         "50000, 16, 999, Gold",
         "50000, 16, 1000, Gold",
         "50000, 16, 1001, Gold",
         "50000, -1, 500, Standard",
         "50000, 0, 500, Standard",
         "50000, 1, 500, Silver",
         "50000, 30, 500, Gold",
         "50000, 31, 500, Gold",
         "50000, 32, 500, Gold",
         "9999, 16, 500, Standard",
         "10000, 16, 500, Silver",
         "10001, 16, 500, Gold",
         "99999, 16, 500, Gold",
         "100000, 16, 500, Gold",
         "100001, 16, 500, Standard"
    })
    @DisplayName("Robustness Boundary Value Test")
    void testRobustnessCases(int purchaseTotal, int frequency, int pointCollected, String expectedLevel) {
		String result = ranking.CalculateMembershipRank(purchaseTotal, frequency, pointCollected);
		assertEquals(expectedLevel,result);
	}
	
}
