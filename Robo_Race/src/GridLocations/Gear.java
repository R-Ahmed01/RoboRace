package GridLocations;

public class Gear implements IGridEntity {

	@Override
	public void act() {
		// TODO Auto-generated method stub
		/**
		 * Represented as +, -
		 * If robot location is gear
		 * Robot is directed counterclockwise/clockwise
		 */
	}
	
	String gear;
	public Gear(String gearType) {
		gear = gearType;
	}
	
	public String toString() {
		return gear;
	}
}