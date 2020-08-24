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
import java.util.LinkedList;

import Main.EntityFactory;
/**
 * The Grid Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the Grid Entities read from the board file
 */
public class Grid {

	public static int height;
	public static int width;
	public IGridEntity[][] entities;
	
	/**
	 * The Grid Constructor
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Grid (File file) throws FileNotFoundException, IOException {
		ArrayList<String> grid = readLines(file);
		height = grid.size();
		entities = new IGridEntity[height][width];
		int lineCounter = 0;
		for(String line : grid) {
			for(int i = 0; i < line.length(); i++) {
				entities[lineCounter][i] = EntityFactory.createEntity(line.charAt(i));
			}
			lineCounter++;
		}	
	}
	
	/**
	 * Robot Position on the board
	 * @param robots
	 * @param x
	 * @param y
	 * @return Robot
	 */
	public Robot robotAtPosition(LinkedList<Robot>robots, int x, int y) {
		for(int i=0;i<robots.size(); i++) {
			Robot robot = robots.get(i);
			if(robot.x == x && robot.y == y) {
				return robot;
			}
		}
		return null;
	}
	
	/**
	 * Reads the file line by line
	 * @param file
	 * @return ArrayList<String>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private ArrayList<String> readLines(File file) throws FileNotFoundException, IOException{
		ArrayList<String> Lines = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			ArrayList<ArrayList<Character>> grid = new ArrayList<ArrayList<Character>>();
		    String line;
		    int lineCounter = 0;
		    while ((line = br.readLine()) != null) {
		    	
		    	if(!line.toLowerCase().contains("format")) {
		    		Lines.add(line);
		    		width = line.length();
		    	}
		   	}
		  }
		return Lines;
	}
}
