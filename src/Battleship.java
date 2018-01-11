
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.StringTokenizer;

public class Battleship {
	private SearchBehavior searchBehavior;
	private static int[] input;
	public int[][] grid;

	// Sets default search strategy
	public Battleship() {
		searchBehavior = new HorizontalSearch();
	}
	
	// Reads and saves data from input.txt to input
	public static void readInputFile() {
		String fileName = "input.txt";
		try {
			FileReader inputstream = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(inputstream);
			String game;
			int i = 0;
			while ((game = reader.readLine()) != null) {
				String[] sp = game.split("(");
				input[i] = Integer.parseInt(sp[0]);
				i++;
			}
			reader.close();
			inputstream.close();
			//
			for (int l:input) {
				System.out.println(l);
			}
			//
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	public static void main (String[] args) {
		readInputFile();
	}

}
