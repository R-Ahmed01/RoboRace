package GridLocations;
/**
 * The Conveyor Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the Conveyor Grid Entities that are represented 
 * by "<, >, ^, v" on the board. These move the robot in direction
 * by one space.
 */
public class Conveyor implements IGridEntity {

	/**
	 * Override the act method from the interface
	 * @param robot
	 * If there isn't a robot at this position, do
	 * nothing, else depending on the symbol move 
	 * the robot in direction.
	 */
	@Override
	public void act(Robot robot) {
		if(robot == null) {
			return;
		}
		switch(direction) {
		case '^':
			robot.y--;
			break;
		case '>':
			robot.x++;
			break;
		case '<':
			robot.x--;
			break;
		case 'v':
			robot.y++;
			break;
		}
	}
	
	/**
	 * Conveyor Constructor
	 * @param direction
	 */
	char direction;
	public Conveyor(char direction) {
		this.direction = direction;
	}
	
	/**
	 * Converts a char to a string
	 */
	public String toString() {
		return Character.toString(direction);
	}
}
