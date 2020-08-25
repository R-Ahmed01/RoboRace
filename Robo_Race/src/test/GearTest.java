package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import GridLocations.Grid;
import GridLocations.Robot;
import Main.Game;

public class GearTest {

	@Test
	public void gearTest() throws FileNotFoundException, IOException {
		
		//Arrange
		String relativePath = new File("").getAbsolutePath();
		File file = new File(relativePath + "/Tests/our-board/gears.brd");
		Grid game = new Grid(file);
		Robot r = new Robot('A');
		var startingY = r .startingY;
		
		//Act
		r.rotateRight();
		r.moveForward();
		r.moveForward();
		r.moveForward();
		
		var endingY = r.y;
		
		assertEquals(startingY, endingY);
	}

}