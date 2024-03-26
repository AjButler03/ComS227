package lect020623;

/**
 * Model of a gas tank with fixed capacity.
 */
public class GasTank {
	/**
	 * Current contents of the tank.
	 */
	private double contents;

	/**
	 * Capacity of this tank.
	 */
	private double capacity;

	/**
	 * Constructs a gas tank with the given capacity that is initially empty.
	 * 
	 * @param givenCapacity the fixed capacity for the tank
	 */
	public GasTank(double givenCapacity) {
		contents = 0;
		capacity = givenCapacity;
	}

	/**
	 * Fills the tank to its capacity.
	 */
	public void fill() {
		contents = capacity;
	}

	/**
	 * Returns the current contents of the tank.
	 * 
	 * @return amount of gas in the tank
	 */
	public double getContents() {
		return contents;
	}

	/**
	 * Returns the capacity of this tank.
	 * 
	 * @return capacity of this tank
	 */
	public double getCapacity() {
		return capacity;
	}

	/**
	 * Adds the given amount to the tank, if possible (not exceeding capacity).
	 * 
	 * @param gallons amount to attempt to add
	 */
	public void add(double gallons) {
		double actualAdded = Math.min(gallons, capacity - contents);
		contents = contents + actualAdded;
	}

	/**
	 * Uses the given amount from the tank, if possible (not going below zero).
	 * 
	 * @param gallons amount to attempt to use
	 */
	public void use(double gallons) {
		double actualUsed = Math.min(gallons, contents);
		contents = contents - actualUsed;
	}

	/**
	 * Determines whether the tank is empty.
	 * 
	 * @return true if the tank is empty, false otherwise
	 */
	public boolean isEmpty() {
		return contents <= 0;
	}
}
