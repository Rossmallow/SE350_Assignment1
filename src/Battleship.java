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
	private static SearchBehavior searchBehavior;
	private static int[] input = new int[48]; 	// There are 48 integers that make up the 24 coordinates necessary to set up 3 games
	private static int[][] grid;

//	// Sets default search strategy
//	public Battleship() {
//		searchBehavior = new HorizontalSearch();
//	}
	
	public static void main (String[] args) {
		readInputFile();
		
		// Sets up grid in game one formation
		setup(grid, 0, 16);
		
		searchBehavior = new StrategicSearch();
		searchBehavior.printGrid(grid);
		searchBehavior.search(grid);
		System.out.println(searchBehavior.name() + " searched " + searchBehavior.cellsSearched() + " cells before finding all of the ships.");
		searchBehavior.printGrid(grid);
		
		// Sets up grid in game two formation
		setup(grid, 16, 32);
		
		// Sets up grid in game three formation
		setup(grid, 32, 48);
	}

	// Reads and saves data from input.txt to input
	public static void readInputFile() {
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
	
	// Sets up grid, g, with the data from input from the min value to the max value
	public static void setup(int[][] g, int min, int max) {
		grid = new int[25][25];
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
}