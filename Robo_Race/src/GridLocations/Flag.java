package GridLocations;

public class Flag implements IGridEntity{

	@Override
	public void act(Robot robot) {
		// TODO Auto-generated method stub
		/**
		 * Represented as 1, 2, 3, 4
		 * If robot location is flag
		 * Check correct flag order and activate if it is
		 * Update robot on next flag required
		 */
		if(robot == null) {//if there isnt a robot at this position do nothing
			return;
		}
		if(robot.flag+1 == number) {
			robot.flag++;
		}
	}
	
	int number;
	public Flag(int flagNumber) {
		number = flagNumber;
	}
	
	public String toString() {
		return Integer.toString(number);
	}
}