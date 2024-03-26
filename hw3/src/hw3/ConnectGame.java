package hw3;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import api.ScoreUpdateListener;
import api.ShowDialogListener;
import api.Tile;

/**
 * Class that models a game.
 */
public class ConnectGame {
	private ShowDialogListener dialogListener;
	private ScoreUpdateListener scoreListener;

	/*
	 * Player's current score
	 */
	private long playerScore;
	/*
	 * width of the game grid
	 */
	private int width;
	/*
	 * height of the game grid
	 */
	private int height;
	/*
	 * minimum tile level
	 */
	private int minTileLev;
	/*
	 * maximum tile level
	 */
	private int maxTileLev;
	/*
	 * Variable to keep track if a selection is in progress
	 */
	private boolean selectInProgress;
	/**
	 * array list to store the tiles that the user has selected.
	 */
	private ArrayList<Tile> selectedTiles;
	/*
	 * variable to store the random number generator
	 */
	private Random randNum;
	/*
	 * variable to store the Grid object used in this instance of the game
	 */
	private Grid gameGrid;

	/**
	 * Constructs a new ConnectGame object with given grid dimensions and minimum
	 * and maximum tile levels.
	 * 
	 * @param width  grid width
	 * @param height grid height
	 * @param min    minimum tile level
	 * @param max    maximum tile level
	 * @param rand   random number generator
	 */
	public ConnectGame(int width, int height, int min, int max, Random rand) {
		gameGrid = new Grid(width, height);
		this.height = height;
		this.width = width;
		randNum = rand;
		minTileLev = min;
		maxTileLev = max;
		selectInProgress = false;
		selectedTiles = new ArrayList<Tile>();
	}

	/**
	 * Gets a random tile with level between minimum tile level inclusive and
	 * maximum tile level exclusive. For example, if minimum is 1 and maximum is 4,
	 * the random tile can be either 1, 2, or 3.
	 * <p>
	 * DO NOT RETURN TILES WITH MAXIMUM LEVEL
	 * 
	 * @return a tile with random level between minimum inclusive and maximum
	 *         exclusive
	 */
	public Tile getRandomTile() {
		// I thought there was a way in the Random class to set both an upper and lower
		// bound, but I can't seem to find any documentation of that. So, this will will
		// get random numbers until they are within the bound instead.
		int lev = 0;
		do {
			lev = randNum.nextInt(maxTileLev);
		} while (lev < minTileLev);

		return new Tile(lev);
	}

