//นายณธฬ จันทร์หอม 653380195-1 sec.2
package sqa.test;

import sqa.main.*;

public class CookingConversionCalculatorStud extends CookingConversionCalculator{
	@Override
	public double convert(double value, String choice, String fromUnit, String toUnit) {
		double result = 0.0;
		
		TemperatureConverter tempConverter = new TemperatureConverterStud();
		MassConverter massConverter = new MassConverterStud();
		LiquidVolumeConverter liquidConverter = new LiquidVolumeConverterStud();
		
		if (choice.equals("temperature")) {
			result = tempConverter.convert(value, fromUnit, toUnit);
		} else if (choice.equals("mass")) {
			result = massConverter.convert(value, fromUnit, toUnit);
		} else if (choice.equals("liquid")) {
			result = liquidConverter.convert(value, fromUnit, toUnit);
		} 
		
		return result;
	}
}

