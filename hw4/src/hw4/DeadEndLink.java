package hw4;

import api.Point;
import api.PositionVector;

/**
 * Models a link that connects a single path to nothing. getConnectedPoint()
 * returns null and shiftPoints() does nothing.
 * 
 * @author andre
 *
 */
public class DeadEndLink extends AbstractLink {
	/**
	 * Shift the location of the given positionVector to be between the next pair of
	 * points. For example, suppose the vector is currently at the end of path 1 on
	 * points A and B. Assume endpoint B on path 1 is linked to endpoint C on path
	 * 2. Then the positionVector will be updated to be between points C and D,
	 * where D is the next point on path 2 after C. The method does not change the
	 * relative distance between the points, it only modifies the points.
	 */
	@Override
	public void shiftPoints(PositionVector positionVector) {
		// does nothing
	}

	/**
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		// always one connected path
		return 1;
	}

	/**
	 * Gets the point that is connected to the given point by the link. Returns null
	 * if no point is connected to the given point.
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		return null;
	}
}
