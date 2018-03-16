package laszlo.karsai.diploma.work.unit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import laszlo.karsai.diploma.work.ProcessData;

/**
 * This class helps validate the constructor of the ProcessData class.
 * @author Karsai, Laszlo
 *
 */
public class ProcessDataTest {
	
	String name;
	double memUsage;
	double cpuUsage;
	String windowTitle;
	int index;
	int processId;
	double cpuTimeInSec;
	String status;
	String userName;

	/**
	 * Its function is to initialize values before each test case.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		name = "unit_test_process.exe";
		memUsage = 300;
		cpuUsage = 60;
		windowTitle = "Creating Unit Tests";
		index = 0;
		processId = 410;
		cpuTimeInSec = 25;
		status = "Running";
		userName = "N/A";
	}
	
	/**
	 * The function of this test case is to test the constructor of ProcessData class.
	 */
	@Test
	public void testProcessDataIntStringDoubleDouble() {
		ProcessData processData = new ProcessData(processId, name, memUsage, cpuUsage);
		assertEquals(300, processData.getMemUsage(), 0);
		assertNull(processData.getWindowTitle());
		processData.setProcessId(423);
		assertEquals(423, processData.getProcessId());
	}

	/**
	 * The function of this test case is to test the constructor of ProcessData class.
	 */
	@Test
	public void testProcessDataStringDoubleDoubleStringIntDoubleStringString() {
		ProcessData processData = new ProcessData(name, index, memUsage, cpuUsage, windowTitle, processId);
		assertEquals("Creating Unit Tests", processData.getWindowTitle());
	}

	/**
	 * The function of this test case is to test the constructor of ProcessData class.
	 */
	@Test
	public void testProcessDataStringIntDoubleDoubleStringInt() {
		ProcessData processData = new ProcessData(name, index, memUsage, cpuUsage, windowTitle, processId);
		assertEquals(0, processData.getIndex());
	}

}
