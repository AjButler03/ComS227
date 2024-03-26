package hw2;

import static api.BallType.RED;
import static api.BallType.WHITE;
import static api.BallType.YELLOW;
import static api.PlayerPosition.PLAYER_B;

public class CustomTests {
	public static void main(String args[]) {
		// test 29 failure
		System.out.println("Test 29");
		ThreeCushion game1 = new ThreeCushion(PLAYER_B, 3);
		game1.lagWinnerChooses(true, YELLOW);
		game1.cueStickStrike(YELLOW);
		game1.cueBallStrike(WHITE);
		System.out.println(game1.getCueBall());
		
		// test 30 failure
		System.out.println("");
		System.out.println("Test 30");
		ThreeCushion game2 = new ThreeCushion(PLAYER_B, 3);
		game2.lagWinnerChooses(true, WHITE);
		game2.cueStickStrike(WHITE);
		game2.cueBallImpactCushion();
		game2.cueBallStrike(RED);
		System.out.println(game2.getCueBall());
	}
}