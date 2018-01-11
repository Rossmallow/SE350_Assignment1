/**
 * 
 * @author Ross Nelson
 *
 * An interface to search using various strategies
 */
public interface SearchBehavior {
	// Executes a search on the grid g passed
	public void search(int[][] g);
	
	// Returns the name of the search
	public String name();
	
	// Returns the number of cells searched before finding both ships
	public int cellsSearched();
}