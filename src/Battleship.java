/**
 * Ross Nelson
 * Mona Rahimi
 * CSC 350 501
 * January 17, 2018
 * 
 * Assignment 1
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.StringTokenizer;

/**
 * 
 * @author Ross Nelson
 *
 * A class that performs various searches on multiple grid layouts
 */
public class Battleship {
	
	SearchBehavior searchBehavior;
	private int[] input = new int[48]; 			// There are 48 integers that make up the 24 coordinates necessary to set up 3 games
	private int[][] grid = new int[25][25];		// The grid must be 25x25

	// Sets default search strategy
	public Battleship() {
		searchBehavior = new HorizontalSearch();
	}
	
	public static void main (String[] args) {
		Battleship battleship = new Battleship();
		
		int[] games = {1, 2, 3};
		SearchBehavior[] searches = {new HorizontalSearch(), new RandomSearch(), new StrategicSearch()};
		
		battleship.readInputFile();
		for (int game : games) {
			System.out.println("===");
			for (SearchBehavior search : searches) {
				battleship.setGame(game);
				battleship.setSearch(search);
				battleship.testSearch();
			}
		}
	}

	// Sets searchBehavior to the specified search
	public void setSearch (SearchBehavior search) {
		searchBehavior = search;
	}
	
	// Sets the game setup to the specified game
	public void setGame (int g) {
		if (g ==1)
			setup(0, 16);
		else if (g == 2)
			setup(16, 32);
		else if (g == 3)
			setup(32, 48);
	}
	
	// Sets up grid, g, with the data from input from the min value to the max value
	public void setup(int min, int max) {
		int x = 0, y = 0;
		for (int i = min; i < max - 1; i += 2) {
			x = input[i];
			y = input[i + 1];
			grid[x][y] = 1;
//			// Prints the x, y coordinates that are being stored in grid
//			System.out.println(x + "," + y);
//			//
		}
//		// Prints the values stored in grid
//		for (int[] n : grid) {
//			for (int m : n) {
//				System.out.print(m);
//			}
//			System.out.println("");
//		}
//		System.out.println("");
//		//
	}
	
	// Reads and saves data from input.txt to input
	public void readInputFile() {
		try {
			FileReader inputFile = new FileReader("input.txt");
			BufferedReader reader = new BufferedReader(inputFile);
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line,"(,)");
				while(tokenizer.hasMoreTokens()) {
					input[i] = Integer.parseInt(tokenizer.nextToken());
					i++;
				}
			}
			reader.close();
			inputFile.close();
//			// Prints the values stored in input
//			for (int l:input) {
//				System.out.print(l);
//			}
//			System.out.println("");
//			//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testSearch() {	
		readInputFile();
		
		// Iterates through the three searches, prints a grid before and after searching, and gives the amount of cells searched for game setup one
		searchBehavior.printGrid(grid);
		searchBehavior.search(grid);
		System.out.println(searchBehavior.name() + " searched " + searchBehavior.cellsSearched() + " cells before finding all of the ships.");
//		searchBehavior.printGrid(grid);
	}
}