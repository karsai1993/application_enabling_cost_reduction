package laszlo.karsai.diploma.work;

/**
 * This class helps the Main class by storing specific process related values.
 * @author Karsai, Laszlo
 *
 */
public class ProcessData {
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
	 * The function of this constructor is to make the ProcessData class usable.
	 * @param processId int
	 * @param name String
	 * @param memUsage double
	 * @param cpuUsage double
	 */
	public ProcessData (int processId, String name, double memUsage, double cpuUsage) {
		this.processId = processId;
		this.name = name;
		this.memUsage = memUsage;
		this.cpuUsage = cpuUsage;
	}
	
	/**
	 * The function of this constructor is to make the ProcessData class usable.
	 * @param name String
	 * @param memUsage double
	 * @param cpuUsage double
	 * @param windowTitle String
	 * @param processId int
	 * @param cpuTimeInSec double
	 * @param status String
	 * @param userName String
	 */
	public ProcessData(String name, double memUsage, double cpuUsage,
			String windowTitle, int processId,
			double cpuTimeInSec, String status, String userName) {
		this.name = name;
		this.memUsage = memUsage;
		this.cpuUsage = cpuUsage;
		this.windowTitle = windowTitle;
		this.processId = processId;
		this.cpuTimeInSec = cpuTimeInSec;
		this.status = status;
		this.userName = userName;
	}
	
	/**
	 * The function of this constructor is to make the ProcessData class usable.
	 * @param name String
	 * @param index int
	 * @param memUsage double
	 * @param cpuUsage double
	 * @param windowTitle String
	 * @param processId int
	 */
	public ProcessData(String name, int index, double memUsage, double cpuUsage,
			String windowTitle, int processId) {
		this.name = name;
		this.index = index;
		this.memUsage = memUsage;
		this.cpuUsage = cpuUsage;
		this.windowTitle = windowTitle;
		this.processId = processId;
	}

	/**
	 * Its function is to get the status of a process.
	 * @return String
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Its function is to set the status of a process.
	 * @param status String
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Its function is to get the owner of a process.
	 * @return String
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Its function is to set the owner of a process.
	 * @param userName String
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Its function is to get the cpu time of a process.
	 * @return double
	 */
	public double getCpuTimeInSec() {
		return cpuTimeInSec;
	}

	/**
	 * Its function is to set the cpu time of a process.
	 * @param cpuTimeInSec double
	 */
	public void setCpuTimeInSec(double cpuTimeInSec) {
		this.cpuTimeInSec = cpuTimeInSec;
	}

	/**
	 * Its function is to get the id of a process.
	 * @return int
	 */
	public int getProcessId() {
		return processId;
	}

	/**
	 * Its function is to set the id of a process.
	 * @param processId int
	 */
	public void setProcessId(int processId) {
		this.processId = processId;
	}

	/**
	 * Its function is to get the index of a process.
	 * @return int
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Its function is to set the index of a process.
	 * @param index int
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Its function is to get the window title of a process.
	 * @return String
	 */
	public String getWindowTitle() {
		return windowTitle;
	}
	
	/**
	 * Its function is to set the window title of a process.
	 * @param windowTitle String
	 */
	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
	}

	/**
	 * Its function is to get the name of a process.
	 * @return String
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Its function is to set the name of a process.
	 * @param name String
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Its function is to get the used memory size of a process.
	 * @return double
	 */
	public double getMemUsage() {
		return memUsage;
	}
	
	/**
	 * Its function is to set the used memory size of a process.
	 * @param memUsage double
	 */
	public void setMemUsage(double memUsage) {
		this.memUsage = memUsage;
	}
	
	/**
	 * Its function is to get the cpu usage of a process.
	 * @return double
	 */
	public double getCpuUsage() {
		return cpuUsage;
	}
	
	/**
	 * Its function is to set the cpu usage of a process.
	 * @param cpuUsage double
	 */
	public void setCpuUsage(double cpuUsage) {
		this.cpuUsage = cpuUsage;
	}
}
