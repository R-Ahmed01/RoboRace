package GridLocations;

import java.util.*;

public class Robot implements IGridEntity{
	private LinkedList<Character> actions; 
	public int x;
	public int y;
	private Character direction;
	public int flag;
	public int startingX;
	public int startingY;
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
	public void act(Robot robot) {
		if(robot == null) {
			return;
		}
		switch(direction) {
		case 'N':
		 	robot.y--;
			break;
		case 'E':
			robot.x++;
			break;
		case 'S':
			robot.y++;
			break;
		case 'W':
			robot.x--;
			break;
		}
	}
	
	public void storedActions(LinkedList<Character> actions) {
		this.actions = actions;
	}
	
	public boolean hasActions() {
		return actions.size()>0;
	}
	
	public void turn(LinkedList<Robot> robots){
		
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
		checkOffGrid(robots);
	}
	
	public void checkOffGrid(LinkedList<Robot> robots) {
        if (x > Grid.width || y > Grid.height || x < 0 || y < 0) {
            x = startingX; //Check if another robot is there
            y = startingY;
        }
    }
	
	public void moveForward() {
		switch(direction) {
		case 'N':
			 	y--;
			break;
		case 'E':
				x++;
			break;
		case 'S':
				y++;
			break;
		case 'W':
				x--;
			break;
		}
	}
	
	public void moveBackwards() {
		switch(direction) {
		case 'N':
			 	y++;
			break;
		case 'E':
				x--;
			break;
		case 'S':
				y--;
			break;
		case 'W':
				x++;
			break;
		}
	}

	public void rotateLeft() {
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

	public void rotateRight() {
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
