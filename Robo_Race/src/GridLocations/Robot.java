package GridLocations;
import java.util.*;
/**
 * The Robot Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the Pit Grid Entities that are represented 
 * by "A, B, C, D" on the board. If robot location is robot, then 
 * the robot in the location it is moving to is pushed
 */
public class Robot implements IGridEntity{
	private LinkedList<Character> actions; 
	public int x;
	public int y;
	private Character direction;
	public int flag;
	public int startingX;
	public int startingY;
	public char robot;
	
	/**
	 * The Robot Constructor
	 * @param player
	 */
	public Robot (char player) {
		robot = player;
		direction = 'N';
		actions = new LinkedList<Character>();
	}
	
	/**
	 * Converts a Character to a string
	 */
	public String toString() {
		return Character.toString(robot);
	}

	/**
	 * Override the act method from the interface
	 * @param robot
	 * If there isn't a robot at this position, do
	 * nothing, else push robot in direction
	 */
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
	
	/**
	 * List of stored actions
	 * @param actions
	 */
	public void storedActions(LinkedList<Character> actions) {
		this.actions = actions;
	}
	
	/**
	 * Check for actions
	 * @return boolean
	 */
	public boolean hasActions() {
		return actions.size()>0;
	}
	
	/**
	 * Actions for a robot turn
	 * @param robots
	 */
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
	
	/**
	 * Check robot hasn't moved off the board
	 * @param robots
	 */
	public void checkOffGrid(LinkedList<Robot> robots) {
        if (x > Grid.width || y > Grid.height || x < 0 || y < 0) {
            x = startingX;
            y = startingY;
        }
    }
	
	/**
	 * Move Forward Function
	 */
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
	
	/**
	 * Move Backward Function
	 */
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

	/**
	 * Rotate Left Function
	 */
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

	/**
	 * Rotate Right Function
	 */
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
	
	/**
	 * U Turn Function
	 */
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
