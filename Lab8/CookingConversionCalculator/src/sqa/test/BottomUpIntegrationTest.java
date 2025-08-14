//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import sqa.main.*;
class BottomUpIntegrationTest {

	@Test
	void TemperatureConverterTest_fahrenheit() {
		TemperatureConverter test = new TemperatureConverter();
		double result = test.convert(120, "fahrenheit","celsius");
		assertEquals(48.8889,result,0.01);
	}
	@Test
	void TemperatureConverterTest_celsius() {
		TemperatureConverter test = new TemperatureConverter();
		double result = test.convert(40, "celsiusfahrenheit","fahrenheit");
		assertEquals(104.0,result,0.01);
	}
	@Test
	void TemperatureConverterTest_invalid1() {
		TemperatureConverter test = new TemperatureConverter();
		double result = test.convert(100, "invalid_input","fahrenheit");
		assertEquals(0.0,result);
	}
	@Test
	void TemperatureConverterTest_invalid2() {
		TemperatureConverter test = new TemperatureConverter();
		double result = test.convert(100, "celsiusfahrenheit","invalid_input");
		assertEquals(0.0,result);
	}
	@Test
	void TemperatureConverterTest_invalid3() {
		TemperatureConverter test = new TemperatureConverter();
		double result = test.convert(100, "invalid_input","invalid_input");
		assertEquals(0.0,result);
	}
	@Test
	void MassConverterTest_cup() {
		MassConverter test = new MassConverter();
		double result = test.convert(2, "cup","gram");
		assertEquals(250.0,result,0.01);
	}
	@Test
	void MassConverterTest_tablespoon() {
		MassConverter test = new MassConverter();
		double result = test.convert(4, "tablespoon","gram");
		assertEquals(32.0,result,0.01);
	}
	@Test
	void MassConverterTest_teaspoon() {
		MassConverter test = new MassConverter();
		double result = test.convert(5, "teaspoon","gram");
		assertEquals(15.0,result,0.01);
	}
	@Test
	void MassConverterTest_oz() {
		MassConverter test = new MassConverter();
		double result = test.convert(3, "oz","gram");
		assertEquals(85.047,result,0.01);
	}
	@Test
	void MassConverterTest_pound() {
		MassConverter test = new MassConverter();
		double result = test.convert(3, "pound","kilogram");
		assertEquals(1.362,result,0.01);
	}
	@Test
	void MassConverterTest_gram() {
		MassConverter test = new MassConverter();
		double result = test.convert(85, "gram","oz");
		assertEquals(2.975,result,0.01);
	}
	@Test
	void MassConverterTest_kilogram() {
		MassConverter test = new MassConverter();
		double result = test.convert(4, "kilogram","pound");
		assertEquals(8.82,result,0.01);
	}
	@Test
	void MassConverterTest_invalid1() {
		MassConverter test = new MassConverter();
		double result = test.convert(10, "invalid_input","gram");
		assertEquals(10.0,result);
	}
	@Test
	void MassConverterTest_invalid2() {
		MassConverter test = new MassConverter();
		double result = test.convert(10, "cup","invalid_input");
		assertEquals(10.0,result);
	}
	@Test
	void MassConverterTest_invalid3() {
		MassConverter test = new MassConverter();
		double result = test.convert(10, "invalid_input","invalid_input");
		assertEquals(10.0,result);
	}
	@Test
	void LiquidVolumeConverterTest_cup_ml() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(2, "cup","ml");
		assertEquals(500.0,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_cup_oz() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(5, "cup","oz");
		assertEquals(40.0,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_tablespoon_ml() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10, "tablespoon","ml");
		assertEquals(150.0,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_teaspoon_ml() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10, "teaspoon","ml");
		assertEquals(50.0,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_oz_ml() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10, "oz","ml");
		assertEquals(295.74,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_pint_ml() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(2, "pint","ml");
		assertEquals(946.352,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_quart_liter() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(5, "quart","liter");
		assertEquals(4.73,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_ml_oz() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(100, "ml","oz");
		assertEquals(3.4,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_liter_pint() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10,"liter","pint");
		assertEquals(21.13,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_liter_quart() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10,"liter","quart");
		assertEquals(10.57,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_liter_gallon() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10,"liter","gallon");
		assertEquals(2.64,result,0.01);
	}
	@Test
	void LiquidVolumeConverterTest_invalid1() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10, "invalid_input","ml");
		assertEquals(10.0,result);
	}
	@Test
	void LiquidVolumeConverterTest_invalid2() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10, "cup","invalid_input");
		assertEquals(10.0,result);
	}
	@Test
	void LiquidVolumeConverterTest_invalid3() {
		LiquidVolumeConverter test = new LiquidVolumeConverter();
		double result = test.convert(10, "invalid_input","invalid_input");
		assertEquals(10.0,result);
	}
	@Test
	void CookingConversionCalculator_temperature() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(120,"temperature", "fahrenheit","celsius");
		assertEquals(48.8889,result,0.01);
	}
	@Test
	void CookingConversionCalculator_mass() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(2,"mass", "cup","gram");
		assertEquals(250.0,result,0.01);
	}
	@Test
	void CookingConversionCalculator_liquid() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(2,"liquid","cup","ml");
		assertEquals(500.0,result,0.01);
	}
	@Test
	void CookingConversionCalculator_invalid() {
		CookingConversionCalculator test = new CookingConversionCalculator();
		double result = test.convert(10,"invalid","","");
		assertEquals(0.0,result);
	}

}
