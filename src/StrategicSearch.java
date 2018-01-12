/**
 * 
 * @author Ross Nelson
 *
 *         A class that a Strategic Search on a grid
 */
public class StrategicSearch implements SearchBehavior {

	// Keeps track of the number of cells that have been searched
	private int cellCount = 0;

	// Implements a search that searches every 3 cells on the x axis, alternating the starting position between the first three cells on each of the rows
	@Override
	public void search(int[][] g) {
		// TODO Auto-generated method stub
		int leftToFind = 8;
		int z = 0;
		for (int x = 0; x < g.length && leftToFind > 0; x++) {
			for (int y = z; y < g[x].length && leftToFind > 0; y += 3) {
				if (g[x][y] == 1) {
					leftToFind -= (checkRight(g, x, y) + checkLeft(g, x, y) + checkDown(g, x, y) + checkUp(g, x, y));
				}
				g[x][y] = 2;
				cellCount++;
			}
			if (z < 2)
				z++;
			else
				z = 0;
		}
	}

	// Gradually decreases the y position as the x position remains unchanged in order to check cells directly above a known location
	private int checkUp(int[][] g, int x, int y) {
		if (y == 0) 
			return 0;
		g[x][y - 1] = 2;
		cellCount++;
		if (g[x][y - 1] == 1) {
			return checkUp(g, x, y - 1) + 1;
		}
		return 0;
	}
	// Gradually increases the x position as the y position remains unchanged in order to check cells directly to the right of a known location
	private int checkRight(int[][] g, int x, int y) {
		if (x == g.length - 1)
			return 0;
		g[x + 1][y] = 2;
		cellCount++;
		if (g[x + 1][y] == 1) {
			return checkRight(g, x + 1, y) + 1;
		}
		return 0;
	}
	// Gradually increases the y position as the x position remains unchanged in order to check cells directly to the left of a known location
	private int checkDown(int[][] g, int x, int y) {
		if (y == g[x].length - 1)
			return 0;
		g[x][y + 1] = 2;
		cellCount++;
		if (g[x][y + 1] == 1) {
			return checkDown(g, x, y + 1) + 1;
		}
		return 0;
	}
	// Gradually decreases the x position as the y position remains unchanged in order to check cells directly below a known location
	private int checkLeft(int[][] g, int x, int y) {
		if (x == 0)
			return 0;
		g[x - 1][y] = 2;
		cellCount++;
		if (g[x - 1][y] == 1) {
			return checkLeft(g, x - 1, y) + 1;
		}
		return 0;
}

	// Returns the name of this search, "Strategic Search"
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Strategic Search";
	}

	// Returns the number of cells Searched before finding both ships
	@Override
	public int cellsSearched() {
		// TODO Auto-generated method stub
		return cellCount;
	}

	@Override
	public void printGrid(int[][] g) {
		// TODO Auto-generated method stub
		// Prints the values stored in grid
		for (int[] n : g) {
			for (int m : n) {
				System.out.print(m);
			}
			System.out.println("");
		}
		System.out.println("");
	}

}