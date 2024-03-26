package hw2;

import api.PlayerPosition;
import api.BallType;
import static api.PlayerPosition.*;
import static api.BallType.*;

/**
 * Class that models the game of three-cushion billiards.
 * 
 * @author Andrew Butler
 */
public class ThreeCushion {
	/**
	 * Defining a variable for PLAYER_A for pointer comparison.
	 */
	private PlayerPosition playerA = PLAYER_A;
	/**
	 * Defining a variable for PLAYER_B for pointer comparison.
	 */
	private PlayerPosition playerB = PLAYER_B;
	/**
	 * Player who won the lagging; either PLAYER_A or PLAYER_B.
	 */
	private PlayerPosition lagWinner;
	/**
	 * Holds the cue ball that playerA is using; either WHITE or YELLOW.
	 */
	private BallType playerACueBall;
	/**
	 * Holds the cue ball that playerB is using; either WHITE or YELLOW.
	 */
	private BallType playerBCueBall;
	/**
	 * Holds the amount of points that are required to win the game.
	 */
	private int pointsToWin;
	/**
	 * Holds who's turn it is; either PLAYER_A or PLAYER_B.
	 */
	private PlayerPosition currentPlayer;
	/**
	 * Holds the current inning number.
	 */
	private int currentInning;
	/**
	 * Holds whichever cue ball is currently being used, depending on who's turn it
	 * is. Either WHITE or YELLOW.
	 */
	private BallType currentCueBall;
	/**
	 * Declares if the lag winner has made their decision of cue ball and to break.
	 */
	private boolean lagWinnerChose;
	/**
	 * Declares whether or not current shot is the break shot.
	 */
	private boolean isBreak;
	/**
	 * Variable to keep track of if a shot has potential to become a bank shot, if
	 * the shot scores.
	 */
	private boolean tempIsBank;
	/**
	 * Declares whether the most recently completed shot was a bank shot or not.
	 */
	private boolean isBank;
	/**
	 * determines if the current shot is viable for scoring or not.
	 */
	private boolean goodShot;
	/**
	 * Keeps track of the number of times the cue ball impacts the table cushions in
	 * the current shot.
	 */
	private int numCushionImpacts;
	/**
	 * Stores the the ball that is hit to end a shot. Can be WHITE, YELLOW, or RED.
	 */
	private BallType lastBallToHit;
	/**
	 * Keeps track of the number of points scored by PLAYER_A.
	 */
	private int playerAScore;
	/**
	 * Keeps track of the number of points scored by PLAYER_B.
	 */
	private int playerBScore;
	/**
	 * Declares if there is a shot in progress or not.
	 */
	private boolean shotInProgress;
	/**
	 * Declares if there is an inning in progress or not.
	 */
	private boolean inningInProgress;
	/**
	 * Declares if the game is finished or not.
	 */
	private boolean gameOver;

	/**
	 * Creates a new game of three-cushion billiards with a given lag winner and the
	 * predetermined number of points required to win the game. The inning count
	 * starts at 1.
	 * 
	 * @param lagWinner   either player A or B
	 * @param pointsToWin the number of points a player needs to reach for the game
	 *                    to end
	 */
	public ThreeCushion(PlayerPosition lagWinner, int pointsToWin) {
		this.lagWinner = lagWinner;
		this.pointsToWin = pointsToWin;
		playerAScore = 0;
		playerBScore = 0;
		currentInning = 1;
		gameOver = false;
		shotInProgress = false;
		lagWinnerChose = false;
	}

	/**
	 * Sets whether the player that won the lag chooses to break (take first shot),
	 * or chooses the other player to break. If this method is called more than once
	 * it should have no effect. In other words, the lag winner can only choose
	 * these options once and may not change their mind afterwards.
	 * 
	 * @param selfBreak if true the lag winner chooses to take the break shot
	 * @param cueball   the lag winners chosen cue ball (either WHITE or YELLOW)
	 */
	public void lagWinnerChooses(boolean selfBreak, BallType cueball) {
		if (!lagWinnerChose) {
			isBreak = selfBreak;
			// checking who won the Lagging, so that their cue ball gets set first
			if (lagWinner == playerA) {
				playerACueBall = cueball;
				// setting player B's ball to the option that player A didn't choose
				if (cueball == WHITE) {
					playerBCueBall = YELLOW;
				} else {
					playerBCueBall = WHITE;
				}
			} else {
				playerBCueBall = cueball;
				// setting player A's ball to the option that player B didn't choose
				if (cueball == WHITE) {
					playerACueBall = YELLOW;
				} else {
					playerACueBall = WHITE;
				}
			}

			// determining current player and the current cue ball, based on who the lag
			// winner was and if they chose to break first or not
			if (lagWinner == playerA) {
				if (isBreak) {
					currentPlayer = playerA;
					currentCueBall = playerACueBall;
				} else {
					currentPlayer = playerB;
					currentCueBall = playerBCueBall;
				}
			} else {
				if (isBreak) {
					currentPlayer = playerB;
					currentCueBall = playerBCueBall;
				} else {
					currentPlayer = playerA;
					currentCueBall = playerACueBall;
				}
			}
			lagWinnerChose = true;
		}
	}

