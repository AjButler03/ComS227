package hw3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import api.Tile;

/**
 * Utility class with static methods for saving and loading game files.
 */
public class GameFileUtil {
	/**
	 * Saves the current game state to a file at the given file path.
	 * <p>
	 * The format of the file is one line of game data followed by multiple lines of
	 * game grid. The first line contains the: width, height, minimum tile level,
	 * maximum tile level, and score. The grid is represented by tile levels. The
	 * conversion to tile values is 2^level, for example, 1 is 2, 2 is 4, 3 is 8, 4
	 * is 16, etc. The following is an example:
	 * 
	 * <pre>
	 * 5 8 1 4 100
	 * 1 1 2 3 1
	 * 2 3 3 1 3
	 * 3 3 1 2 2
	 * 3 1 1 3 1
	 * 2 1 3 1 2
	 * 2 1 1 3 1
	 * 4 1 3 1 1
	 * 1 3 3 3 3
	 * </pre>
	 * 
	 * @param filePath the path of the file to save
	 * @param game     the game to save
	 */
	public static void save(String filePath, ConnectGame game) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
			// TODO: write to file, can use writer.write()
			Grid gameGrid = game.getGrid();
			System.out.println(gameGrid.toString());
			int width = gameGrid.getWidth();
			int height = gameGrid.getHeight();

			// writing initial line
			writer.write(width + " " + height + " " + game.getMinTileLevel() + " " + game.getMaxTileLevel() + " "
					+ game.getScore() + "\n");
			
			// iterating through grid, writing level of tiles
			for (int row = 0; row < height; row++) {
				for (int col = 0; col < width; col++) {
					writer.write(gameGrid.getTile(col, row).getLevel() + "");
					if (col != width - 1) {
						writer.write(" ");
					}
				}
				if (row != height - 1) {
					writer.write("\n");
				}
			}
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the file at the given file path into the given game object. When the
	 * method returns the game object has been modified to represent the loaded
	 * game.
	 * <p>
	 * See the save() method for the specification of the file format.
	 * 
	 * @param filePath the path of the file to load
	 * @param game     the game to modify
	 * @throws FileNotFoundException
	 */
	public static void load(String filePath, ConnectGame game) {
		try {
			File file = new File(filePath);
			Scanner scnr = new Scanner(file);

			// grabbing game info on first line
			String line1 = scnr.nextLine();
			Scanner scnr2 = new Scanner(line1);
			int width = scnr2.nextInt();
			int height = scnr2.nextInt();
			int minLev = scnr2.nextInt();
			int maxLev = scnr2.nextInt();
			int score = scnr2.nextInt();
			scnr2.close();

			int row = 0;
			int col = 0;

			Grid loadGrid = new Grid(width, height);
			while (scnr.hasNextLine()) {
				col = 0;
				String line = scnr.nextLine();
				scnr2 = new Scanner(line);
				while (scnr2.hasNextInt()) {
					Tile loadTile = new Tile(scnr2.nextInt());
					loadGrid.setTile(loadTile, col, row);
					col++;
				}
				scnr2.close();
				row++;
			}
			scnr.close();

			// updating game
			game.setGrid(loadGrid);
			game.setScore(score);
			game.setMinTileLevel(minLev);
			game.setMaxTileLevel(maxLev);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
