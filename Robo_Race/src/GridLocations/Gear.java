package GridLocations;

public class Gear implements IGridEntity {

	@Override
	public void act(Robot robot) {
		// TODO Auto-generated method stub
		/**
		 * Represented as +, -
		 * If robot location is gear
		 * Robot is directed counterclockwise/clockwise
		 */
		if(robot == null) {//if there isnt a robot at this position do nothing
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
	
	char gear;
	public Gear(char gearType) {
		gear = gearType;
	}
	
	public String toString() {
		return Character.toString(gear);
	}
}