	/**
	 * Indicates the cue stick has struck the given ball. If a shot has not already
	 * begun, indicates the start of a new shot. If this method is called while a
	 * shot is still in progress (i.e., endShot() has not been called for the
	 * previous shot), the player has committed a foul (see the method foul()).
	 * Also, if the player strikes anything other than their own cue ball, they
	 * committed a foul. Calling this method signifies both the start of a shot and
	 * the start of an inning, assuming a shot or inning has not already begun,
	 * respectively.
	 * 
	 * Even if a foul has been committed, calling this method is considered the
	 * start of a shot. That includes even the case when the player strikes a ball
	 * other than their own cue ball. It is expected that the endShot() method will
	 * be called in any case to indicate the end of the shot.
	 * 
	 * No play can begin until the lag player has chosen who will break (see
	 * lagWinnderChooses). If this method is called before the break is chosen, it
	 * should do nothing.
	 * 
	 * If this method is called after the game has ended, it should do nothing.
	 * 
	 * @param ball given ball that the cue stick has struck
	 */
	public void cueStickStrike(BallType ball) {
		if (!gameOver) {
			if (shotInProgress) {
				foul();
			} else {
				shotInProgress = true;
				inningInProgress = true;
				tempIsBank = false;
				numCushionImpacts = 0;
				if (currentPlayer == playerA) {
					if (ball != playerACueBall) {
						foul();
					}
				} else {
					if (ball != playerBCueBall) {
						foul();
					}
				}
			}
		}
	}

	/**
	 * Indicates the player's cue ball has struck the given ball. A ball strike
	 * cannot happen before a stick strike. If this method is called before the
	 * start of a shot (i.e., cueStickStrike() is called), it should do nothing.
	 * 
	 * If this method is called after the game has ended, it should do nothing.
	 * 
	 * @param ball given ball that the player's cue ball has struck
	 */
	public void cueBallStrike(BallType ball) {
		if (!gameOver && shotInProgress && inningInProgress) {
			// checking if this is the second ball hit in this shot
			// determines if shot is valid for scoring
			if (ball == lastBallToHit) {
				if (numCushionImpacts >= 3) {
					goodShot = true;
				} else {
					goodShot = false;
				}
				// conditions for first ball impact
			} else {
				// if the current shot is the breaking shot, and the ball hit is not red, it
				// will be a foul. Otherwise checks what the last ball to hit is.
				if ((isBreak && (ball != RED)) || (isBreak && (numCushionImpacts > 0))) {
					foul();
				} else {
					// Checking if three cushion impacts have already happened; labeling as bank
					// shot
					// if true
					if (numCushionImpacts >= 3) {
						tempIsBank = true;
					}
					if ((ball == RED) && (currentCueBall == WHITE)) {
						lastBallToHit = YELLOW;
					} else if ((ball == RED) && (currentCueBall == YELLOW)) {
						lastBallToHit = WHITE;
					} else {
						lastBallToHit = RED;
					}
				}
			}
		}
	}

	/**
	 * Indicates the given ball has impacted the given cushion. A cushion impact
	 * cannot happen before a stick strike. If this method is called before the
	 * start of a shot (i.e., cueStickStrike() is called), it should do nothing.
	 * 
	 * If this method is called after the game has ended, it should do nothing.
	 */
	public void cueBallImpactCushion() {
		if (!gameOver && shotInProgress) {
			numCushionImpacts += 1;
		}
	}

	/**
	 * Indicates that all balls have stopped motion. If the shot was valid and no
	 * foul was committed, the player scores 1 point. The shot cannot end before it
	 * has started with a call to cueStickStrike. If this method is called before
	 * cueStickStrike, it should be ignored.
	 * 
	 * A shot cannot end before the start of a shot. If this method is called before
	 * the start of a shot (i.e., cueStickStrike() is called), it should do nothing.
	 * 
	 * If this method is called after the game has ended, it should do nothing.
	 */
	public void endShot() {
		if (!gameOver && shotInProgress) {
			if (goodShot) {
				// declaring if shot is a bank shot or not
				if (tempIsBank) {
					isBank = true;
				} else {
					isBank = false;
				}
				// incrementing score for current player
				if (currentPlayer == playerA) {
					playerAScore += 1;
					if (playerAScore >= pointsToWin) {
						gameOver = true;
						inningInProgress = false;
					}
				} else {
					playerBScore += 1;
					if (playerBScore >= pointsToWin) {
						gameOver = true;
						inningInProgress = false;
					}
				}
			} else {
				// shot was not viable for scoring, so switching players.
				// Only applies if inning still in progress, and thus a foul has not been
				// called.
				if (inningInProgress) {
					inningInProgress = false;
					currentInning += 1;
					switchPlayers();
				}
			}
			// resetting variables for next shot
			shotInProgress = false;
			numCushionImpacts = 0;
			lastBallToHit = null;
			isBreak = false;
			tempIsBank = false;
			goodShot = false;
		}
	}

