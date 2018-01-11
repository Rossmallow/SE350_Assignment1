/**
 * 
 * @author Ross Nelson
 *
 *         A class that a Strategic Search on a grid
 */
public class StrategicSearch implements SearchBehavior {

	// Keeps track of the number of cells that have been searched
	private int cellCount = 0;
	private int leftToFind = 8;

	// Implements a search that
	@Override
	public void search(int[][] g) {
		// TODO Auto-generated method stub
		while (leftToFind > 0) {
			int n = 0, m = 0;
			for (int x = n; x < g.length; x += 3) {
				for (int y = m; y < g[x].length; y += 3) {
					if (g[x][y] == 1) {
						leftToFind--;
						checkUp(g, x, y);
						checkRight(g, x, y);
						checkDown(g, x, y);
						checkLeft(g, x, y);
					}
					g[x][y] = 2;
					cellCount++;
				}
			}
			n++;
			m++;
		}
	}

	private void checkUp(int[][] g, int x, int y) {
		if (y == 0) {
		} else if (g[x][y - 1] == 1) {
			leftToFind--;
			g[x][y - 1] = 2;
			checkUp(g, x, y - 1);
		}
	}

	private void checkRight(int[][] g, int x, int y) {
		if (x == g.length - 1) {
		} else if (g[x + 1][y] == 1) {
			leftToFind--;
			g[x + 1][y] = 2;
			checkRight(g, x + 1, y);
		}
	}

	private void checkDown(int[][] g, int x, int y) {
		if (y == g[x].length - 1) {
		} else if (g[x][y + 1] == 1) {
			leftToFind--;
			g[x][y + 1] = 2;
			checkDown(g, x, y + 1);
		}
	}

	private void checkLeft(int[][] g, int x, int y) {
		if (x == 0) {
		} else if (g[x - 1][y] == 1) {
			leftToFind--;
			g[x - 1][y] = 2;
			checkLeft(g, x - 1, y);
		}
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