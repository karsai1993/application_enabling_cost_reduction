package laszlo.karsai.diploma.work.unit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import laszlo.karsai.diploma.work.CpuCalculationHelper;

/**
 * This class helps validate the constructor of the CpuCalculationHelper class.
 * @author Karsai, Laszlo
 *
 */
public class CpuCalculationHelperTest {

	/**
	 * The function of this test case is to test the constructor of CpuCalculationHelper class.
	 */
	@Test
	public void testCpuCalculationHelper() {
		int processId = 10;
		double elapsedTime = 1000;
		double delta = 0;
		CpuCalculationHelper cpuCalculationHelper = new CpuCalculationHelper(processId, elapsedTime);
		assertEquals(processId, cpuCalculationHelper.getProcessId());
		assertEquals(elapsedTime, cpuCalculationHelper.getElapsedTime(), delta);
		int newProcessId = 20;
		double newElapsedTime = 2000;
		cpuCalculationHelper.setProcessId(newProcessId);
		cpuCalculationHelper.setElapsedTime(newElapsedTime);
		assertEquals(newProcessId, cpuCalculationHelper.getProcessId());
		assertEquals(newElapsedTime, cpuCalculationHelper.getElapsedTime(), delta);
	}

}
