import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestCaseRomanNumerals {

	RomanNumerals romannumerals = new RomanNumerals();

	// TC01: Input = I, Expected result = 1
	@Test
	void testSingleDigit() {
		int result = romannumerals.convertRomanNumToInt("I");
		assertEquals(1, result);
	}

	// TC02: Input = IX, Expected result = 9
	@Test
	void testDoubleDigitSmaller() {
		int result = romannumerals.convertRomanNumToInt("IX");
		assertEquals(9, result);
	}

	// TC03: Input = CX, Expected result = 110
	@Test
	void testDoubleDigitGreater() {
		int result = romannumerals.convertRomanNumToInt("CX");
		assertEquals(110, result);
	}

	// TC04: Input = XX, Expected result = 20
	@Test
	void testSameDoubleDigit() {
		int result = romannumerals.convertRomanNumToInt("XX");
		assertEquals(20, result);
	}

	// TC05: Input = CCC, Expected result = 300
	@Test
	void testSameThreeDigit() {
		int result = romannumerals.convertRomanNumToInt("CCC");
		assertEquals(300, result);
	}

	// TC06: Input = XXVI, Expected result = 26
	@Test
	void testFirstDigitLarger() {
		RomanNumerals romannumerals = new RomanNumerals();
		int result = romannumerals.convertRomanNumToInt("XXVI");

		assertEquals(26, result);
	}

	// TC07: Input = LXVII, Expected result = 67
	@Test
	void testFirstDigitLargest() {
		int result = romannumerals.convertRomanNumToInt("LXVII");
		assertEquals(67, result);
	}

	// TC08: Input = A, Expected result = Error
	@Test
	void testNotRomanNumber() {
		assertThrows(NullPointerException.class, () -> romannumerals.convertRomanNumToInt("A"));

	}

	// TC09: Input = LL, Expected result = Error
	@Test
	void testWrongRepeatDigit() {
		int result = romannumerals.convertRomanNumToInt("LL");
		assertEquals(100, result,"Using wrong repeating digits");
	}

	// TC10: Input = XXXX, Expected result = Error
	@Test
	void testRepeatMoreThanThree() {
		int result = romannumerals.convertRomanNumToInt("XXXX");
		assertEquals(40, result,"Using more than three repeating roman numerals");
	}
}
