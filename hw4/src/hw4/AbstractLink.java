package hw4;

import api.Path;
import api.Point;
import api.PositionVector;

/**
 * Models a link between paths. This class implements Crossable which extends
 * Traversable.
 * 
 * 
 * 
 * The class structure that I used is as follows:
 * 
 * AbstractLink has the code for entering/exiting the link, which all classes
 * use. It also has the grunt work code for changing the points in a
 * PositionVector, which all classes also use in shiftPoints(). This is in the
 * form of updatePoints().
 * 
 * CouplingLink and DeadEndLink both just extend AbstractLink - both are fairly
 * simplistic, so not much shared code.
 * 
 * MultiSwitchLink extends MultiFixedLink, which extends AbstractLink. - I
 * figured that this made sense, since they are largely the same, with the main
 * difference being MultiSwitchLink can have it's array of PointPair's be
 * changed. So, MultiSwitchLink is just a MultiFixedLink object with the option
 * to change the array of PointPairs.
 * 
 * TurnLink and SwitchLink both extend StraightLink, which extends AbstractLink.
 * - The main difference between these three is what happens when coming from
 * point A, so I'm using StraightLink as the default and changing the behavior
 * in that case specifically in switchLink and TurnLink. (Depends on if turning
 * in switchLink's case, but still). I would have made turnLink have even less
 * custom code by making TurnLink a SwitchLink object with turn = true and the
 * setTurn() method overridden to do nothing, but speccchecker yelled at me for
 * technically adding a method out of spec. So, they both just extend
 * AbstractLink.
 * 
 * 
 * 
 * @author andre
 *
 */
public abstract class AbstractLink implements api.Crossable {
	/**
	 * stores whether the train has entered this link or not
	 */
	private boolean inCrossing;

	/**
	 * Indicates that the train has entered the link.
	 */
	@Override
	public void trainEnteredCrossing() {
		inCrossing = true;
	}

	/**
	 * indicates that the train has exited the link.
	 */
	@Override
	public void trainExitedCrossing() {
		inCrossing = false;
	}

	/**
	 * updates pointA and pointB within the given PositionVector object with the
	 * next few corresponding points on the given point's path.
	 * 
	 * @param toPoint
	 * @param posVec
	 */
	protected void updatePoints(Point toPoint, PositionVector posVec) {
		Path toPath = toPoint.getPath();
		Point toHigh = toPath.getHighpoint();

		// checking which end of the path is being entered
		if ((toPoint.getX() - toHigh.getX() == 0) && (toPoint.getY() - toHigh.getY() == 0)) {
			// moving points to high numbered part of path
			posVec.setPointA(toPath.getPointByIndex(toPath.getNumPoints() - 1));
			posVec.setPointB(toPath.getPointByIndex(toPath.getNumPoints() - 2));
		} else {
			// moving to points to low numbered part of path
			posVec.setPointA(toPath.getLowpoint());
			posVec.setPointB(toPath.getPointByIndex(1));
		}
	}

	/**
	 * returns boolean for if the train has entered the crossing or not.
	 */
	protected boolean isInCrossing() {
		return inCrossing;
	}
}
