package GridLocations;

import java.util.*;

public class Robot implements IGridEntity{

	private LinkedList<Character> actions; 
	private int x;
	private int y;
	private Character direction;
	
	public char robot;
	public Robot (char player) {
		robot = player;
		direction = 'N';
		actions = new LinkedList<Character>();
	}
	
	public String toString() {
		return Character.toString(robot);
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		/**
		 * Represented as A, B, C, D
		 * If robot location is another robot then 
		 * moving robot pushes other robot in direction its going
		 */
		
	}
	
	public void storedActions(LinkedList<Character> actions) {
		this.actions = actions;
	}
	
	public boolean hasActions() {
		return actions.size()>0;
	}
	
	public void turn(){
		
		if(actions.size() < 1) {
			return;
		}
		
		var action = actions.remove();
		switch (action) {
			case 'F':
				moveForward();
				break;
			case 'B':
				moveBackwards();
				break;
			case 'L':
				rotateLeft();
				break;
			case 'R':
				rotateRight();
				break;
			case 'U':
				Uturn();
				break;
			case 'W':
				break;
		}
	}
	
	public void moveForward() {
		switch(direction) {
		case 'N':
			 	y++;
			break;
		case 'E':
				x++;
			break;
		case 'S':
				y--;
			break;
		case 'W':
				x--;
			break;
		}
	}
	
	public void moveBackwards() {
		switch(direction) {
		case 'N':
			 	y--;
			break;
		case 'E':
				x--;
			break;
		case 'S':
				y++;
			break;
		case 'W':
				x++;
			break;
		}
	}

	private void rotateLeft() {
		switch(direction) {
		case 'N':
			 	direction = 'W';
			break;
		case 'E':
			direction = 'N';
			break;
		case 'S':
			direction = 'E';
			break;
		case 'W':
			direction = 'S';
			break;
		}
	}

	private void rotateRight() {
		switch(direction) {
		case 'N':
			 direction = 'E';
			break;
		case 'E':
			direction = 'S';
			break;
		case 'S':
			direction = 'W';
			break;
		case 'W':
			direction = 'N';
			break;
		}
	}
	
	private void Uturn() {
		switch(direction) {
		case 'N':
			 direction = 'S';
			break;
		case 'E':
			direction = 'W';
			break;
		case 'S':
			direction = 'N';
			break;
		case 'W':
			direction = 'E';
			break;
		}
	}
}
