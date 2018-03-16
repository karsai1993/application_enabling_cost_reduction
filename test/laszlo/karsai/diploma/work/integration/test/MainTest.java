package laszlo.karsai.diploma.work.integration.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import laszlo.karsai.diploma.work.Main;
import laszlo.karsai.diploma.work.PowerData;
import laszlo.karsai.diploma.work.ProcessData;

/**
 * This class helps validate the example integration tests of Main class.
 * @author Karsai, Laszlo
 *
 */
public class MainTest {
	
	Connection connect = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Calendar calendar = null;

    /**
     * Its function is to create the database connection.
     * @throws Exception
     */
	@Before
	public void setUp() throws Exception {
		Path currentRelativePath = Paths.get("");
		String currentPath = currentRelativePath.toAbsolutePath().toString();
		String url = "jdbc:sqlite:"+currentPath+"/energy_usage.db";
		connect = DriverManager.getConnection(url);
		calendar = Calendar.getInstance();
	}
	
	/**
	 * Its function is to close the database connection.
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		connect.close();
	}

	/**
	 * The function of this test case is to test the checking if the specific application is installed.
	 * @throws IOException
	 */
    @Test
	public void testCheckIfAppropriateAppIsInstalled() throws IOException {
		Boolean isProcessorAppropriate = Main.checkIfProcessorIsAppropriate(); // should be true based on system specification
		assertTrue(Main.checkIfAppropriateAppIsInstalled(isProcessorAppropriate));
		isProcessorAppropriate = false; // let's assume it is false
		assertFalse(Main.checkIfAppropriateAppIsInstalled(isProcessorAppropriate));
	}
    
    /**
     * The function of this test case is to test the production of process data.
     * @throws NumberFormatException
     * @throws IOException
     */
    @Test
	public void testCreateBasicProcessDataArray() throws NumberFormatException, IOException {
		int numberOfLogicalProcessors = Main.getNumOfLogicalProcessors();
		List<ProcessData> dataArray = Main.createBasicProcessDataArray(numberOfLogicalProcessors);
		assertTrue(dataArray.size() != 0);
		assertTrue(dataArray.get(0).getName() != null);
		assertTrue(dataArray.get(0).getWindowTitle() != null);
	}

    /**
     * The function of this test case is to test the production of process data.
     * @throws NumberFormatException
     * @throws IOException
     */
	@Test
	public void testCreateAdvancedProcessDataArray() throws NumberFormatException, IOException {
		int numberOfLogicalProcessors = Main.getNumOfLogicalProcessors();
		List<ProcessData> dataArray = Main.createAdvancedProcessDataArray(numberOfLogicalProcessors);
		assertTrue(dataArray.size() != 0);
		assertTrue(dataArray.get(0).getName() != null);
		assertFalse(dataArray.get(0).getWindowTitle() != null);
	}
	
	/**
	 * The function of this test case is to test the production of power data.
	 * @throws IOException
	 */
	@Test
	public void testGetPowerData() throws IOException {
		Boolean isProcessorAppropriate = Main.checkIfProcessorIsAppropriate();
		Boolean isAppropriateAppInstalled = Main.checkIfAppropriateAppIsInstalled(isProcessorAppropriate);
		PowerData powerData = Main.getPowerData(isAppropriateAppInstalled);
		assertTrue(powerData != null);
		assertTrue(powerData.getPowerInWatt() > 0);
	}
	
	/**
	 * The function of this test case is to test the connection to alerts table of the database.
	 * @throws SQLException
	 */
	@Test
	public void testDatabaseAlertsTableOperations() throws SQLException {
		Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
		preparedStatement = connect.prepareStatement("insert into `alerts` "
				+ "(`type`,`time`,`name`,`value`,`limit`)"
				   +" values (?,?,?,?,?)");
		preparedStatement.setString(1, "cpu");
		preparedStatement.setTimestamp(2, timestamp);
		preparedStatement.setString(3, "unit_test_process.exe");
		preparedStatement.setString(4, "70");
		preparedStatement.setDouble(5, 71);
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement("select * "
				+ "from `alerts` "
				+ "where `name`=\"unit_test_process.exe\"");
		assertTrue(preparedStatement.executeQuery().next());
	}
	
