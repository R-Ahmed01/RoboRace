package GridLocations;
/**
 * The Gear Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the Gear Grid Entities that are represented 
 * by "+, -" on the board. If robot location is gear, then 
 * the robot is rotated clockwise (+) or counter-clockwise (-)
 */
public class Gear implements IGridEntity {

	/**
	 * Override the act method from the interface
	 * @param robot
	 * If there isn't a robot at this position, do
	 * nothing, else check gear type and rotate
	 */
	@Override
	public void act(Robot robot) {
		if(robot == null) {
			return;
		}
		switch(gear) {
		case '+':
			robot.rotateRight();
			break;
		case '-':
			robot.rotateLeft();
			break;
		}
	}
	
	/**
	 * The Gear Constructor
	 * @param gearType
	 */
	char gear;
	public Gear(char gearType) {
		gear = gearType;
	}
	
	/**
	 * Converts a character to a string
	 */
	public String toString() {
		return Character.toString(gear);
	}
}
