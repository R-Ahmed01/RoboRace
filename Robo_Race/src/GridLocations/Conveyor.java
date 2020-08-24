package GridLocations;

public class Conveyor implements IGridEntity {

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
	
	char direction;
	public Conveyor(char direction) {
		this.direction = direction;
	}
	
	public String toString() {
		return Character.toString(direction);
	}
}
