package Main;

import GridLocations.*;

public class EntityFactory {
	public static IGridEntity createEntity(char symbol) {
		switch (symbol) {
		case 'X' :
			return new Pit();
			
			//Add all of the Symbols
		}
		return null;
	}
}