	/**
	 * Regenerates the grid with all random tiles produced by getRandomTile().
	 */
	public void radomizeTiles() {
		Tile newTile;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				// generating new time with getRandomTile, updating the tile's x/y location,
				// then populating it to gameGrid
				newTile = getRandomTile();
				gameGrid.setTile(newTile, col, row);
			}
		}

		// System.out.println(gameGrid.toString());
	}

	/**
	 * Determines if two tiles are adjacent to each other. The may be next to each
	 * other horizontally, vertically, or diagonally.
	 * 
	 * @param t1 one of the two tiles
	 * @param t2 one of the two tiles
	 * @return true if they are next to each other horizontally, vertically, or
	 *         diagonally on the grid, false otherwise
	 */
	public boolean isAdjacent(Tile t1, Tile t2) {
		boolean adj = false;

		// For my sanity, putting coordinates in variables
		int tile1x = t1.getX();
		int tile2x = t2.getX();
		int tile1y = t1.getY();
		int tile2y = t2.getY();

		// checking that there is a difference of one or less in x,y between tiles
		if (Math.abs(tile1y - tile2y) <= 1 && Math.abs(tile1x - tile2x) <= 1) {
			adj = true;
		}

		return adj;
	}

	/**
	 * Indicates the user is trying to select (clicked on) a tile to start a new
	 * selection of tiles.
	 * <p>
	 * If a selection of tiles is already in progress, the method should do nothing
	 * and return false.
	 * <p>
	 * If a selection is not already in progress (this is the first tile selected),
	 * then start a new selection of tiles and return true.
	 * 
	 * @param x the column of the tile selected
	 * @param y the row of the tile selected
	 * @return true if this is the first tile selected, otherwise false
	 */
	public boolean tryFirstSelect(int x, int y) {
		boolean select = false;
		if (!selectInProgress) {
			// grabbing selected tile
			Tile tile = gameGrid.getTile(x, y);
			tile.setSelect(true);
			selectInProgress = true;
			select = true;
			// adding selected tile to the list of selected tiles
			selectedTiles.add(tile);
		}

		return select;
	}

	/**
	 * Indicates the user is trying to select (mouse over) a tile to add to the
	 * selected sequence of tiles. The rules of a sequence of tiles are:
	 * 
	 * <pre>
	 * 1. The first two tiles must have the same level.
	 * 2. After the first two, each tile must have the same level or one greater than the level of the previous tile.
	 * </pre>
	 * 
	 * For example, given the sequence: 1, 1, 2, 2, 2, 3. The next selected tile
	 * could be a 3 or a 4. If the use tries to select an invalid tile, the method
	 * should do nothing. If the user selects a valid tile, the tile should be added
	 * to the list of selected tiles.
	 * 
	 * @param x the column of the tile selected
	 * @param y the row of the tile selected
	 */
	public void tryContinueSelect(int x, int y) {
		if (selectInProgress) {
			// making sure the statement below gets correct index to check, since it's
			// length dependent
			selectedTiles.trimToSize();
			Tile selectedTile = gameGrid.getTile(x, y);

			// checking that the tiles are adjacent and that tile is not already selected
			if (!selectedTile.isSelected()) {
				if (isAdjacent(selectedTiles.get(selectedTiles.size() - 1), selectedTile)) {
					// checking if tile levels are equal
					int curr = selectedTile.getLevel();
					int prev1 = selectedTiles.get(selectedTiles.size() - 1).getLevel();

					if (curr == prev1) {
						selectedTiles.add(selectedTile);
						selectedTile.setSelect(true);
						// checking that there are at least two previous selected tiles (to be able to
						// select higher level)
					} else if (selectedTiles.size() >= 2) {

						// checking that the previous two selected tiles have the same level
						int prev2 = selectedTiles.get(selectedTiles.size() - 2).getLevel();
						if (prev1 == prev2 && curr - prev1 == 1) {
							selectedTiles.add(selectedTile);
							selectedTile.setSelect(true);
						}
					}
				}
			} else {
				int i = selectedTiles.indexOf(selectedTile);
				selectedTiles.trimToSize();

				// since specified tile is already selected, and is not the most recently
				// selected, removing any tiles that was selected after it
				if (i != selectedTiles.size() - 1) {
					unselect(selectedTiles.get(i + 1).getX(), selectedTiles.get(i + 1).getY());
				}

			}
		}
	}

	/**
	 * Indicates the user is trying to finish selecting (click on) a sequence of
	 * tiles. If the method is not called for the last selected tile, it should do
	 * nothing and return false. Otherwise it should do the following:
	 * 
	 * <pre>
	 * 1. When the selection contains only 1 tile reset the selection and make sure all tiles selected is set to false.
	 * 2. When the selection contains more than one block:
	 *     a. Upgrade the last selected tiles with upgradeLastSelectedTile().
	 *     b. Drop all other selected tiles with dropSelected().
	 *     c. Reset the selection and make sure all tiles selected is set to false.
	 * </pre>
	 * 
	 * @param x the column of the tile selected
	 * @param y the row of the tile selected
	 * @return return false if the tile was not selected, otherwise return true
	 */
	public boolean tryFinishSelection(int x, int y) {
		boolean success = false;
		selectedTiles.trimToSize();
		// checking that the specified tile is the last one selected.
		// not checking if adjacent b/c that should already be true if it's the last
		// selected. If it's not the last selected, it doesn't matter if it is.
		if (gameGrid.getTile(x, y) == selectedTiles.get(selectedTiles.size() - 1)) {
			if (selectedTiles.size() == 1) {
				unselect(x, y);
				success = true;
				selectInProgress = false;
			} else if (selectedTiles.size() > 1) {
				// updating score
				for (Tile tile : selectedTiles) {
					playerScore += tile.getValue();
				}

				scoreListener.updateScore(playerScore);
				upgradeLastSelectedTile();
				dropSelected();
				success = true;
				selectInProgress = false;
			}
		}
		return success;
	}

	/**
	 * Increases the level of the last selected tile by 1 and removes that tile from
	 * the list of selected tiles. The tile itself should be set to unselected.
	 * <p>
	 * If the upgrade results in a tile that is greater than the current maximum
	 * tile level, both the minimum and maximum tile level are increased by 1. A
	 * message dialog should also be displayed with the message "New block 32,
	 * removing blocks 2". Note that the message shows tile values and not levels.
	 * Display a message is performed with dialogListener.showDialog("Hello,
	 * World!");
	 */
	public void upgradeLastSelectedTile() {
		selectedTiles.trimToSize();
		Tile tile = selectedTiles.get(selectedTiles.size() - 1);
		tile.setLevel(tile.getLevel() + 1);
		if (tile.getLevel() > maxTileLev) {
			dialogListener.showDialog(
					"New Block " + Math.pow(2, maxTileLev) + ", removing blocks " + Math.pow(2, minTileLev) + ".");
			maxTileLev++;
			minTileLev++;
			dropLevel(minTileLev - 1);
		}
		tile.setSelect(false);
		selectedTiles.remove(tile);

	}

	/**
	 * Gets the selected tiles in the form of an array. This does not mean selected
	 * tiles must be stored in this class as an array.
	 * 
	 * @return the selected tiles in the form of an array
	 */
	public Tile[] getSelectedAsArray() {
		// avoiding excess size
		selectedTiles.trimToSize();

		// I stored values in an arraylist instead of an array, so iterating through and
		// populating array
		Tile[] selectedArray = new Tile[selectedTiles.size()];
		for (int i = 0; i < selectedArray.length; i++) {
			selectedArray[i] = selectedTiles.get(i);
		}
		return selectedArray;
	}

	/**
	 * Removes all tiles of a particular level from the grid. When a tile is
	 * removed, the tiles above it drop down one spot and a new random tile is
	 * placed at the top of the grid.
	 * 
	 * @param level the level of tile to remove
	 */
	public void dropLevel(int level) {
		// Selecting all tiles of specified level so that they will be removed
		// with dropSelected.

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				Tile tile = gameGrid.getTile(col, row);
				if (tile.getLevel() == level) {
					tile.setSelect(true);
					selectedTiles.add(tile);
				}
			}
			dropSelected();
		}
	}

	/**
	 * Removes all selected tiles from the grid. When a tile is removed, the tiles
	 * above it drop down one spot and a new random tile is placed at the top of the
	 * grid.
	 */
	public void dropSelected() {
		// Iterating through the columns and rows backwards, starting in the bottom
		// right corner. Calling dropTiles for each selected tile found.
		for (int row = height - 1; row >= 0; row--) {
			for (int col = width - 1; col >= 0; col--) {
				Tile tile = gameGrid.getTile(col, row);
				if (tile.isSelected()) {
					dropTiles(col, row);
					tile.setSelect(false);
					selectedTiles.remove(tile);
				}
			}
		}
	}

	/**
	 * 'drops' tiles down starting at col, row. Iterates upward until it finds a
	 * non-selected tile, and drops that down into position. The empty space is then
	 * filled with randomly generated tiles.
	 * 
	 * @param col
	 */
	private void dropTiles(int col, int row) {
		// finding how many selected tiles are connected vertically
		int num = 1;
		for (int i = row; i > 0; i--) {
			// looking at tile above to see if it is selected
			Tile tile = gameGrid.getTile(col, i - 1);
			if (tile.isSelected()) {
				num++;
				// removing tile from selected tiles
				tile.setSelect(false);
				selectedTiles.remove(tile);
			} else {
				// force exiting loop, as non-selected tile found
				i = 0;
			}
		}

		// Inner loop iterates for the number of items above selected stack, and moves
		// each item down one row. Outer loop does this for the number of selected items
		// found in stack.
		for (int i = 0; i < num; i++) {
			// where the bottom tile should end up
			int end = row - num + i;
			Tile temp = gameGrid.getTile(col, i);
			for (int j = i; j <= end; j++ ) {
				Tile temp2 = gameGrid.getTile(col, j + 1);
				gameGrid.setTile(temp, col, j + 1);
				temp = temp2;
			}
			
			// dropping randomly generated tile at top of column
			gameGrid.setTile(getRandomTile(), col, i);
		}
	}

	/**
	 * Remove the tile from the selected tiles.
	 * 
	 * @param x column of the tile
	 * @param y row of the tile
	 */
	public void unselect(int x, int y) {
		Tile tile = gameGrid.getTile(x, y);
		tile.setSelect(false);
		selectedTiles.remove(tile);

	}

	/**
	 * Gets the player's score.
	 * 
	 * @return the score
	 */
	public long getScore() {
		return playerScore;
	}

	/**
	 * Gets the game grid.
	 * 
	 * @return the grid
	 */
	public Grid getGrid() {
		return gameGrid;
	}

	/**
	 * Gets the minimum tile level.
	 * 
	 * @return the minimum tile level
	 */
	public int getMinTileLevel() {
		return minTileLev;
	}

	/**
	 * Gets the maximum tile level.
	 * 
	 * @return the maximum tile level
	 */
	public int getMaxTileLevel() {
		return maxTileLev;
	}

	/**
	 * Sets the player's score.
	 * 
	 * @param score number of points
	 */
	public void setScore(long score) {
		playerScore = score;
	}

	/**
	 * Sets the game's grid, and updates height and width accordingly.
	 * 
	 * @param grid game's grid
	 */
	public void setGrid(Grid grid) {
		width = grid.getWidth();
		height = grid.getHeight();
		gameGrid = grid;
	}

	/**
	 * Sets the minimum tile level.
	 * 
	 * @param minTileLevel the lowest level tile
	 */
	public void setMinTileLevel(int minTileLevel) {
		minTileLev = minTileLevel;
	}

	/**
	 * Sets the maximum tile level.
	 * 
	 * @param maxTileLevel the highest level tile
	 */
	public void setMaxTileLevel(int maxTileLevel) {
		maxTileLev = maxTileLevel;
	}

	/**
	 * Sets callback listeners for game events.
	 * 
	 * @param dialogListener listener for creating a user dialog
	 * @param scoreListener  listener for updating the player's score
	 */
	public void setListeners(ShowDialogListener dialogListener, ScoreUpdateListener scoreListener) {
		this.dialogListener = dialogListener;
		this.scoreListener = scoreListener;
	}

	/**
	 * Save the game to the given file path.
	 * 
	 * @param filePath location of file to save
	 */
	public void save(String filePath) {
		GameFileUtil.save(filePath, this);
	}

	/**
	 * Load the game from the given file path
	 * 
	 * @param filePath location of file to load
	 * @throws FileNotFoundException
	 */
	public void load(String filePath) {
		GameFileUtil.load(filePath, this);
	}
}
