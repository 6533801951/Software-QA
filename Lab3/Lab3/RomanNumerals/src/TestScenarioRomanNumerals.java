import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.util.Map;

import org.junit.jupiter.api.Test;

class TestScenarioRomanNumerals {

	RomanNumerals romannumerals = new RomanNumerals();

	// Step 1: รับ input เป็นอักขระโรมัน เช่น LV
	@Test
	void testStep1_inputIsRomanString() {
		String input = "LV";
		assertDoesNotThrow(() -> romannumerals.convertRomanNumToInt(input));
	}

	// Step 2: เปรียบเทียบระหว่างอัขระที่ได้กับตาราง
	@Test
	void testStep2_AllCharactersAreInMap() throws Exception {
		String input = "IVXLC";

		// เข้าถึง field 'map' ของคลาส RomanNumerals โดยใช้ Reflection
		Field mapField = RomanNumerals.class.getDeclaredField("map");
		mapField.setAccessible(true);
		@SuppressWarnings("unchecked")
		Map<Character, Integer> romanMap = (Map<Character, Integer>) mapField.get(null); // static field = null

		// ตรวจสอบว่าอักขระทุกตัวใน input อยู่ใน map
		for (char c : input.toCharArray()) {
			assertTrue(romanMap.containsKey(c), "Character '" + c + "' not in Roman Table");
		}
	}

	// Step 3: ถ้ามีมากกว่าหนึ่งตัว จะเปรียบเทียบค่าปัจจุบันกับค่าถัดไป
	@Test
	void testStep3_SingleDigitPattern() {
		int result = romannumerals.convertRomanNumToInt("X");
		assertEquals(10, result);
	}

	// Step 4: อ่านจากซ้ายไปขวา ถ้าค่าปัจจุบันมีค่ามากกว่าหรือเท่ากับค่าถัดไป
	// จะนำทั้งสองค่าบวกรวมกัน
	@Test
	void testStep4_additivePattern() {
		int result = romannumerals.convertRomanNumToInt("XX");
		assertEquals(20, result);
	}

	// Step 5: ถ้าค่าปัจจุบันมีค่าน้อยกว่าค่าถัดไป จะนำค่าปัจจุบันลบกับค่าถัดไป
	@Test
	void testStep5_subtractivePattern() {
		int result = romannumerals.convertRomanNumToInt("IX");
		assertEquals(9, result);
	}

	// Step 6: ทำซ้ำจนหมด input
	@Test
	void testStep6_fullConversion() {
		int result = romannumerals.convertRomanNumToInt("LV");
		assertEquals(55, result);
	}
}