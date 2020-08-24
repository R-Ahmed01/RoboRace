package Main;
import GridLocations.*;
/**
 * The EntityFactory Class
 * 
 * @author Team 13: Daniel, Hayley, Rifath
 * 
 * Handles the Entity symbols
 */
public class EntityFactory {
	/**
	 * Creates Entities based on symbols
	 * @param symbol
	 * @return
	 */
	public static IGridEntity createEntity(char symbol) {
		switch (symbol) {
		case 'X' :
			return new Pit();
		case '+' :
		case '-' :
			return new Gear(symbol);
		case '1':
		case '2':
		case '3':
		case '4':
			return new Flag(Character.getNumericValue(symbol));
		case 'A':
		case 'B':
		case 'C':
		case 'D':
			return new Robot(symbol);
		case '^':
		case '>':
		case '<':
		case 'v':
			return new Conveyor(symbol);
		case '.':
			return new EmptyTile();
		}
		return null;
	}
}
