package hw1;

/**
 * models the charge level of a removable and rechargeable camera battery.
 * 
 * @author Andrew Butler
 */
public class CameraBattery {
	/**
	 * Constant for the number of external charger settings
	 */
	public static final int NUM_CHARGER_SETTINGS = 4;
	/**
	 * Constant for the charge rate for plugging in the camera
	 */
	public static final double CHARGE_RATE = 2.0;
	/**
	 * Constant for the default power consumption of the camera
	 */
	public static final double DEFAULT_CAMERA_POWER_CONSUMPTION = 1.0;

	/**
	 * Charge level (mAh) of the battery.
	 */
	private double batteryCharge;

	/**
	 * The current charge level of the battery in the camera (if present).
	 */
	private double cameraCharge;
	/**
	 * The current charge level of the battery in the charger (if present).
	 */
	private double chargerCharge;

	/**
	 * User specified power consumption of the camera.
	 */
	private double cameraPowerConsumption;
	/**
	 * User specified maximum charge level of the battery.
	 */
	private double maxBatteryCapacity;
	/**
	 * Maximum capacity of the battery (if present) in the camera.
	 */
	private double maxCameraCapacity;
	/**
	 * Maximum capacity of the battery (if present) in the charger.
	 */
	private double maxChargerCapacity;
	/**
	 * Current setting on the charger.
	 */
	private int chargerSetting;
	/**
	 * Total amount drained from the battery.
	 */
	private double totalDrain;

	/**
	 * Creates new camera battery simulation. Battery starts disconnected from both
	 * Camera and external charger. Starting battery capacity cannot exceed the
	 * maximum capacity of the battery.
	 * 
	 * @param batteryStartingCharge initial charge of the battery
	 * @param batteryCapacity       maximum capacity of the battery
	 */
	public CameraBattery(double batteryStartingCharge, double batteryCapacity) {
		batteryCharge = Math.min(batteryStartingCharge, batteryCapacity);
		cameraPowerConsumption = DEFAULT_CAMERA_POWER_CONSUMPTION;
		maxBatteryCapacity = batteryCapacity;

		cameraCharge = 0.0;
		totalDrain = 0.0;
		chargerSetting = 0;
		maxCameraCapacity = 0.0;
		maxChargerCapacity = 0.0;
	}

	/**
	 * Changes the setting on the external charger incrementally from 0 (inclusive)
	 * to NUM_CHARGER_SETTINGS (exclusive). Wraps back to 0 when
	 * NUM_CHARGER_SETTINGS is hit.
	 */
	public void buttonPress() {
		chargerSetting = (chargerSetting + 1) % NUM_CHARGER_SETTINGS;
	}

	/**
	 * Charges the battery by plugging the camera in. Total increase in battery
	 * charge (mAh) is CHARGE_RATE * given number of minutes. Note: battery charge
	 * cannot exceed the maximum capacity of the battery. Note: battery will not
	 * charge if the battery is not in the camera.
	 * 
	 * @param minutes given number of minutes the battery is charging.
	 * @return double representing the current charge level of the battery.
	 */
	public double cameraCharge(double minutes) {
		double charge = CHARGE_RATE * minutes;
		// Math.min will prevent the total charge from being more than the battery
		// itself can add to it's charge. It also prevents the battery from charging if
		// the camera is disconnected, because the minimum value will always be zero
		// (the maximum capacity of the camera is zero if there is no battery).
		charge = Math.min(maxCameraCapacity - cameraCharge, charge);
		cameraCharge += charge;
		batteryCharge += charge;
		return charge;
	}

	/**
	 * \ Drains the camera's battery for a given number of minutes.Total battery
	 * drainage (mAh) is power consumption * given number of minutes. Note: total
	 * battery drain cannot exceed the amount of charge left in the battery. Note:
	 * battery cannot drain if the battery is not connected to the camera.
	 * 
	 * @param minutes given number of minutes the battery is draining.
	 * @return double representing the amount drained from the battery.
	 */
	public double drain(double minutes) {
		double drain = cameraPowerConsumption * minutes;
		// Math.min here prevents the drain from being more than the total capacity left
		// in the battery, by making sure the value is less than or equal to the current
		// charge. It also prevents the battery from draining if the camera does not
		// have a battery connected, because the cameraCharge will be zero, and the
		// minimum will thus be a drain of zero.
		drain = Math.min(cameraCharge, drain);
		cameraCharge -= drain;
		batteryCharge -= drain;
		totalDrain += drain;
		return drain;
	}

