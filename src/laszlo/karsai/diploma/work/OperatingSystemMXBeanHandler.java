package laszlo.karsai.diploma.work;

/**
 * This class helps the Main class by storing specific system related values.
 * @author Karsai, Laszlo
 *
 */
public class OperatingSystemMXBeanHandler {
	double totalPhysicalMemorySize;
	double freePhysicalMemorySize;
	double usedPhysicalMemorySize;
	double systemCpuLoad;
	
	/**
	 * The function of this constructor is to make the OperatingSystemMXBeanHandler class usable.
	 * @param totalPhysicalMemorySize double
	 * @param freePhysicalMemorySize double
	 * @param systemCpuLoad double
	 */
	public OperatingSystemMXBeanHandler(double totalPhysicalMemorySize, double freePhysicalMemorySize,
			double systemCpuLoad) {
		this.totalPhysicalMemorySize = totalPhysicalMemorySize;
		this.freePhysicalMemorySize = freePhysicalMemorySize;
		this.systemCpuLoad = systemCpuLoad;
	}
	
	/**
	 * Its function is to get the total memory size of the system to be used by the application.
	 * @return double
	 */
	public double getTotalPhysicalMemorySize() {
		return totalPhysicalMemorySize;
	}
	
	/**
	 * Its function is to set the total memory size of the system to be used by the application.
	 * @param totalPhysicalMemorySize double
	 */
	public void setTotalPhysicalMemorySize(double totalPhysicalMemorySize) {
		this.totalPhysicalMemorySize = totalPhysicalMemorySize;
	}
	
	/**
	 * Its function is to get the free memory size of the system to be used by the application.
	 * @return double
	 */
	public double getFreePhysicalMemorySize() {
		return freePhysicalMemorySize;
	}
	
	/**
	 * Its function is to set the free memory size of the system to be used by the application.
	 * @param freePhysicalMemorySize double
	 */
	public void setFreePhysicalMemorySize(double freePhysicalMemorySize) {
		this.freePhysicalMemorySize = freePhysicalMemorySize;
	}
	
	/**
	 * Its function is to get the used memory size of the system to be used by the application.
	 * @return double
	 */
	public double getUsedPhysicalMemorySize() {
		return this.totalPhysicalMemorySize - this.freePhysicalMemorySize;
	}
	
	/**
	 * Its function is to set the used memory size of the system to be used by the application.
	 * @param usedPhysicalMemorySize double
	 */
	public void setUsedPhysicalMemorySize(double usedPhysicalMemorySize) {
		this.usedPhysicalMemorySize = usedPhysicalMemorySize;
	}
	
	/**
	 * Its function is to get the load of the system to be used by the application.
	 * @return double
	 */
	public double getSystemCpuLoad() {
		return systemCpuLoad;
	}
	
	/**
	 * Its function is to set the load of the system to be used by the application.
	 * @param systemCpuLoad double
	 */
	public void setSystemCpuLoad(double systemCpuLoad) {
		this.systemCpuLoad = systemCpuLoad;
	}
	
}
