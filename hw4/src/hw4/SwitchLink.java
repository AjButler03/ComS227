package hw4;

import api.Point;
import api.PositionVector;

/**
 * Models a switchable link with three paths. A boolean turn determines which path trains take. By default turn is set to false. The following figure shows the three paths labeled A, B, and C.
 A     B
 --- ---
     \
      \C
 
The paths A and B run in the same direction and C branches away.
When turn is true a train from A passes to C.
When turn is false a train from A passes to B.
A train from B always passes to A.
A train from C always passes to A.
The turn cannot be modified when the train is in the crossing.
 * @author andre
 *
 */
public class SwitchLink extends StraightLink {
	/**
	 * boolean for if the link is set to turn or not.
	 */
	private boolean turn;
	
	/**
	 * public SwitchLink​(Point endpointA,
Point endpointB,
Point endpointC)
The given endpoints correspond to the paths as labeled below.
 A     B
 --- ---
     \
      \C
	 * @param endpointA
	 * @param endpointB
	 * @param endpointC
	 */
	public SwitchLink(Point endpointA, Point endpointB, Point endpointC) {
		super(endpointA, endpointB, endpointC);
		turn = false;
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

		if (!turn || getEndPointC() != p) {
			// link runs like StraightLink, so calling StraightLink version of shiftPoints
			super.shiftPoints(positionVector);
		} else {
			// moving the endPointC path
			updatePoints(p, positionVector);
		}
	}

	/**
	 * Gets the point that is connected to the given point by the link. Returns null
	 * if no point is connected to the given point.
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		if (!turn || point != getEndPointA()) {
			// turn is false, in which case the link runs like StraightLink
			// or point is not endPointA, in which case it also runs like StraightLink
			return super.getConnectedPoint(point);
		} else if (point == getEndPointA()) {
			// turn is true and working with coming from endPointA, so returning endPointC
			return getEndPointC();
		} else {
			// point not found, returning null
			return null;
		}
	}
	
	/**
	 * Updates the link to turn or not turn. The turn cannot be modified (do nothing) when the train is currently in (entered but not exited) the crossing.
	 * @param turn - true for turn, false for no turn
	 */
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

}