	/**
	 * Charges the battery through the external charger. The total amount charged
	 * (mAh) is charger setting * given number of minutes * charge rate. Charger
	 * setting is a number from 0 (inclusive) to NUM_CHARGER_SETTINGS (exclusive).
	 * Note: battery charge cannot exceed the total battery capacity. Note: battery
	 * cannot charge if the battery is not connected to the charger.
	 * 
	 * @param minutes given number of minutes the battery is connected to the
	 *                charger.
	 * @return double representing the current charge level of the battery.
	 */
	public double externalCharge(double minutes) {
		double charge = chargerSetting * CHARGE_RATE * minutes;
		// Math.min is preventing the battery from charging the battery ore than it can
		// fit within its remaining capacity, because it will keep the value less than
		// or equal to the available space. It also prevents the battery from charging
		// if it is not connected to the charger, because it will return 0 in that case
		// Side note: chargerCharge exists to differentiate the main batteryCharge
		// variable in the case that the battery is not connected to the charger, and
		// thus won't end up being set to some negative number.
		charge = Math.min(maxChargerCapacity - chargerCharge, charge);
		chargerCharge += charge;
		batteryCharge += charge;
		return charge;
	}

	/**
	 * Resets the counter for the total amount of charge drained from the battery
	 * back to 0.
	 */
	public void resetBatteryMonitor() {
		totalDrain = 0.0;
	}

	/**
	 * Gets the maximum battery capacity.
	 * 
	 * @return double representing the maximum charge level (mAh) of the battery.
	 */
	public double getBatteryCapacity() {
		return maxBatteryCapacity;
	}

	/**
	 * Gets the current charge level (mAh) of the battery.
	 * 
	 * @return double representing the current charge level (mAh) of the battery.
	 */
	public double getBatteryCharge() {
		return batteryCharge;
	}

	/**
	 * Gets the current charge of the battery in the camera. If there is no battery,
	 * the charge is 0.
	 * 
	 * @return double representing the current battery charge level (mAh).
	 */
	public double getCameraCharge() {
		return cameraCharge;
	}

	/**
	 * Gets the power consumption of the camera.
	 * 
	 * @return double representing the power consumption (mAh) per minute of the
	 *         camera.
	 */
	public double getCameraPowerConsumption() {
		return cameraPowerConsumption;
	}

	/**
	 * Gets the current setting of the external charger.
	 * 
	 * @return integer representing the current charger setting from 0 (inclusive)
	 *         to NUM_CHARGER_SETTINGS (exclusive).
	 */
	public int getChargerSetting() {
		return chargerSetting;
	}

	/**
	 * Gets the total amount drained from the battery.
	 * 
	 * @return double representing the total number of mAh drained from the battery.
	 */
	public double getTotalDrain() {
		return totalDrain;
	}

	/**
	 * Moves the battery to the external charger.
	 */
	public void moveBatteryExternal() {
		maxChargerCapacity = maxBatteryCapacity;
		chargerCharge = batteryCharge;
		cameraCharge = 0.0;
		maxCameraCapacity = 0.0;
	}

	/**
	 * Moves the battery to inside the camera.
	 */
	public void moveBatteryCamera() {
		maxCameraCapacity = maxBatteryCapacity;
		cameraCharge = batteryCharge;
		maxChargerCapacity = 0.0;
		chargerCharge = 0.0;
	}

	/**
	 * Removes the battery from its current location (either inside the camera or
	 * connected to the external charger).
	 */
	public void removeBattery() {
		maxCameraCapacity = 0.0;
		cameraCharge = 0.0;
		maxChargerCapacity = 0.0;
		chargerCharge = 0.0;
	}

	/**
	 * Sets the cameras power consumption (mAh) per minute.
	 * 
	 * @param cameraPowerConsumption double representing power consumption of the
	 *                               camera per minute.
	 */
	public void setCameraPowerConsumption(double cameraPowerConsumption) {
		this.cameraPowerConsumption = cameraPowerConsumption;
	}
}
