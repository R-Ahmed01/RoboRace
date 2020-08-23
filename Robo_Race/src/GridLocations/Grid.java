package GridLocations;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import Main.EntityFactory;

public class Grid {

	private int height;
	private int width;
	public IGridEntity[][] entities;
	private char[][] board;
	
	public Grid (File file) throws FileNotFoundException, IOException {
		ArrayList<String> grid = readLines(file);
		height = grid.size();
		 board = new char[height][width];
		 entities = new EmptyTile[height][width];
		
		 /**
		  * So create a Switch Statement depending on what the character is
		  */
		 
		int lineCounter = 0;
		for(String line : grid) {
			for(int i = 0; i < line.length(); i++) {
				board[lineCounter][i] = line.charAt(i); // switch on the character 
				
				entities[lineCounter][i] = EntityFactory.createEntity(line.charAt(i));
				
				
			}
			lineCounter++;
		}
		//System.out.println(Arrays.deepToString(board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	}
	
	private ArrayList<String> readLines(File file) throws FileNotFoundException, IOException{
		ArrayList<String> Lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			ArrayList<ArrayList<Character>> grid = new ArrayList<ArrayList<Character>>();
		    String line;
		    int lineCounter = 0;
		    while ((line = br.readLine()) != null) {
		    	
		    	if(!line.toLowerCase().contains("format")) {
		    		Lines.add(line);
		    		//height++;
		    		width = line.length();
		    	}
		   	}
		  }
		return Lines;
	}
	
	
	public void render(int x, int y, IGridEntity tileType) {
		
		/**
		 * Location becomes part of render
		 * loops throough 2D array of I grid entities
		 * calls print method for each
		 * Add print method to IGrid
		 * or return and build upon string
		 */
		
		// loop through entities
		// and get there print characters printed out
		//IGridentity need to have a print character - property of char
		
		
		System.out.println(Arrays.deepToString(board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
	System.out.println("\n");
	System.out.println("\n");
	
	System.out.println("\n");

	}
}
