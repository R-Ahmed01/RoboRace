package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TUI {

	private List<Character> allowedMoves;
	
	public TUI() {
		Character[] allowedMovements = { 'F', 'B', 'L', 'R', 'U', 'W' };
		this.allowedMoves = Arrays.asList(allowedMovements);
	}
	
	public String promptMoves() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter player moves:");
        if (sc.hasNextLine()) {
        	return sc.nextLine();
        }
        return "";
	}
	
	public boolean areMovesValid(String input) {
		char[] movements = input.toCharArray();
		char lastMovement = ' ';
		int numberOfMoves = input.length();
		
		if (numberOfMoves != 5) {
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
	
	public static void main(String[] args) {
		TUI tui = new TUI();
		String moves = tui.promptMoves();
		while (!tui.areMovesValid(moves)) {
			moves = tui.promptMoves();
		}
	}
}



