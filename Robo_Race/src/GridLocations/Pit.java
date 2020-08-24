package GridLocations;
/**
 * The Pit Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the Pit Grid Entities that are represented 
 * by "X" on the board. If robot location is pit, then 
 * the robot is destroyed and returned to starting position
 */
public class Pit implements IGridEntity{

	/**
	 * Override the act method from the interface
	 * @param robot
	 * If there isn't a robot at this position, do
	 * nothing, else return the robot to starting position
	 */
	@Override
	public void act(Robot robot) {

		if(robot == null) {
			return;
		}
		robot.x = robot.startingX;
		robot.y = robot.startingY;
	}
	
	/**
	 * returns a string of X
	 */
	public String toString() {
		return "X";
	}

}
