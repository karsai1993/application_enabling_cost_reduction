package laszlo.karsai.diploma.work;

/**
 * This class helps the Main class by storing specific process related values.
 * @author Karsai, Laszlo
 *
 */
public class CpuCalculationHelper {
	int processId;
	double elapsedTime;
	
	/**
	 * The function of this constructor is to make the CpuCalculationHelper class usable.
	 * @param processId int
	 * @param elapsedTime double
	 */
	public CpuCalculationHelper (int processId, double elapsedTime) {
		this.processId = processId;
		this.elapsedTime = elapsedTime;
	}
	
	/**
	 * Its function is to get the process id of a process.
	 * @return int
	 */
	public int getProcessId() {
		return processId;
	}
	
	/**
	 * Its function is to set the process id of a process.
	 * @param processId int
	 */
	public void setProcessId(int processId) {
		this.processId = processId;
	}
	
	/**
	 * Its function is to get the elapsed time of a process.
	 * @return double
	 */
	public double getElapsedTime() {
		return elapsedTime;
	}
	
	/**
	 * Its function is to set the elapsed time of a process.
	 * @param elapsedTime double
	 */
	public void setElapsedTime(double elapsedTime) {
		this.elapsedTime = elapsedTime;
	}	
}
