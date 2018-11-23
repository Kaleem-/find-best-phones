public class Phone {

	private final String model;
	private final double screenSize;
	private final int batteryCapacity;

	public Phone(String model, double screenSize, int batteryCapacity) {
		if (screenSize < 0 || batteryCapacity < 0) {
			throw new IllegalArgumentException();
		}


		this.model = model;
		this.screenSize = screenSize;
		this.batteryCapacity = batteryCapacity;
	}

	/*
	 * Gets the phone's model name.
	 */
	public String getModel() {
		return this.model;
	}

	/*
	 * Gets the phone's diagonal screen size (in inches).
	 */
	public double getScreenSize() {
		return this.screenSize;
	}

	/*
	 * Gets the phone's battery capacity (in mAh).
	 */
	public int getBatteryCapacity() {
		return this.batteryCapacity;
	}

	/*
	 * Determines whether this phone "dominates" another phone, meaning this phone
	 * is better in one criterion, and at least as good in the other criterion.
	 */
	public boolean dominates(Phone other) {
		// TODO: implement this method
		return (other.getScreenSize() < this.getScreenSize() && other.getBatteryCapacity()<=this.getBatteryCapacity()
				|| other.batteryCapacity < getBatteryCapacity()) && other.getScreenSize()<=this.getScreenSize();

	}
}
