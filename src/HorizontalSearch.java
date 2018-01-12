/**
 * 
 * @author Ross Nelson
 *
 * A class that a Horizontal Search on a grid
 */
public class HorizontalSearch implements SearchBehavior {

	// Keeps track of the number of cells that have been searched
		private int cellCount = 0;
		
	// Implements a search that starts at 0,0 and performs a systematic line-by-line sweep through the grid, g, until it has found both ships
	@Override
	public void search(int[][] g) {
		cellCount = 0;
		// TODO Auto-generated method stub
		int leftToFind = 8;
		for (int x = 0; x < g.length && leftToFind > 0; x++) {
			for (int y = 0; y < g[x].length && leftToFind > 0; y++) {
				if (g[x][y] == 1)
					leftToFind--;
				g[x][y] = 2;
				cellCount++;
			}
		}
	}

	// Returns the name of this search, "Horizontal Search"
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Horizontal Search";
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