	/**
	 * A foul immediately ends the player's inning, even if the current shot has not
	 * yet ended. When a foul is called, the player does not score a point for the
	 * shot. A foul may also be called before the inning has started. In that case
	 * the player whose turn it was to shot has their inning forfeited and the
	 * inning count is increased by one.
	 * 
	 * No foul can be called until the lag player has chosen who will break (see
	 * lagWinnerChooses()). If this method is called before the break is chosen, it
	 * should do nothing.
	 * 
	 * If this method is called after the game has ended, it should do nothing.
	 */
	public void foul() {
		if (!gameOver && lagWinnerChose) {
			goodShot = false;
			inningInProgress = false;
			currentInning += 1;
			switchPlayers();
		}
	}

	/**
	 * switches the current player and the current cue ball.
	 */
	private void switchPlayers() {
		if (currentPlayer == playerA) {
			currentPlayer = playerB;
			currentCueBall = playerBCueBall;
		} else {
			currentPlayer = playerA;
			currentCueBall = playerACueBall;
		}
	}

	/**
	 * Gets the number of points scored by Player A.
	 * 
	 * @return the number of points scored by Player A
	 */
	public int getPlayerAScore() {
		return playerAScore;
	}

	/**
	 * Gets the number of points scored by Player B.
	 * 
	 * @return the number of points scored by Player B
	 */
	public int getPlayerBScore() {
		return playerBScore;
	}

	/**
	 * Gets the inning number. The inning count starts at 1.
	 * 
	 * @return the current inning number
	 */
	public int getInning() {
		return currentInning;
	}

	/**
	 * Gets the cue ball of the current player. If this method is called in between
	 * innings, the cue ball should be the for the player of the upcoming inning. If
	 * this method is called before the lag winner has chosen a cue ball, the cue
	 * ball is undefined (this method may return anything).
	 * 
	 * @return the player's cue ball
	 */
	public BallType getCueBall() {
		return currentCueBall;
	}

	/**
	 * Gets the current player. If this method is called in between innings, the
	 * current player is the player of the upcoming inning. If this method is called
	 * before the lag winner has chosen to break, the current player is undefined
	 * (this method may return anything).
	 * 
	 * @return the current player
	 */
	public PlayerPosition getInningPlayer() {
		return currentPlayer;
	}

	/**
	 * Returns true if and only if this is the break shot (i.e., the first shot of
	 * the game).
	 * 
	 * @return true if this is the break shot, false otherwise
	 */
	public boolean isBreakShot() {
		return isBreak;
	}

	/**
	 * Returns true if and only if the most recently completed shot was a bank shot.
	 * A bank shot is when the cue ball impacts the cushions at least 3 times and
	 * then strikes both object balls.
	 * 
	 * @return true if shot was a bank shot, false otherwise
	 */
	public boolean isBankShot() {
		return isBank;
	}

	/**
	 * Returns true if a shot has been taken (see cueStickStrike()), but not ended
	 * (see endShot()).
	 * 
	 * @return true if the shot has been started, false otherwise
	 */
	public boolean isShotStarted() {
		return shotInProgress;
	}

	/**
	 * Returns true if the shooting player has taken their first shot of the inning.
	 * The inning starts at the beginning of the shot (i.e., the shot may not have
	 * ended yet).
	 * 
	 * @return true if the inning has started, false otherwise
	 */
	public boolean isInningStarted() {
		return inningInProgress;
	}

	/**
	 * Returns true if the game is over (i.e., one of the players has reached the
	 * designated number of points to win).
	 * 
	 * @return true if the game is over, false otherwise
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	// The method below is provided for you and you should not modify it.
	// The compile errors will go away after you have written stubs for the
	// rest of the API methods.
	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * <p>
	 * <tt>Player A*: X Player B: Y, Inning: Z</tt>
	 * <p>
	 * The asterisks next to the player's name indicates which player is at the
	 * table this inning. The number after the player's name is their score. Z is
	 * the inning number. Other messages will appear at the end of the string.
	 * 
	 * @return one-line string representation of the game state
	 */
	public String toString() {
		String fmt = "Player A%s: %d, Player B%s: %d, Inning: %d %s%s";
		String playerATurn = "";
		String playerBTurn = "";
		String inningStatus = "";
		String gameStatus = "";
		if (getInningPlayer() == PLAYER_A) {
			playerATurn = "*";
		} else if (getInningPlayer() == PLAYER_B) {
			playerBTurn = "*";
		}
		if (isInningStarted()) {
			inningStatus = "started";
		} else {
			inningStatus = "not started";
		}
		if (isGameOver()) {
			gameStatus = ", game result final";
		}
		return String.format(fmt, playerATurn, getPlayerAScore(), playerBTurn, getPlayerBScore(), getInning(),
				inningStatus, gameStatus);
	}
}
