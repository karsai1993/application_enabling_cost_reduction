package laszlo.karsai.diploma.work.unit.test;

import static org.junit.Assert.*;

import org.junit.Test;

import laszlo.karsai.diploma.work.OperatingSystemMXBeanHandler;

/**
 * This class helps validate the constructor of the OperatingSystemMXBeanHandler class.
 * @author Karsai, Laszlo
 *
 */
public class OperatingSystemMXBeanHandlerTest {

	/**
	 * The function of this test case is to test the constructor of OperatingSystemMXBeanHandler class.
	 */
	@Test
	public void testOperatingSystemMXBeanHandler() {
		double totalPhysicalMemorySize = 20000;
		double freePhysicalMemorySize = 5000;
		double usedPhysicalMemorySize = totalPhysicalMemorySize - freePhysicalMemorySize;
		double systemCpuLoad = 0.87;
		double delta = 0;
		OperatingSystemMXBeanHandler operatingSystemMXBeanHandler = new OperatingSystemMXBeanHandler(totalPhysicalMemorySize, freePhysicalMemorySize, systemCpuLoad);
		assertEquals(20000, operatingSystemMXBeanHandler.getTotalPhysicalMemorySize(), delta);
		assertEquals(systemCpuLoad, operatingSystemMXBeanHandler.getSystemCpuLoad(), delta);
		assertEquals(usedPhysicalMemorySize, operatingSystemMXBeanHandler.getUsedPhysicalMemorySize(), delta);
		operatingSystemMXBeanHandler.setFreePhysicalMemorySize(7000);
		assertEquals(13000, operatingSystemMXBeanHandler.getUsedPhysicalMemorySize(), delta);
	}

}
