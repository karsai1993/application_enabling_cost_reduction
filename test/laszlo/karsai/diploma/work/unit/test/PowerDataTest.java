package laszlo.karsai.diploma.work.unit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import laszlo.karsai.diploma.work.PowerData;

/**
 * This class helps validate the constructor of the PowerData class.
 * @author Karsai, Laszlo
 *
 */
public class PowerDataTest {

	/**
	 * The function of this test case is to test the constructor of PowerData class.
	 */
	@Test
	public void testPowerData() {
		PowerData powerData = new PowerData(10.5);
		assertEquals(10.5, powerData.getPowerInWatt(), 0);
		powerData.setPowerInWatt(20.5);
		assertEquals(20.5, powerData.getPowerInWatt(), 0);
	}

}
