package hw3;

import java.util.Arrays;
import java.util.Random;

//import api.Tile;
import ui.GameConsole;

public class TestyMcTestFace {
	public static void main(String args[]) {
		// grid tests
		/*
		Grid grid = new Grid(2, 2);
		grid.setTile(new Tile(1), 0, 0);
		grid.setTile(new Tile(2), 1, 0);
		grid.setTile(new Tile(1), 0, 1);
		grid.setTile(new Tile(1), 1, 1);
		System.out.println("Grid tests");
		System.out.println("Width: " + grid.getWidth());
		System.out.println("Height: " + grid.getHeight());
		System.out.println("Tile: " + grid.getTile(0, 1));
		System.out.println(grid);
		System.out.println();
		*/
		// initializing game for testing
		Random rand = new Random();
		ConnectGame game = new ConnectGame(5, 5, 1, 5, rand);
		game.load("TestGame.txt");
		GameConsole gc = new GameConsole();
		game.setListeners(gc, gc);
		
		System.out.println("Initial Grid :");
		System.out.println(game.getGrid());
		System.out.println("\n\n");
		
		// testing tests
		
		game.tryFirstSelect(0, 0);
		game.tryContinueSelect(0, 1);
		game.tryContinueSelect(0, 2);
		game.tryContinueSelect(0, 3);
		game.tryContinueSelect(0, 4);
		game.tryContinueSelect(0, 5);
		game.tryContinueSelect(0, 6);
		game.tryContinueSelect(0, 7);
		
//		game.tryFirstSelect(2, 1);
//		game.tryContinueSelect(1, 1);
//		game.tryContinueSelect(1, 2);
		
		
		System.out.println("Selection: ");
		System.out.println(game.getGrid());
		System.out.println(Arrays.toString(game.getSelectedAsArray()));
		System.out.println("\n\n");
		
		System.out.println("After Finished Selection: ");
		game.tryFinishSelection(0, 7);
		System.out.println(game.getGrid());
		
		System.out.println(Arrays.toString(game.getSelectedAsArray()));
	}
}
