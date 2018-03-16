package laszlo.karsai.diploma.work.unit.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

import laszlo.karsai.diploma.work.Main;

/**
 * This class helps validate the example unit tests of Main class.
 * @author Karsai, Laszlo
 *
 */
public class MainTest {
	
	/**
	 * The function of this test case is to test the checking of database existence.
	 */
	@Test
	public void testCheckIfDatabaseExist() {
		File file = new File("energy_usage.db");
		assertTrue(file.exists());
	}

	/**
	 * The function of this test case is to test the checking if the processor is appropriate.
	 * @throws IOException
	 */
	@Test
	public void testCheckIfProcessorIsAppropriate() throws IOException {
		assertTrue(Main.checkIfProcessorIsAppropriate()); // should be true based on system specification
	}
	
	/**
	 * The function of this test case is to test the rounding of numbers into two digits.
	 */
	@Test
	public void testRound() {
		double nanNumber = Double.NaN;
		double infinityNumber = Double.POSITIVE_INFINITY;
		assertEquals(12.35,Main.round(12.3456789), 0);
		assertEquals(nanNumber,Main.round(nanNumber), 0);
		assertEquals(infinityNumber,Main.round(infinityNumber), 0);
	}

	/**
	 * The function of this test case is to test the rounding of numbers into five digits.
	 */
	@Test
	public void testRoundFiveDigits() {
		double nanNumber = Double.NaN;
		double infinityNumber = Double.POSITIVE_INFINITY;
		assertEquals(12.34568,Main.roundFiveDigits(12.3456789), 0);
		assertEquals(nanNumber,Main.roundFiveDigits(nanNumber), 0);
		assertEquals(infinityNumber,Main.roundFiveDigits(infinityNumber), 0);
	}
	
	/**
	 * The function of this test case is to test the checking if the input field text is able to be converted into double.
	 */
	@Test
	public void testIsDoubleNumber() {
		assertTrue(Main.isDoubleNumber("1"));
		assertTrue(Main.isDoubleNumber("1.3"));
		assertFalse(Main.isDoubleNumber("1,3"));
		assertFalse(Main.isDoubleNumber(""));
		assertFalse(Main.isDoubleNumber(null));
		assertFalse(Main.isDoubleNumber("code"));
	}
	
	/**
	 * The function of this test case is to test the reading of the number of logical processors.
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	@Test
	public void testGetNumOfLogicalProcessors() throws NumberFormatException, IOException {
		assertEquals(4, Main.getNumOfLogicalProcessors()); // should be 4 based on system specification
	}
	
}
