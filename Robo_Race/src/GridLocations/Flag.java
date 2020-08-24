package GridLocations;
/**
 * The Flag Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the Flag Grid Entities that are represented 
 * by "1, 2, 3, 4" on the board. If robot location is flag
 * Check correct flag order and activate if it is. Robot 
 * can now pick up next flag required.
 */
public class Flag implements IGridEntity{

	/**
	 * Override the act method from the interface
	 * @param robot
	 * If there isn't a robot at this position, do
	 * nothing, else check correct flag and add so robot 
	 * can move onto next flag
	 */
	@Override
	public void act(Robot robot) {
		if(robot == null) {
			return;
		}
		if(robot.flag+1 == number) {
			robot.flag++;
		}
	}
	
	
	/**
	 * Flag Constructor
	 * @param flagNumber
	 */
	int number;
	public Flag(int flagNumber) {
		number = flagNumber;
	}
	
	/**
	 * Convert int to a string
	 */
	public String toString() {
		return Integer.toString(number);
	}
}