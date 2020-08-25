package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import GridLocations.Grid;
import GridLocations.Robot;
import Main.Game;

public class ConveyorTest {

	@Test
	public void ConveyerTest() throws FileNotFoundException, IOException {
		
		//Arrange
		String relativePath = new File("").getAbsolutePath();
		File file = new File(relativePath + "/Tests/our-board/conveyor.brd");
		Grid game = new Grid(file);
		Robot r = new Robot('A');
		var startingX = r .startingX;
		
		//Act
		r.rotateRight();
		r.moveForward();
		r.moveBackwards();
		r.rotateLeft();
		r.moveForward();
		
		var endingX = r.x;
		
		//Arrange
		assertNotEquals(startingX, endingX);
	}

}


