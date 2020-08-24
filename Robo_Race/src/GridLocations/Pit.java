package GridLocations;

public class Pit implements IGridEntity{

	@Override
	public void act(Robot robot) {
		// TODO Auto-generated method stub
		/**
		 * Represented as X
		 * If robot location is pit
		 * robot is destroyed and returned to start
		 */
		if(robot == null) {//if there isnt a robot at this position do nothing
			return;
		}
		robot.x = robot.startingX;
		robot.y = robot.startingY;
	}
	
	public String toString() {
		return "X";
	}

}
