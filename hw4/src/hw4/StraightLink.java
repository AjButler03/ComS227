package hw4;

import api.Point;
import api.PositionVector;
/**
 * Models a fixed link with three paths. The following figure shows the three paths labeled A, B, and C.
 A     B
 --- ---
     \
      \C
 
The paths A and B run in the same direction and C branches away.
A train from A always passes to B.
A train from B always passes to A.
A train from C always passes to A.
 * @author andre
 *
 */
public class StraightLink extends AbstractLink {
	/**
	 * end point for first path.
	 */
	private Point endPointA;
	/**
	 * end point for second path.
	 */
	private Point endPointB;
	/**
	 * end point for third path.
	 */
	private Point endPointC;

	/**
	 * Creates a new StraightLink. The given endpoints correspond to the paths as labeled below.
 A     B
 --- ---
     \
      \C
	 * @param endpointA
	 * @param endpointB
	 * @param endpointC
	 */
	public StraightLink(Point endpointA, Point endpointB, Point endpointC) {
		this.endPointA = endpointA;
		this.endPointB = endpointB;
		this.endPointC = endpointC;
	}
	
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
		Point p = getConnectedPoint(positionVector.getPointB());
		updatePoints(p, positionVector);
	}

	/**
	 * Gets the point that is connected to the given point by the link. Returns null
	 * if no point is connected to the given point.
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		if (point == endPointA) {
			// on path A, returning pointB
			return endPointB;
		} else if (point == endPointB) {
			// train is on path B, so returning A
			return endPointA;
		} else if (point == endPointC) {
			// train is on path C, returning A
			return endPointA;
		} else {
			// point not found, returning null
			return null;
		}
	}

	/**
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		// always 3 connected Paths
		return 3;
	}

	/**
	 * returns endPointA.
	 * 
	 * @return endPointA
	 */
	protected Point getEndPointA() {
		return endPointA;
	}
	
	/**
	 * returns endPointB.
	 * @return
	 */
	protected Point getEndPointB() {
		return endPointB;
	}

	/**
	 * returns endPointA
	 * 
	 * @return endPointA
	 */
	protected Point getEndPointC() {
		return endPointC;
	}
}
