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

public class Grid {

	private int height;
	private int width;
	public IGridEntity[][] entities;
	private char[][] board;
	
	public Grid (File file) throws FileNotFoundException, IOException {
		ArrayList<String> grid = readLines(file);
		height = grid.size();
		 board = new char[height][width];
		 entities = new IGridEntity[height][width];
		
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
	}
	
	public Robot robotAtPosition(LinkedList<Robot>robots, int x, int y) {
		for(int i=0;i<robots.size(); i++) {
			Robot robot = robots.get(i);
			if(robot.x == x && robot.y == y) {
				return robot;
			}
		}
		return null;
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
}
