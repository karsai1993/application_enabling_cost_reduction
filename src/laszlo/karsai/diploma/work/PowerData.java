package laszlo.karsai.diploma.work;

/**
 * This class helps the Main class by storing specific power related value.
 * @author Karsai, Laszlo
 *
 */
public class PowerData {
	double powerInWatt;
	
	/**
	 * The function of this constructor is to make the PowerData class usable.
	 * @param powerInWatt double
	 */
	public PowerData(double powerInWatt) {
		this.powerInWatt = powerInWatt;
	}
	
	/**
	 * Its function is to get the power value.
	 * @return double
	 */
	public double getPowerInWatt() {
		return powerInWatt;
	}
	
	/**
	 * Its function is to set the power value.
	 * @param powerInWatt double
	 */
	public void setPowerInWatt(double powerInWatt) {
		this.powerInWatt = powerInWatt;
	}	
}
