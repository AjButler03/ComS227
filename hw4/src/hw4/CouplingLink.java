package hw4;

import api.Point;
import api.PositionVector;

/**
 * Models a link between exactly two paths. When the train reaches the endpoint
 * of one of the paths it passes to the endpoint of the other path next.
 * 
 * @author andre
 *
 */
public class CouplingLink extends AbstractLink {
	/**
	 * stores the first end point.
	 */
	private Point endPoint1;
	/**
	 * stores the second end point.
	 */
	private Point endPoint2;

	public CouplingLink(Point endpoint1, Point endpoint2) {
		this.endPoint1 = endpoint1;
		this.endPoint2 = endpoint2;
	}

	/**
	 * /** Shift the location of the given positionVector to be between the next
	 * pair of points. For example, suppose the vector is currently at the end of
	 * path 1 on points A and B. Assume endpoint B on path 1 is linked to endpoint C
	 * on path 2. Then the positionVector will be updated to be between points C and
	 * D, where D is the next point on path 2 after C. The method does not change
	 * the relative distance between the points, it only modifies the points.
	 */
	@Override
	public void shiftPoints(PositionVector positionVector) {
		// checking which path currently on, shifting to other path
		if (positionVector.getPointB() == endPoint1) {
			// currently on endPoint1's path, so shifting to endPoint2's path
			updatePoints(endPoint2, positionVector);
		} else {
			// currently on endPoint2's path, so shifting to endPoint1's path
			updatePoints(endPoint1, positionVector);
		}
	}

	/**
	 * Gets the point that is connected to the given point by the link. Returns null
	 * if no point is connected to the given point.
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		if (point == endPoint1) {
			return endPoint2;
		} else {
			return endPoint1;
		}
	}

	/**
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		// always 2 connected paths.
		return 2;
	}

}
