//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LimitedEntryDecisionTableTesting {

	@ParameterizedTest(name = "[{index}] pack={0},offline={1},live={2},discount={3} =>{4}")
	@CsvSource({
		"STANDARD,false,false,false,150",
		"STANDARD,false,false,true,100",
		"STANDARD,true,false,false,250",
		"STANDARD,false,true,false,250",
		"STANDARD,true,false,true,200",
		"STANDARD,false,true,true,200",
		"STANDARD,true,true,false,350",
		"STANDARD,true,true,true,300",
		"PREMIUM,false,false,false,350",
		"PREMIUM,false,false,true,300",
		"PREMIUM,true,false,false,450",
		"PREMIUM,false,true,false,450",
		"PREMIUM,true,false,true,400",
		"PREMIUM,false,true,true,400",
		"PREMIUM,true,true,false,550",
		"PREMIUM,true,true,true,500",
		"FAMILY,false,false,false,450",
		"FAMILY,false,false,true,400",
		"FAMILY,true,false,false,550",
		"FAMILY,false,true,false,550",
		"FAMILY,true,false,true,500",
		"FAMILY,false,true,true,500",
		"FAMILY,true,true,false,650",
		"FAMILY,true,true,true,600"
	})
	@DisplayName("Limited Entey Decision Table Test")
	void testLimitedEntryDecisionCases(String pack, boolean offline, boolean live, boolean discount, double expected) {
		TVPlan.TVPackage TvPackage = TVPlan.TVPackage.valueOf(pack);
		TVPlan plan = new TVPlan(offline, live, discount);
		assertEquals(expected, plan.pricePerMonth(TvPackage));
	}
	@ParameterizedTest(name = "[{index}] error pack={0},offline={1},live={2},discount={3}")
	@CsvSource({
		"STANDARD,PREMIUM,false,false,false",
		"STANDARD,FAMILY,false,false,false",
		"PREMIUM,FAMILY,false,false,false",
		"STANDARD,PREMIUM,FAMILY,false,false,false",
		",false,false,false",
		",false,false,true",
		",true,false,false",
		",false,true,false",
		",true,false,true",
		",false,true,true",
		",true,true,false",
		",true,true,true"
	})
	void testExpectError(String pack, boolean offline, boolean live, boolean discount) {
	    TVPlan plan = new TVPlan(offline, live, discount);

	    assertThrows(NullPointerException.class, () -> {
	        TVPlan.TVPackage TvPackage = (pack == null || pack.equals("null")) ? null : TVPlan.TVPackage.valueOf(pack);
	        plan.pricePerMonth(TvPackage);
	    });
	}
}
