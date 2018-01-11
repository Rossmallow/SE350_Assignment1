/**
 * 
 * @author Ross Nelson
 *
 * A class that a Random Search on a grid
 */
public class RandomSearch implements SearchBehavior{

	// Keeps track of the number of cells that have been searched
	private int cellCount = 0;
	
	// Implements a search that uses a random number generator to randomly check coordinates until it has found both ships 
	@Override
	public void search(int[][] g) {
		// TODO Auto-generated method stub
		int leftToFind = 8;
		while (leftToFind > 0) {
			int x = random(), y = random();
			if (g[x][y] == 1)
				leftToFind--;
			g[x][y] = 2;
			cellCount++;
		}
	}
	
	// Returns the name of this search, "Random Search"
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Random Search";
	}

	// Returns the number of cells Searched before finding both ships
	@Override
	public int cellsSearched() {
		// TODO Auto-generated method stub
		return cellCount;
	}
	
	public int random() {
		return (int) (Math.random() * 25);
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