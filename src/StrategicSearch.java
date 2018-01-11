/**
 * 
 * @author Ross Nelson
 *
 * A class that a Strategic Search on a grid
 */
public class StrategicSearch implements SearchBehavior{

	// Keeps track of the number of cells that have been searched
		private int cellCount = 0;
		
	// Implements a search that  
	@Override
	public void search(int[][] g) {
		// TODO Auto-generated method stub
		
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
		return 0;
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