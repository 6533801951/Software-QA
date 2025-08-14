//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.test;

import static org.junit.jupiter.api.Assertions.*;
import sqa.main.*;
import org.junit.jupiter.api.Test;

class TopDownIntegrationTest {

	@Test
	void CookingConversionTemperatureTest() {
		CookingConversionCalculatorStud test = new CookingConversionCalculatorStud();
		double result = test.convert(100, "temperature", "fromunit","tounit");
		assertEquals(100.0,result,0.01);
	}
	@Test
	void CookingConversionMassTest() {
		CookingConversionCalculatorStud test = new CookingConversionCalculatorStud();
		double result = test.convert(100, "mass", "fromunit","tounit");
		assertEquals(100.0,result,0.01);
	}
	@Test
	void CookingConversionLiquidTest() {
		CookingConversionCalculatorStud test = new CookingConversionCalculatorStud();
		double result = test.convert(100, "liquid", "fromunit","tounit");
		assertEquals(100.0,result,0.01);
	}
	@Test
	void CookingConversion_Invalid() {
		CookingConversionCalculatorStud test = new CookingConversionCalculatorStud();
		double result = test.convert(100, "invalid_input", "fromunit", "tounit");
		assertEquals(0.0,result);
	}
	@Test
	void TemperatureConverterTest_fahrenheit() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(120, "temperature", "fahrenheit","celsius");
		assertEquals(48.8889,result,0.01);
	}
	@Test
	void TemperatureConverterTest_celsius() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(40, "temperature", "celsiusfahrenheit","fahrenheit");
		assertEquals(104.0,result,0.01);
	}
	@Test
	void TemperatureConverterTest_invalid1() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(40, "temperature", "invalid_input","fahrenheit");
		assertEquals(0.0,result);
	}
	@Test
	void TemperatureConverterTest_invalid2() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(40, "temperature", "celsiusfahrenheit","invalid_input");
		assertEquals(0.0,result);
	}
	@Test
	void TemperatureConverterTest_invalid3() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(40, "temperature", "invalid_input","invalid_input");
		assertEquals(0.0,result);
	}
	@Test
	void MassConverterTest_cup() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(2, "mass", "cup","gram");
		assertEquals(250.0,result,0.01);
	}
	@Test
	void MassConverterTest_tablespoon() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(4, "mass", "tablespoon","gram");
		assertEquals(32.0,result,0.01);
	}
	@Test
	void MassConverterTest_teaspoon() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(5, "mass", "teaspoon","gram");
		assertEquals(15.0,result,0.01);
	}
	@Test
	void MassConverterTest_oz() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(3, "mass", "oz","gram");
		assertEquals(85.047,result,0.01);
	}
	@Test
	void MassConverterTest_pound() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(3, "mass", "pound","kilogram");
		assertEquals(1.362,result,0.01);
	}
	@Test
	void MassConverterTest_gram() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(85, "mass", "gram","oz");
		assertEquals(2.975,result,0.01);
	}
	@Test
	void MassConverterTest_kilogram() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(4, "mass", "kilogram","pound");
		assertEquals(8.82,result,0.01);
	}
	@Test
	void MassConverterTest_invalid1() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "mass", "invalid_input","pound");
		assertEquals(10.0,result);
	}
	@Test
	void MassConverterTest_invalid2() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "mass", "cup","invalid_input");
		assertEquals(10.0,result);
	}
	@Test
	void MassConverterTest_invlid3() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "mass", "invalid_input","invalid_input");
		assertEquals(10.0,result);
	}
	@Test
	void LiquidVolumeConverterTest_cup_ml() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(2, "liquid", "cup","ml");
		assertEquals(500.0,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_cup_oz() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(5, "liquid", "cup","oz");
		assertEquals(40.0,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_tablespoon_ml() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid", "tablespoon","ml");
		assertEquals(150.0,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_teaspoon_ml() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid", "teaspoon","ml");
		assertEquals(50.0,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_oz_ml() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid", "oz","ml");
		assertEquals(295.74,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_pint_ml() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(2, "liquid", "pint","ml");
		assertEquals(946.352,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_quart_liter() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(5, "liquid", "quart","liter");
		assertEquals(4.73,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_ml_oz() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(100, "liquid", "ml","oz");
		assertEquals(3.4,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_liter_pint() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid","liter","pint");
		assertEquals(21.13,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_liter_quart() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid","liter","quart");
		assertEquals(10.57,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_liter_gallon() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid","liter","gallon");
		assertEquals(2.64,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_invalid1() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid","invalid_input","ml");
		assertEquals(10.0,result);
	}
	@Test
	void LiquidVolumeConverterTest_invalid2() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid","cup","invalid_input");
		assertEquals(10.0,result);
	}
	@Test
	void LiquidVolumeConverterTest_invalid3() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10, "liquid","invalid_input","invalid_input");
		assertEquals(10.0,result);
	}
}

