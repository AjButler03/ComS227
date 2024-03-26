package hw4;

import api.Point;

/**
 * Models a fixed link with three paths. The following figure shows the three paths labeled A, B, and C.
 A     B
 --- ---
     \
      \C
 
The paths A and B run in the same direction and C branches away.
A train from A always passes to C.
A train from B always passes to A.
A train from C always passes to A.
 * @author andre
 *
 */
public class TurnLink extends StraightLink {

	/**
	 * Creates a new TurnLink. The given endpoints correspond to the paths as labeled below.
 A     B
 --- ---
     \
      \C
	 * @param endpointA
	 * @param endpointB
	 * @param endpointC
	 */
	public TurnLink(Point endpointA, Point endpointB, Point endpointC) {
		super(endpointA, endpointB, endpointC);
	}
	
	/**
	 * Gets the point that is connected to the given point by the link. Returns null
	 * if no point is connected to the given point.
	 */
	@Override
	public Point getConnectedPoint(Point point) {
		if (point == getEndPointA()) {
			// point is A, in which case PointC is connected point.
			return getEndPointC();
		} else if (point == getEndPointB() || point == getEndPointC()){
			// point is either B or C, in which case the behavior is the same as StraightLink.
			return super.getConnectedPoint(point);
		} else {
			// point not found, returning null
			return null;
		}
	}
}
