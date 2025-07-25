//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import sqa.main.ShippingVehicle;

class CategoryPartitionTesting {

	@ParameterizedTest(name = "[{index}] Small={0}, Medium={1}, Large={2} => {3}")
	@MethodSource("provideTestCases")
	void CategoryPartitionTest(int small,int medium,int large, List<Integer> expected) {
		ShippingVehicle result = new ShippingVehicle();
		List<Integer> actual = result.calculate(small,medium,large);
		assertEquals(expected,actual);
	}
	
	private static Stream<Arguments> provideTestCases(){
		return Stream.of(
			Arguments.of(0,0,0, List.of(0,0,0)),
			Arguments.of(10,10,10, List.of(10,10,10)), 	
			Arguments.of(0,0,101, List.of(-1)), 	
			Arguments.of(0,10,10, List.of(10,10,0)), 	
			Arguments.of(1,0,0, List.of(0,0,1)), 	
			Arguments.of(100,0,0, List.of(0,0,100)), 	
			Arguments.of(0,0,10, List.of(10,0,0)), 	
			Arguments.of(0,1,0, List.of(0,1,0)), 	
			Arguments.of(0,100,0, List.of(0,100,0)), 	
			Arguments.of(10,10,0, List.of(10,10,0)), 	
			Arguments.of(0,0,1, List.of(1,0,0)), 	
			Arguments.of(0,0,100, List.of(100,0,0)), 	
			Arguments.of(0,0,50, List.of(50,0,0)), 	
			Arguments.of(3,1,0, List.of(0,1,3)), 	
			Arguments.of(0,20,0, List.of(0,20,0)), 	
			Arguments.of(1,1,0, List.of(0,1,1)), 	
			Arguments.of(2,0,0, List.of(0,0,2)), 	
			Arguments.of(5,10,95, List.of(95,10,5)), 	
			Arguments.of(0,0,500, List.of(0,0,500)), 	
			Arguments.of(0,200,1, List.of(-1)), 	
			Arguments.of(501,0,0, List.of(-1)), 	
			Arguments.of(-1,0,0, List.of(-1))
			);
	}
}
