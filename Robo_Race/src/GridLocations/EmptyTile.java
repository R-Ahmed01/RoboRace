package GridLocations;
/**
 * The EmptyTile Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the Empty Tile Entities that are represented 
 * by "." on the board.
 */
public class EmptyTile implements IGridEntity{

	/**
	 * Override the act method from the interface
	 * @param robot
	 */
	@Override
	public void act(Robot robot) {
		/**
		 * If the robot location is empty tile do nothing
		 */
	}
	
	/**
	 * Returns a string of "."
	 */
	public String toString() {
		return ".";
	}
}
