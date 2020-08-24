package GridLocations;

public interface IGridEntity {

	/**
	 *  Idea
		public char id() {
			//returns GridLocationId e.g. 1, X, -, +
		}
	 * 
	 */
	
	public void act(Robot robot);
	//All Grid Locations should act if landed on by robot
	
}
