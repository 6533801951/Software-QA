//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import sqa.main.Income;

class StrongRobustEquivalenceTesting {
	Income income;
	
	@BeforeEach
	public void SetupTest() {
		income = new Income();
	}
	@ParameterizedTest(name = "[{index}] num_impeller={0}, num_motor={1}, num_cover={2} => {3}")
	@CsvSource({
		"500,150,250,-1.0",
		"500,150,1000,-1.0",
		"500,150,6000,-1.0",
		"500,600,250,-1.0",
		"500,600,1000,-1.0",
		"500,600,6000,-1.0",
		"500,1600,250,-1.0",
		"500,1600,1000,-1.0",
		"500,1600,6000,-1.0",
		"2000,150,250,-1.0",
		"2000,150,1000,-1.0",
		"2000,150,6000,-1.0",
		"2000,600,250,-1.0",
		"2000,600,1000,58000",
		"2000,600,6000,-1.0",
		"2000,1600,250,-1.0",
		"2000,1600,1000,-1.0",
		"2000,1600,6000,-1.0",
		"10000,150,250,-1.0",
		"10000,150,1000,-1.0",
		"10000,150,6000,-1.0",
		"10000,600,250,-1.0",
		"10000,600,1000,-1.0",
		"10000,600,6000,-1.0",
		"10000,1600,250,-1.0",
		"10000,1600,1000,-1.0",
		"10000,1600,6000,-1.0"
	})
	@DisplayName("Strong Robust Equivalence Class Test")
	void StrongRobustTesting(int num_impeller, int num_motor, int num_cover, double expected) {
		Double result = income.calculateIncome(num_impeller, num_motor, num_cover);
		assertEquals(expected,result);
	}
}
