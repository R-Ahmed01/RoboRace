package Main;

import GridLocations.*;

public class EntityFactory {
	public static IGridEntity createEntity(char symbol) {
		switch (symbol) {
		case 'X' :
			return new Pit();
		case '+' :
			return new GearCW();
		case '-' :
			return new GearCCW();
		case '1':
			return new Flag();
		case '2':
			return new Flag();
		case '3':
			return new Flag();
		case '4':
			return new Flag();
		case 'A':
			return new Robot(null);
		case 'B':
			return new Robot(null);
		case 'C':
			return new Robot(null);
		case 'D':
			return new Robot(null);
		case '.':
			break;
			//Add all of the Symbols
		}
		return null;
	}
}
