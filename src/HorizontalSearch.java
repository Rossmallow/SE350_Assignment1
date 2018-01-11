/**
 * 
 * @author Ross Nelson
 *
 * A class that a Horizontal Search on a grid
 */
public class HorizontalSearch implements SearchBehavior {

	// Implements a search that starts at 0,0 and performs a systematic line-by-line sweep through the grid, g, until it has found both ships
	@Override
	public void search(int[][] g) {
		// TODO Auto-generated method stub
		
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
		return 0;
	}

}