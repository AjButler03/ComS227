package hw4;

import api.Point;
import api.PointPair;
import api.PositionVector;

/**
 * Models a link with a minimum of 2 to a maximum of 6 paths. The following figure shows 6 paths.
   \   /
    \ /
  --- ---
    / \
   /   \
 
The connections are provided to the constructor as an array of 2 to 6 point pairs. Each point pair indicates the two endpoints where the train comes from and goes to.
The number of point pairs should be the same as the number of paths.
 * @author andre
 *
 */
public class MultiFixedLink extends AbstractLink {
	/**
	 * stores the array of PointPair objects.
	 */
	private PointPair[] connections;

	/**
	 * Creates a new MultiSwitchLink. The given array of point pairs describes the
	 * connection. Each PointPair indicates where the train comes from and goes to.
	 * 
	 * @param connections - the point pairs
	 */
	public MultiFixedLink(PointPair[] connections) {
		this.connections = connections;
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
		// getting the matching point based on pointB in positionVector
		Point fromPoint = positionVector.getPointB();
		Point toPoint = getConnectedPoint(fromPoint);
		// updating points in positionVector to path from connected point
		updatePoints(toPoint, positionVector);
	}

	/**
	 * Gets the point that is connected to the given point by the link. Returns null
	 * if no point is connected to the given point.
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		for (PointPair pp : connections) {
			if (pp.getPointA() == point) {
				// point is pointA in pointPair, so returning connected pointB
				return pp.getPointB();
			} else if (pp.getPointB() == point) {
				// point is pointB in pointPair, so returning connected pointA
				return pp.getPointA();
			}
		}
		// point was not found in any of the point Pairs, so returning null
		return null;
	}

	/**
	 * Gets the total number of paths connected by the link.
	 */
	@Override
	public int getNumPaths() {
		return connections.length;
	}

	/**
	 * gets the array of PointPair Connections
	 * 
	 * @return
	 */
	protected PointPair[] getConnections() {
		return connections;
	}
}
