package hw4;

import api.PointPair;
/**
 * Models a link with a minimum of 2 to a maximum of 6 paths. The following figure shows 6 paths.
   \   /
    \ /
  --- ---
    / \
   /   \
 
The connections are provided to the constructor as an array of 2 to 6 point pairs. Each point pair describes the two endpoints where the train comes from and goes to.
The turn cannot be modified when the train is in the crossing.

The number of point pairs should be the same as the number of paths.
 * @author andre
 *
 */
public class MultiSwitchLink extends MultiFixedLink {

	/**
	 * Creates a new MultiSwitchLink. The given array of point pairs describes the
	 * connection. Each PointPair indicates where the train comes from and goes to.
	 * 
	 * @param connections
	 */
	public MultiSwitchLink(PointPair[] connections) {
		super(connections);
		// setting the inCrossing variable in superclass to false
		trainExitedCrossing();
	}

	/**
	 * Updates the connection point pair at given index. The connection cannot be
	 * modified (method does nothing) when the train is currently (entered but not
	 * exited) the crossing.
	 * 
	 * @param pointPair
	 * @param index
	 */
	public void switchConnection(PointPair pointPair, int index) {
		if (!isInCrossing()) {
			getConnections()[index] = pointPair;
		}
	}

}
