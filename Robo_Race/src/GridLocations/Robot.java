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
		// TODO Auto-generated method stub
		/**
		 * Represented as A, B, C, D
		 * If robot location is another robot then 
		 * moving robot pushes other robot in direction its going
		 */
		if(robot == null) {//if there isnt a robot at this position do nothing
			return;
		}
		//need to know your direction and change x & y
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
		//Checks if another robot is in its place and need to move it
        for(int i = 0; i < robots.size(); i++) {

            var otherRobot = robots.get(i);

            if (otherRobot == this) {
                continue;
            }

            if(x == otherRobot.x && y == otherRobot.y) {
                // push other robot 
                // create switch statement to do the pushing
                otherRobot.checkOffGrid(robots);

            }
        }
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
		}//if x is greater than width or y id greater than height or either less than 0, return to start 
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