	/**
	 * The function of this test case is to test the connection to default_alerts table of the database.
	 * @throws SQLException
	 */
	@Test
	public void testDatabaseDefaultLimitsTableOperations() throws SQLException {
		preparedStatement = connect.prepareStatement("insert into `default_limits` "
				+ "(`name`,`cpu_limit`,`memory_limit`)"
				   +" values (?,?,?)");
		preparedStatement.setString(1, "unit_test_process.exe");
		preparedStatement.setDouble(2, 70);
		preparedStatement.setDouble(3, 200);
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement("select * "
				+ "from `default_limits` "
				+ "where `name`=\"unit_test_process.exe\"");
		assertTrue(preparedStatement.executeQuery().next());
	}
	
	/**
	 * The function of this test case is to test the connection to default_alerts table of the database.
	 * @throws SQLException
	 */
	@Test
	public void testDatabaseDefaultAlertsTableOperations() throws SQLException {
		Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
		preparedStatement = connect.prepareStatement("insert into `default_alerts` "
				+ "(`type`,`time`,`name`,`value`)"
				   +" values (?,?,?,?)");
		preparedStatement.setString(1, "cpu");
		preparedStatement.setTimestamp(2, timestamp);
		preparedStatement.setString(3, "unit_test_process.exe");
		preparedStatement.setString(4, "70");
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement("select * "
				+ "from `default_alerts` "
				+ "where `name`=\"unit_test_process.exe\"");
		assertTrue(preparedStatement.executeQuery().next());
	}
	
	/**
	 * The function of this test case is to test the connection to process_counter table of the database.
	 * @throws SQLException
	 */
	@Test
	public void testDatabaseProcessCounterTableOperations() throws SQLException {
		preparedStatement = connect.prepareStatement("insert into `process_counter` "
				+ "(`name`,`cpu_value`,`memory_value`,`counter`)"
				   +" values (?,?,?,?)");
		preparedStatement.setString(1, "unit_test_process.exe");
		preparedStatement.setDouble(2, 70);
		preparedStatement.setDouble(3, 200);
		preparedStatement.setInt(4, 1);
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement("select * "
				+ "from `process_counter` "
				+ "where `name`=\"unit_test_process.exe\"");
		assertTrue(preparedStatement.executeQuery().next());
	}
	
	/**
	 * The function of this test case is to test the connection to average_related_alerts table of the database.
	 * @throws SQLException
	 */
	@Test
	public void testDatabaseAverageRelatedAlertsTableOperations() throws SQLException {
		Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
		preparedStatement = connect.prepareStatement("insert into `average_related_alerts` "
				+ "(`type`,`time`,`name`,`value`)"
				   +" values (?,?,?,?)");
		preparedStatement.setString(1, "cpu");
		preparedStatement.setTimestamp(2, timestamp);
		preparedStatement.setString(3, "unit_test_process.exe");
		preparedStatement.setString(4, "70");
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement("select * "
				+ "from `average_related_alerts` "
				+ "where `name`=\"unit_test_process.exe\"");
		assertTrue(preparedStatement.executeQuery().next());
	}
	
	/**
	 * The function of this test case is to test the connection to energy_data table of the database.
	 * @throws SQLException
	 */
	@Test
	public void testDatabaseEnergyDataTableOperations() throws SQLException {
		preparedStatement = connect.prepareStatement("insert into `energy_data` "
				+ "(`name`,`value`)"
				   +" values (?,?)");
		preparedStatement.setString(1, "unit_test_process.exe");
		preparedStatement.setDouble(2, 7);
		preparedStatement.executeUpdate();
		preparedStatement = connect.prepareStatement("select * "
				+ "from `energy_data` "
				+ "where `name`=\"unit_test_process.exe\"");
		assertTrue(preparedStatement.executeQuery().next());
	}
}
