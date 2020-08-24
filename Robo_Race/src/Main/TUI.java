package Main;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import GridLocations.Grid;
import GridLocations.Robot;
/**
 * The TUI Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Responsible for the Text User Interface.
 */
public class TUI {

	private List<Character> allowedMoves;
	
	/**
	 * The TUI Constructor
	 */
	public TUI() {
		Character[] allowedMovements = { 'F', 'B', 'L', 'R', 'U', 'W' };
		this.allowedMoves = Arrays.asList(allowedMovements);
	}
	
	/**
	 * Prompts the player to enter moves
	 * @return String
	 */
	public String promptMoves() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter player moves:");
        if (sc.hasNextLine()) {
        	return sc.nextLine();
        }
        return "";
	}
	
	/**
	 * Checks entered moves are valid
	 * @param input
	 * @return boolean
	 */
	public boolean areMovesValid(String input) {
		char[] movements = input.toCharArray();
		char lastMovement = ' ';
		int numberOfMoves = input.length();
		
		if (numberOfMoves != 5) {
			System.err.println("Must enter 5 moves, no more or less.");
			return false;
		}
		
		
		for (char move : movements) {
		    if (move == lastMovement) {
		    	System.err.println("Duplicate move is not allowed");
		    	return false;
		    }
		    if (!allowedMoves.contains(move)) {
		    	System.err.println("Unknown move is not allowed");
		    	return false;
		    }
		    lastMovement = move;
		}
		return true;
	}
	
	/**
	 * Displays the board entities
	 * @param grid
	 * @param robots
	 */
	public void showBoard(Grid grid, LinkedList<Robot>robots) {
		StringBuilder boardString = new StringBuilder();
		for(int i=0; i<grid.entities.length; i++) {
			for(int j=0; j<grid.entities[i].length; j++) {
				Robot robot = grid.robotAtPosition(robots, j, i);
				if(robot == null) {
					boardString.append("[" + grid.entities[i][j].toString() + "]");
				}
				else {
					boardString.append("[" + robot.toString() + "]");
				}
			}
			boardString.append("\n");
		}
		System.out.println(boardString);
	}
}



